package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.page.PageActivity

object ArticleScreen : KScreen<ArticleScreen>() {

    override val layoutId: Int? = R.layout.activity_page
    override val viewClass = PageActivity::class.java


    val pageWebView = KView {
        withId(R.id.page_web_view)
    }

    val articleTitle = KTextView {
        withId(R.id.story_text_view)
    }

}