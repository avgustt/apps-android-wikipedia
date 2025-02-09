package org.wikipedia.homeworks.homework04

import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Schedule {

    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()

    private var day: Days? = null

    operator fun invoke(function: Schedule.() -> Unit) {
        function(this)
    }

    fun monday(function: () -> Unit) {
        setScheduleInDay(Days.MONDAY, function)
    }

    fun tuesday(function: () -> Unit) {
        setScheduleInDay(Days.TUESDAY, function)
    }

    fun wednesday(function: () -> Unit) {
        setScheduleInDay(Days.WEDNESDAY, function)
    }

    fun thursday(function: () -> Unit) {
        setScheduleInDay(Days.THURSDAY, function)
    }

    fun friday(function: () -> Unit) {
        setScheduleInDay(Days.FRIDAY, function)
    }

    fun saturday(function: () -> Unit) {
        setScheduleInDay(Days.SATURDAY, function)
    }

    fun sunday(function: () -> Unit) {
        setScheduleInDay(Days.SUNDAY, function)
    }

    private fun setScheduleInDay(day: Days, function: () -> Unit) {
        this.day = day
        function()
        this.day = null
    }

    operator fun String.rangeTo(endAt: String): Pair<LocalTime, LocalTime> {
        return Pair(LocalTime.parse(this, timeFormatter), LocalTime.parse(endAt, timeFormatter))
    }

    infix fun Pair<LocalTime, LocalTime>.schedule(lesson: String) {
        day?.let {
            addSchedule(it, ScheduleEntity(lesson, first, second))
        } ?: throw IllegalStateException("Не установлен день недели")
    }

    override fun toString(): String {
        return scheduleOfWeek.toSortedMap()
            .map { (day, list) ->
                list.sortedBy { it.startTime }
                    .joinToString("\n") {
                        "%-15s${it.startTime.format(timeFormatter)} - ${
                            it.endTime.format(
                                timeFormatter
                            )
                        }".format("\t${it.lesson}:")
                    }.let {
                        "${day.name.lowercase().replaceFirstChar { day.name[0].uppercase() }}:\n$it"
                    }
            }.joinToString("\n\n")
    }

    private fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
        scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
    }
}