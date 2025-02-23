package org.wikipedia.homeworks.homework08.screen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<LanguageItem>(matcher) {

    val languageName = KTextView(matcher) {
        withId(R.id.option_label)
    }
}