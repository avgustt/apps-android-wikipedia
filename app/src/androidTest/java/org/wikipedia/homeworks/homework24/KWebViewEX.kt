package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView

fun KWebView.withXPath(xPath: String) = KWebViewBaseElement(this, xPath)