package org.wikipedia.homeworks.homework23

import com.kaspersky.kaspresso.screens.KScreen
import org.wikipedia.R
import org.wikipedia.homeworks.homework11.NewExploreUiScreen
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.homeworks.homework20.name

object ExplorerScreenWithWidget: NamedKScreen<ExplorerScreenWithWidget>() {
    override val screenName: String = "Explorer screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_container)
        }.name(withParent("Виджет поиска"))
    }

    val topReadWidget by lazy {
        TopReadWidget {
            isDescendantOfA { withId(R.id.feed_view) }
            withDescendant { withText("Top read") }
        }.name(withParent("Виджет TopRead"))
    }
}

