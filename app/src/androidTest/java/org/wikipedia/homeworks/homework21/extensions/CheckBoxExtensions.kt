package org.wikipedia.homeworks.homework21.extensions

import io.github.kakaocup.kakao.check.KCheckBox
import org.wikipedia.homeworks.homework21.customActions.ToggleCheckBoxAction

fun KCheckBox.toggle() {
    view.perform(ToggleCheckBoxAction())
}
