package org.wikipedia.homeworks.homework03

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.onboarding.InitialOnboardingFragment

object OnboardingScreen : KScreen<OnboardingScreen>() {
    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = InitialOnboardingFragment::class.java  // Исправлено!

    val slider = KView { withId(R.id.fragment_pager) }

    val skipButton = KButton { withId(R.id.fragment_onboarding_skip_button) }
    val forwardButton = KButton { withId(R.id.fragment_onboarding_forward_button) }
    val doneButton = KButton { withId(R.id.fragment_onboarding_done_button) }

    val pageIndicator = KView { withId(R.id.view_onboarding_page_indicator) }
}
