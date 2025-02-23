package org.wikipedia.homeworks.homework08.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object NewOnboardingScreen : KScreen<NewOnboardingScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }

    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }

    val getStartedButton = KButton {
        withId(R.id.fragment_onboarding_done_button)
    }

    val slider = KViewPager2(
        builder = { withId(R.id.fragment_pager) },
        itemTypeBuilder = { itemType(::OnboardingViewItem) }
    )

    val languagesList = KRecyclerView(
        builder = { withId(R.id.languagesList) },
        itemTypeBuilder = { itemType(::LanguageItem) }
    )

}