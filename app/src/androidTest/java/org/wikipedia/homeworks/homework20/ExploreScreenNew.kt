package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.homeworks.homework07.AnnounceCardViewItem
import org.wikipedia.homeworks.homework07.DayHeaderCardViewItem
import org.wikipedia.homeworks.homework07.NamedTopRead
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReadCardViewItem

object ExploreScreenNew : NamedKScreen<ExploreScreenNew>() {
    override val screenName = "Главный экран"
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val toolbarTitle: KImageView by lazy {
        KImageView { withId(R.id.main_toolbar_wordmark) }
            .name(withParent("Заголовок"))
    }

    val feed = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = {
            itemType(::SearchCardViewItem)
            itemType(::AnnounceCardViewItem)
            itemType(::DayHeaderCardViewItem)
            itemType(::TopReadCardViewItem)
            itemType(::NewsCardViewItem)
            itemType(::NamedTopRead)
        }
    ).name(withParent("Список блоков"))



    fun topReadItem(index: Int, function: NamedTopRead.() -> Unit) {
        feed.invokeAtIndex(index, function)
    }

    fun topReadItem(): NamedTopRead{
        return feed.childWith<NamedTopRead> {
            withDescendant {
                withText("Top read")
            }
        }.name(feed.getName().withParent("Top read"))
    }

    val searchIcon: KImageView by lazy {
        KImageView {
            withContentDescription("Search Wikipedia")
        }.name(withParent("Иконка поиска"))
    }

    val announcementContainer: KView by lazy {
        KView {
            withId(R.id.view_announcement_container)
        }.name(withParent("Блок объявления"))
    }

    val viewCardHeaderTitle by lazy {
        KTextView {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок блока Top read"))
    }


}