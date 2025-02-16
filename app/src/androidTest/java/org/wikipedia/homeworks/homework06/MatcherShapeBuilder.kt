package org.wikipedia.homeworks.homework06

import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf

class MatcherShapeBuilder() {
    private val listOfMatchers = mutableListOf<Matcher<Shape>>()
    operator fun invoke(function: MatcherShapeBuilder.() -> Unit) {
        function()
    }
    fun length(min: Float, max: Float) {
        listOfMatchers.add(LengthOfSideInRangeMatcher(min, max))
    }
    fun angles(numberOfAngles: Int) {
        listOfMatchers.add(NumberOfAnglesMatcher(numberOfAngles))
    }
    fun detectNegativeLength() {
        val negativeLengthOfSideMatcher = NegativeLengthOfSideMatcher()
        listOfMatchers.add(negativeLengthOfSideMatcher)
    }
    fun detectValidLength() {
        val validLengthOfSideMatcher = ValidLengthOfSideMatcher()
        listOfMatchers.add(validLengthOfSideMatcher)
    }
    fun detectNegativeNumberOfSides() {
        val negativeNumberOfSidesMatcher = NegativeNumberOfSidesMatcher()
        listOfMatchers.add(negativeNumberOfSidesMatcher)
    }
    fun detectValidNumberOfSides() {
        val validNumberOfSidesMatcher = ValidNumberOfSidesMatcher()
        listOfMatchers.add(validNumberOfSidesMatcher)
    }
    fun color(shapeColor: Color) {
        listOfMatchers.add(ColorOfShapeMatcher(shapeColor))
    }
    fun buildAllMatchers() = allOf(listOfMatchers)
    fun buildAnyMatchers() = anyOf(listOfMatchers)
}