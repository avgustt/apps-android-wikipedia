package org.wikipedia.homeworks.homework23

import android.view.View
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent
import org.wikipedia.page.Namespace

class SearchWidget: KWidget<SearchWidget> {

    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)

    val searchIcon by lazy {
        KImageView(parent) {
            withDrawable(Namespace.R.drawable.ic_search_white_24dp)
        }.name(withParent("Иконка поиска"))
    }

    val voiceIcon by lazy {
        KImageView(parent) {
            withId(R.id.voice_search_button)
        }.name(withParent("иконка микрофона"))
    }

}