package org.wikipedia.homeworks.homework29

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.namedSteps
import org.wikipedia.homeworks.homework22.ExploreScreen22
import org.wikipedia.homeworks.homework08.screen.NewOnboardingScreen
import org.wikipedia.main.MainActivity

class LoginTests : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun login() {
        run {
            namedSteps {
                OnboardingScreen {
                    click(skipButton)
                }
                ExploreScreenNew {
                    click(moreButton)
                }
                MoreScreen {
                    click(loginButton)
                }
                CreateAccountScreen {
                    click(loginButton)
                }
                LoginScreen {
                    val login = Users.blaLogin
                    authorize(login)
                    paused(5000)
                }

            }
        }
    }


}