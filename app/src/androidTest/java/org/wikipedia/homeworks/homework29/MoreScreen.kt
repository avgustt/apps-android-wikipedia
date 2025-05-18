package org.wikipedia.homeworks.homework29

import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.homeworks.homework20.setName

object MoreScreen : NamedKScreen<MoreScreen>() {
    override val screenName = "More Options Screen"
    override val layoutId = null
    override val viewClass = null

    val loginButton by lazy {
        KTextView {
            withId(R.id.main_drawer_login_button)
        }.setName(withParent("Log in / join Wikipedia"))
    }

    val placesButton by lazy {
        KTextView {
            withId(R.id.main_drawer_places_container)
        }.setName(withParent("Places option"))
    }
}