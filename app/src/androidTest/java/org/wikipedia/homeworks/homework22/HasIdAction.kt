package org.wikipedia.homeworks.homework22

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class HasIdAction(private val id: Int) : ViewAction {

    private var result = false

    fun getResult(): Boolean = result

    override fun getConstraints(): Matcher<View> =
        ViewMatchers.isAssignableFrom(View::class.java)

    override fun getDescription(): String = "View has id or contains child with id"

    override fun perform(uiController: UiController?, view: View?) {
        view ?: throw AssertionError("View is null")
        result = view.id == id || view.findViewById<View>(id) != null
    }
}
