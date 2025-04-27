package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView

class KWebViewList(
    KWebView: KWebView,
    listContainerXPath: String
) : KWebViewBaseElement<KWebViewList>(kWebView,listContainerXPath){
    override val self: KWebViewList = this

    inline fun <reified T : KwebViewItem<T>> childAt(index: Int, function: T.() -> Unit) {
        val item = T::class.java
            .getConstructor(KWebView::class.java,String::class.java)
            .newInstance(KWebView, "$xPath/*[$index]")
            .name(withParent("$index"))
        item.executeAction { scroll() }
        item.function()
    }
}