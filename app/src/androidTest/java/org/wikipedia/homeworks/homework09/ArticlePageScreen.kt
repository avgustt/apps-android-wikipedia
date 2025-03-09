package org.wikipedia.homeworks.homework09

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.page.PageActivity

object ArticlePageScreen : KScreen<ArticlePageScreen>() {
    override val layoutId: Int? = R.layout.activity_page
    override val viewClass = PageActivity::class.java

    val articleTitle = KTextView {
        withId(R.id.news_story_items_recyclerview)
    }

    val articleSubtitle = KTextView {
        withId(R.id.view_list_card_item_subtitle)
    }

    val itemInNews = KRecyclerView (
        builder = { withId(R.id.news_story_items_recyclerview) },
        itemTypeBuilder = {
            itemType(::NewsCardItem)
        }
    )
}
