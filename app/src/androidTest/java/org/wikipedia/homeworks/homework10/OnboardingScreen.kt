package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingScreen : UiScreen<OnboardingScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val skipButton = UiButton {
        withId(this@OnboardingScreen.packageName, "fragment_onboarding_skip_button")
    }

    val continueButton = UiButton {
        withId(this@OnboardingScreen.packageName, "fragment_onboarding_forward_button")
    }

    val scrollViewContainer = UiScrollView {
        withId(this@OnboardingScreen.packageName, "scrollViewContainer")
    }

    val languageListContainer = UiView {
        withId(this@OnboardingScreen.packageName, "languageListContainer")
    }

    val addLanguageButton = UiButton {
        withId(this@OnboardingScreen.packageName, "addLanguageButton")
    }

    val languagesList = UiScrollView {
        withId(this@OnboardingScreen.packageName, "languagesList")
    }
}