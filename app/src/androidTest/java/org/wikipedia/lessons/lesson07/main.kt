package org.wikipedia.lessons.lesson07

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.hamcrest.Matcher
import org. wikipedia.R

object OnboardingScreen : KScreen<OnboardingScreen>() {

    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = null

    val slider = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::OnboardingPagerFirstItem)
            itemType(::OnboardingPagerSecondItem)
        }
    )

}

class OnboardingPagerFirstItem(
    matcher: Matcher<View>
) : KViewPagerItem<OnboardingPagerFirstItem>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }

    val languages = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.languagesList)
        },
        itemTypeBuilder = {

        }
    )
}

class OnboardingPagerSecondItem(
    matcher: Matcher<View>
) : KViewPagerItem<OnboardingPagerSecondItem>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }
}

