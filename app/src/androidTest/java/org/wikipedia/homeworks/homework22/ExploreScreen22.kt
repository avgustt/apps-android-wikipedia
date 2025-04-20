package org.wikipedia.homeworks.homework22

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.*
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.homeworks.homework20.getName
import org.wikipedia.homeworks.homework20.invokeAtIndex
import org.wikipedia.homeworks.homework20.name

object ExploreScreen22 : NamedKScreen<ExploreScreenNew>() {
    override val screenName = "Explore Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbarTitle = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }.name(ExploreScreenNew.withParent("Заголовок"))

    val items = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = {
            itemType(::SearchCardViewItem)
            itemType(::AnnounceCardViewItem)
            itemType(::DayHeaderCardViewItem)
            itemType(::TopReadCardViewItem)
            itemType(::NewsCardViewItem)
        }
    ).name(ExploreScreenNew.withParent("Список блоков"))

    fun topReadCard(index: Int, block: TopReadCardViewItem.() -> Unit) {
        items.invokeAtIndex(index, block)
    }

    fun dayHeaderCard(index: Int, block: DayHeaderCardViewItem.() -> Unit) {
        items.invokeAtIndex(index, block)
    }

    fun newsCard(index: Int, block: NewsCardViewItem.() -> Unit) {
        items.invokeAtIndex(index, block)
    }
}
