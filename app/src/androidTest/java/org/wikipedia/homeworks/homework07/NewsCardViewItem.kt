package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework09.ArticleItem

class NewsCardViewItem(matcher: Matcher<View>) : KRecyclerItem<NewsCardViewItem>(matcher) {

    val title = KTextView(matcher) { withId(R.id.view_list_card_item_title) }


    val newsBlock  = KRecyclerView(
        parent = matcher,
        builder = { withId(R.id.news_cardview_recycler_view) },
        itemTypeBuilder = { itemType(::NewsItem) }
    )


//    val articles = KRecyclerView(
//        parent = matcher,
//        builder = { withId(R.id.news_story_items_recyclerview) },
//        itemTypeBuilder = { itemType(::ArticleItem) } )//

}