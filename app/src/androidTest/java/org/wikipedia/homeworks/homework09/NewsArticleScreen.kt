package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R

object NewsArticleScreen : KScreen<NewsArticleScreen>() {
    override val layoutId: Int?
        get() = null
    override val viewClass: Class<*>?
        get() = null

    val articles = KRecyclerView(
        builder = { withId(R.id.news_story_items_recyclerview) },
        itemTypeBuilder = { itemType(::ArticleItem) }
    )

}

