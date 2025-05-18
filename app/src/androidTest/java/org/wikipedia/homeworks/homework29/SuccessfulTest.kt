package org.wikipedia.homeworks.homework29

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.BuildConfig
import org.wikipedia.homeworks.homework20.namedSteps
import org.wikipedia.homeworks.homework22.ExploreScreen22
import org.wikipedia.homeworks.homework22.searchCard
import org.wikipedia.homeworks.homework08.screen.NewOnboardingScreen
import org.wikipedia.main.MainActivity


class SuccessfulTest : TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun successfulTest() {
        run {
            BuildConfig.HOME_WORK
            val login = Users.alphaLogin
            val password = Credentials.getPassword(login)
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExploreScreenNew.searchCardViewItem {
                    searchText.hasText("Search Wikipedia")
                }
            }
        }
    }
}