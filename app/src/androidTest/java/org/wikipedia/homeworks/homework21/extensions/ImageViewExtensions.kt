package org.wikipedia.homeworks.homework21.extensions

import io.github.kakaocup.kakao.image.KImageView
import org.wikipedia.homeworks.homework21.customAssertions.HasDrawableAssertion
import org.wikipedia.homeworks.homework21.customAssertions.HasNoDrawableAssertion

fun KImageView.hasAnyDrawable() {
    view.check(HasDrawableAssertion())
}

fun KImageView.noDrawable() {
    view.check(HasNoDrawableAssertion())
}
