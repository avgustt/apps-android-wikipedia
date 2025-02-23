package org.wikipedia.homeworks.homework08.screen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OnboardingViewItem(matcher: Matcher<View>) : KViewPagerItem<OnboardingViewItem>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }

    val title = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }

    val description = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }

}
