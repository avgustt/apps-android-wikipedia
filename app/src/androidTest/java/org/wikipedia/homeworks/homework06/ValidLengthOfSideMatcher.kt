package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class ValidLengthOfSideMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("the length of side is correct")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.lengthOfSide >= 0
    }
}