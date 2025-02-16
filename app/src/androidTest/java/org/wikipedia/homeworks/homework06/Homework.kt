package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.hamcrest.TypeSafeMatcher

data class Shape(val lengthOfSide: Float, val numberOfSides: Int, val color: Color)

enum class Color { RED, BLUE, GREEN, YELLOW, BLACK, WHITE }

class LengthOfSideInRangeMatcher(
    private val min: Float,
    private val max: Float
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("length between $min and $max")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.lengthOfSide in min..max
    }
}

class NumberOfAnglesMatcher(
    private val numberOfAngles: Int
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        when(numberOfAngles) {
            0 -> description.appendText("the shape has no angles")
            1 -> description.appendText("number of angles is incorrect")
            2 -> description.appendText("number of angles is incorrect")
            else -> description.appendText("number of angles is $numberOfAngles")
        }
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return when(numberOfAngles) {
            0 -> (shape.numberOfSides == 1)||(shape.numberOfSides == 2)
            1 -> false
            2 -> false
            else -> shape.numberOfSides == numberOfAngles
        }
    }
}

class EvenNumberOfSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("the shape has an even number of sides")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return (shape.numberOfSides %2) == 0
    }

}

class ColorOfShapeMatcher(
    private val color: Color
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("color is $color")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.color == color
    }
}

class NegativeLengthOfSideMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("the length of side is negative")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.lengthOfSide < 0
    }
}

class ValidLengthOfSideMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("the length of side is correct")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.lengthOfSide >= 0
    }
}

class NegativeNumberOfSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("the number of sides is negative")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.numberOfSides < 0
    }
}

class ValidNumberOfSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("the number of sides is correct")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.numberOfSides >= 0
    }
}

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


fun main() {
    val shapes = listOf(
        Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
        Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
        Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
        Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
        Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
        Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
        Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
    )

    val matchers = anyOf(
        //LengthOfSideInRangeMatcher(1f, 20f),
        //NumberOfAnglesMatcher(0))
        //ColorOfShapeMatcher(Color.GREEN)
        //EvenNumberOfSidesMatcher()
        NegativeLengthOfSideMatcher(),
        NegativeNumberOfSidesMatcher()
    )
    val result = shapes.filter { matchers.matches(it) }
    println("Result: $result")


    val builderIncorrectShapes = MatcherShapeBuilder()
    builderIncorrectShapes {
        detectNegativeLength()
        detectNegativeNumberOfSides()
    }
    val incorrectShapes = shapes.filter { builderIncorrectShapes.buildAnyMatchers().matches(it) }
    println("Invalid shapes: $incorrectShapes")

    val builderValidShapes = MatcherShapeBuilder()
    builderValidShapes {
        detectValidLength()
        detectValidNumberOfSides()
    }
    val validShapes = shapes.filter { builderValidShapes.buildAnyMatchers().matches(it) }
    println("Valid shapes: $validShapes")

    val builderValidBigBlackShapes = MatcherShapeBuilder()
    builderValidBigBlackShapes {
        length(20f, 50f)
        color(Color.BLACK)
        detectValidLength()
        detectValidNumberOfSides()
    }
    val validSmallBlackShapes = shapes.filter { builderValidBigBlackShapes.buildAllMatchers().matches(it) }
    println("Valid big black shapes: $validSmallBlackShapes")

    val builderLines = MatcherShapeBuilder()
    builderLines {
        angles(0)
    }
    val lines = shapes.filter { builderLines.buildAllMatchers().matches(it) }
    println("Lines: $lines")

    val builderSquares = MatcherShapeBuilder()
    builderSquares {
        angles(4)
    }
    val squares = shapes.filter { builderSquares.buildAllMatchers().matches(it) }
    println("Squares: $squares")
}