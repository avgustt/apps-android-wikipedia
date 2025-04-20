package org.wikipedia.homeworks.homework21.customAssertions

import android.view.View
import android.widget.TextView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert


class CustomAssertion(private val expectedText: String) : ViewAssertion {
    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (view is TextView) {
            Assert.assertEquals("Expected text: '$expectedText'", expectedText, view.text.toString())
        } else {
            throw noViewFoundException ?: AssertionError("View is not TextView")
        }
    }
}
