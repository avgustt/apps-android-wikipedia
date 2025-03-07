package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsCardViewItem(matcher: Matcher<View>) : KRecyclerItem<NewsCardViewItem>(matcher) {
    val title = KTextView(matcher) { withId(R.id.view_list_card_item_title) }
    val newsList = KRecyclerView(
        matcher,
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = { itemType(::NewsItem) }
    )

    val images = KRecyclerView(
        matcher,
        builder = { withId(R.id.news_cardview_recycler_view) },
        itemTypeBuilder = { itemType(::NewsItem) }
    )

    val articleList = KRecyclerView(
        matcher,
        builder = { withId(R.id.news_cardview_recycler_view) },
        itemTypeBuilder = { itemType(::NewsItem) }
    )
}