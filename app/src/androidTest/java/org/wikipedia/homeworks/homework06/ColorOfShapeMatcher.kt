package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

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