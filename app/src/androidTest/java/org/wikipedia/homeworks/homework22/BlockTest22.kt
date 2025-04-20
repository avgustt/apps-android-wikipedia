package org.wikipedia.homeworks.homework22


import io.github.kakaocup.kakao.common.actions.BaseActions

fun BaseActions.hasIdAction(id: Int): Boolean {
    return HasIdAction(id).also {
        view.perform(it)
    }.getResult()
}
