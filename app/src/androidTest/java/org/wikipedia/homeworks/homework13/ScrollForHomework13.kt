package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object ScrollForHomework13 : KScreen<ScrollForHomework13>() {
    override val layoutId = null
    override val viewClass = null

    val readArticleButton = KButton{
        withId(R.id.link_preview_primary_button)
    }
}