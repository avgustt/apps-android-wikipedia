package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.ExploreScreenNew.withParent
import org.wikipedia.homeworks.homework20.name


class NamedTopRead(matcher: Matcher<View>) : KRecyclerItem<TopReadCardViewItem> (matcher) {

    val viewCardHeaderTitle  by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Текст заголовока"))
    }

    val viewListCardHeaderMenu by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Заголовок блока Top Read"))
    }

    val cardItemTitle by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.name(withParent("Элемент"))
    }

    val imageMenu = KButton {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Меню карточки Top read"))


    val cardList = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType(::TopReadCardViewItem)
        }
    ).name(withParent("Список карточек в Top read"))
}
