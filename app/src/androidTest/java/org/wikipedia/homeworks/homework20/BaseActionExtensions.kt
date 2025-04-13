package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.actions.BaseActions

private val names = mutableMapOf<BaseActions, NameHierarchy>()

fun <T : BaseActions> T.name(nameHierarchy: NameHierarchy): T {
    names[this] = nameHierarchy
    return this
}

fun BaseActions.getName(): NameHierarchy {
    return names[this] ?: run {
        println("❗ Имя не указано для элемента класса: ${this::class.qualifiedName}")
        throw RuntimeException("Укажи имя для элемента ${this::class.qualifiedName}")
    }
}

fun BaseActions.withParent(elementName: String) = getName().withParent(elementName)