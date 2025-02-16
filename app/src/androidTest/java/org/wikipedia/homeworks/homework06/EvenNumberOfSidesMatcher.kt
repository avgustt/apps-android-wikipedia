package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class EvenNumberOfSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("the shape has an even number of sides")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return (shape.numberOfSides %2) == 0
    }

}