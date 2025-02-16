package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class NegativeNumberOfSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("the number of sides is negative")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.numberOfSides < 0
    }
}