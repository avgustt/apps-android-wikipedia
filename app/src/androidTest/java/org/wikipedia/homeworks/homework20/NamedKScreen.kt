package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.screens.KScreen

abstract class NamedKScreen<out T : KScreen<T>>: KScreen<T>() {
    abstract val screenName: String
    val nameHierarchy by lazy { NameHierarchy(screenName) }

    fun withParent(elementName: String) = nameHierarchy.withParent(elementName)

}