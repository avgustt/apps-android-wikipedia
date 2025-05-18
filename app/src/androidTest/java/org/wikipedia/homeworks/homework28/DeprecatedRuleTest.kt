package org.wikipedia.homeworks.homework28

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.qameta.allure.kotlin.AllureId

import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.namedSteps
import org.wikipedia.homeworks.homework23.ExploreScreenWithWidget
import org.wikipedia.homeworks.homework08.screen.NewOnboardingScreen
import org.wikipedia.main.MainActivity

class DeprecatedRuleTest : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @get:Rule(order = 2)
    val happyTestRule = HappyTestRule(testLogger)

    @get:Rule
    val deprecatedTestRule = DeprecatedTestRule(testLogger)

    @get:Rule(order = 1)
    val allureTestRule = AllureHappyRule(testLogger)

    @Test
    @Deprecated("to skip")
    fun skippedFun() {
    }

    @Test
    @AllureId("222222")
    fun testWithWidget() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExploreScreenWithWidget.searchWidget {
                    isVisible(searchVoiceIcon)
                }
                ExploreScreenWithWidget.topReadWidget {
                    isVisible(topReadHeaderTitle)
                }


            }
        }
    }
}