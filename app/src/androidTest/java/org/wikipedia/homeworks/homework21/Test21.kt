package org.wikipedia.homeworks.homework21

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.screen.NewOnboardingScreen
import org.wikipedia.homeworks.homework20.namedSteps
import org.wikipedia.main.MainActivity

class Test21 : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWithNewOnboardingScreen() {
        run {
            namedSteps {
                // Проверка текста на "Skip"
                hasTextKButton(NewOnboardingScreen.skipButton, "Skip")

                // Проверка текста на "Continue"
                hasTextKButton(NewOnboardingScreen.continueButton, "Continue")

                // Клик по "Skip"
                click(NewOnboardingScreen.skipButton)

                // Пауза
                paused(1000)
            }
        }
    }
}