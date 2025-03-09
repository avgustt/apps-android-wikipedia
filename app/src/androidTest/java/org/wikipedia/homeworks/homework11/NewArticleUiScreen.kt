package org.wikipedia.homeworks.homework11

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.screen.UiScreen

object NewArticleUiScreen: UiScreen<NewArticleUiScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val articleImage = UiView {
        withId(
            packageName = this@NewArticleUiScreen.packageName,
            resourceId = "view_page_header_image"
        )
    }
}