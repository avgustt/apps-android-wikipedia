package org.wikipedia.homeworks.homework29

import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.edit.KTextInputLayout
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.homeworks.homework20.setName

object LoginScreen : NamedKScreen<LoginScreen>() {
    override val screenName = "Log in Screen"
    override val layoutId = null
    override val viewClass = null

    val provideUsernameField by lazy {
        KEditText {
//            withId(R.id.login_username_text)
            withHint("Username")
        }.setName(withParent("Provide your username field"))
    }

    val providePasswordField by lazy {
        KEditText {
//            withId(R.id.login_password_input)
            withHint("Password")
        }.setName(withParent("Provide your password field"))
    }

    val loginButton by lazy {
        KButton {
            withId(R.id.login_button)
        }.setName(withParent("Log in button"))
    }

}