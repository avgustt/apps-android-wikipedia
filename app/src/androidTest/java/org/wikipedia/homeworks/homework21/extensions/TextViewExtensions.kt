package org.wikipedia.homeworks.homework21.extensions

import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.homeworks.homework21.customAssertions.CustomAssertion


fun KTextView.checkText(expected: String) {
    view.check(CustomAssertion(expected))
}
