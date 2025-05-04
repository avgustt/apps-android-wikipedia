package org.wikipedia.homeworks.homework026

class ListOfSmartScenario(private val list: List<BaseSmartScenario>) {
    fun execute() = list.any { it.init() }
}