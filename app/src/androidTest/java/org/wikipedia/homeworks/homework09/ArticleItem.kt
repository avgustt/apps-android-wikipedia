package org.wikipedia.homeworks.homework09

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class ArticleItem(matcher: Matcher<View>) : KRecyclerItem<ArticleItem>(matcher) {
    val title = KTextView(matcher) { withId(R.id.story_text_view) }
}