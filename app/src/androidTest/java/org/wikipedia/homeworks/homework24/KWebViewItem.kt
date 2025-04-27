package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView

abstract class KwebViewItem<T : KwebViewItem<T>> (
    KWebView :KWebView,
    xPath: String
) : KWebViewElement<T>(kWebView, xPath)