package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

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