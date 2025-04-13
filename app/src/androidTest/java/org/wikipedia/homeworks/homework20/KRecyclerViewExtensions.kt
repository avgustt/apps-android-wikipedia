package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndex(
    index: Int,
    function: T.() -> Unit
){
    val recycler: KRecyclerView = this
    childAt<T>(index) {
        name(recycler.getName().withParent("$index"))
        function()
    }
}