package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView


open class KWebViewElement<T>(KWebView: KWebView, xPath: String):
    KWebViewBaseElement<KWebViewElement<T>>(KWebView, xPath) {
    override val self: KWebViewElement<T> = this

}