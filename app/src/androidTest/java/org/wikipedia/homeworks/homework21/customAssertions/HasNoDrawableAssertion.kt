package org.wikipedia.homeworks.homework21.customAssertions

import android.view.View
import android.widget.ImageView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert


class HasNoDrawableAssertion : ViewAssertion {
    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (view is ImageView) {
            Assert.assertNull("Should not have drawable", view.drawable)
        } else {
            throw noViewFoundException ?: AssertionError("View is not ImageView")
        }
    }
}
