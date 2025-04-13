package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.views.KBaseView

// Хранилище имён для KBaseView
private val viewNames = mutableMapOf<KBaseView<*>, NameHierarchy>()

fun <T : KBaseView<*>> T.name(nameHierarchy: NameHierarchy): T {
    viewNames[this] = nameHierarchy
    return this
}

fun KBaseView<*>.getName(): NameHierarchy {
    return viewNames[this] ?: run {
        println("❗ Имя не указано для элемента класса: ${this::class.qualifiedName}")
        throw RuntimeException("Укажи имя для элемента ${this::class.qualifiedName}")
    }
}

fun KBaseView<*>.withParent(elementName: String) = getName().withParent(elementName)