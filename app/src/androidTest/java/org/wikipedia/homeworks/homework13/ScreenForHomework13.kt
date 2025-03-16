package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ScreenForHomework13 : KScreen<ScreenForHomework13>() {
    override val layoutId = null
    override val viewClass = null

    val titleText = KTextView{
        withId(R.id.reference_title_text)
    }
    val number = KTextView{
        withId(R.id.reference_id)
    }
    val text = KTextView{
        withId(R.id.reference_text)
    }
}