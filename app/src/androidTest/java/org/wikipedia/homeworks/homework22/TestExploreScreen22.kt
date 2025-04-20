package org.wikipedia.homeworks.homework22

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.namedSteps
import org.wikipedia.homeworks.homework08.screen.NewOnboardingScreen
import org.wikipedia.main.MainActivity


class TestExploreScreen22 : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testExploreBlocks() {
        run {
            namedSteps {
                click(NewOnboardingScreen.skipButton)

                ExploreScreen22.searchCard {
                    isVisible()
                    voiceIcon.click()
                }

                ExploreScreen22.announcementCard {
                    isVisible()
                    textForAnnounceCardViewItem.hasAnyText()
                }

                ExploreScreen22.topReadCard(0) {
                    cardTopReadTitleTextView.isVisible()
                    cardTopReadTitleTextView.hasText("Top read")
                    viewListCardHeaderMenu.click()
                }

                ExploreScreen22.newsCard(0) {
                    title.isVisible()
                    title.hasAnyText()
                }

                paused(2000)
            }
        }
    }
}