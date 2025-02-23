package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class AnnounceCardViewItem(matcher: Matcher<View>): KRecyclerItem<AnnounceCardViewItem>(matcher) {

    val BigScreen = KTextView(matcher){
        withId(R.id.view_announcement_header_image)
    }

    val textForAnnounceCardViewItem = KTextView(matcher) {
        withId(R.id.view_announcement_text)
    }

    val positiveAnnounceButton = KButton(matcher) {
        withId(R.id.view_announcement_action_positive)
    }

    val negativeAnnounceButton = KButton(matcher) {
        withId(R.id.view_announcement_action_negative)
    }

}