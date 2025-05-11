package org.wikipedia.homeworks.homework027

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.namedSteps
import org.wikipedia.homeworks.homework22.ExploreScreen22
import org.wikipedia.homeworks.homework22.searchCardViewItem
import org.wikipedia.homeworks.homework08.screen.NewOnboardingScreen
import org.wikipedia.main.MainActivity


class SuccessfulTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        stepWatcherInterceptors.removeIf {
            it is ScreenshotStepInterceptor
        }
//        stepWatcherInterceptors.add(FailOnlyScreenshotStepInterceptor(screenshots))
        testRunWatcherInterceptors.add(SuccessFinalScreenshotTestInterceptor(screenshots))
    }
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun successfulTest() {
        run {
            namedSteps {
                click(NewOnboardingScreen.skipButton)
                ExploreScreen22.searchCardViewItem {
                    searchText.hasText("Search Wikipedia")
                }
            }
        }
    }
}