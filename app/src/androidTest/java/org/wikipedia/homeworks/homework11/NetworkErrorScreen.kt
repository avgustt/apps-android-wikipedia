package org.wikipedia.homeworks.homework11

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

object NetworkErrorScreen: UiScreen<NetworkErrorScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val retryButton = UiButton {
        withId(
            packageName = this@NetworkErrorScreen.packageName,
            resourceId = "view_wiki_error_button"
        )
    }
}