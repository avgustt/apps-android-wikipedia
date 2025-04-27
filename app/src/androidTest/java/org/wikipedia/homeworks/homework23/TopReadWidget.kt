package org.wikipedia.homeworks.homework23

import android.view.View
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.TopReadCardViewItem
import org.wikipedia.homeworks.homework20.invokeAtIndex
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class TopReadWidget: KWidget<TopReadWidget> {
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)

    val headerTitle by lazy {
        KTextView(parent) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок"))
    }

    val headerMenu by lazy {
        KImageView(parent) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Меню"))
    }

    val topReadCardViewList by lazy {
        KRecyclerView(
            parent = parent,
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType(::TopReadCardViewItem)
            }
        ).name(withParent("Список top read статей"))
    }

    fun topReadListItem(index: Int, function: TopReadCardViewItem.() -> Unit) {
        topReadCardViewList.invokeAtIndex(index, function)
    }

    val footerMoreTopRead by lazy {
        KTextView(parent) {
            withId(R.id.footerActionButton)
        }.name(withParent("More"))
    }
}