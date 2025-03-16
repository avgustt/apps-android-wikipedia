package org.wikipedia.lessons.lesson13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object ArticlViewScreen : KScreen<ArticlViewScreen>() {
    override val layoutId: Int?
        get() = null
    override val viewClass: Class<*>?
        get() = null

    val vebView = KWebView {
        withId(R.id.page_web_view)
    }

}