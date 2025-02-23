package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class DayHeaderCardViewItem(matcher: Matcher<View>): KRecyclerItem<DayHeaderCardViewItem>(matcher) {

    val dataText = KTextView(matcher) {
        R.id.day_header_text
    }
}