package org.wikipedia.homeworks.homework20

class NameHierarchy(val name: String, val parent: NameHierarchy? = null) {
    fun withParent(currentElementName: String) = NameHierarchy(currentElementName, this)
    override fun toString(): String {
        return if (parent == null) name
        else "$parent : $name"
    }

}
