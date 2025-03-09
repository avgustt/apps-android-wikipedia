package org.wikipedia.homeworks.homework09

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.hamcrest.Matcher

class NewsCardItem(matcher: Matcher<View>) : KRecyclerItem<NewsCardItem>(matcher) {
    val thirdPage = KView(matcher) {
        withId(R.id.view_list_card_number)
    }

    val thirdText = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val third_Text =KView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }

    val articleTitle = KTextView(matcher) {
        withId(R.id.story_text_view)
    }

}