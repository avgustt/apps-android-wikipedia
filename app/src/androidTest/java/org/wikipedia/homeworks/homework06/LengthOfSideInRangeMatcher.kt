package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

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