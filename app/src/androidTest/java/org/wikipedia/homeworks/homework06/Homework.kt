package org.wikipedia.homeworks.homework06
import org.hamcrest.Matchers.anyOf

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