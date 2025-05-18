package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.actions.BaseActions

private val names = mutableMapOf<BaseActions, NameHierarchy>()

fun <T : BaseActions> T.setName(nameHierarchy: NameHierarchy): T {
    names[this] = nameHierarchy
    return this
}

fun BaseActions.getName(): NameHierarchy {
    return names[this]?:
    NameHierarchy("No lable")


}

fun BaseActions.withParent(elementName: String) = getName().withParent(elementName)