package org.wikipedia.homeworks.homework22

import android.content.res.Resources.NotFoundException
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.homeworks.homework20.getName
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent
import kotlin.math.min

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeByID(
    targetIndex: Int,
    targetID: Int,
    blockName: String,
    limiter: Int,
    function: T.() -> Unit
) {
    val recycler = this
    var found = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetID)) found++
            if (found == targetIndex + 1) {
                name(recycler.getName().withParent("$targetIndex блок типа $blockName"))
                function()
                return
            }
        }
    }
    throw NotFoundException("Блок типа $blockName с индексом $targetIndex не найден")
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.findByID(
    targetIndex: Int,
    targetID: Int,
    blockName: String,
    limiter: Int
): T {
    val recycler = this
    var found = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetID)) found++
            if (found == targetIndex + 1) {
                name(recycler.getName().withParent("$targetIndex блок типа $blockName"))
                return this
            }
        }
    }
    throw NotFoundException("Блок типа $blockName с индексом $targetIndex не найден")
}
