package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView


class KWebViewElement<T>(KWebView: KWebView, xPath: String):
    KWebViewBaseElement<KWebViewElement<Any?>>(KWebView,xPath){
    override val self: KWebViewElement<Any?> = this

}