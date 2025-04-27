package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView
import javax.xml.xpath.XPath

class ReferenceLisItem(KWebView: KWebView, xPath: String):
    KwebViewItem<ReferenceLisItem>(KWebView,xPath){
    override val self: ReferenceLisItem =this

    val index by Lazy{
        child<KWebViewElement>("/div/div[@class='pcs-ref-backlink-container']")
            .name(withParent("Индекс ссылки"))
    }

    val content by Lazy{
        child<KWebViewElement>("/div/div[@class='pcs-ref-body']")
            .name(withParent("Заголовок ссылки"))
    }
}