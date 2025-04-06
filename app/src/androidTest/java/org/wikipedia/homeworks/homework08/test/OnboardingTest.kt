package org.wikipedia.homeworks.homework08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.screen.NewOnboardingScreen
import org.wikipedia.homeworks.homework08.screen.OnboardingViewItem
import org.wikipedia.main.MainActivity

class OnboardingTest08 : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOnboardingElementsDisplayed() {
        run {
            step("Проверка отображения элементов Onboarding") {
                NewOnboardingScreen.slider.childAt<OnboardingViewItem>(0) {
                    image.isDisplayed()
                    title.hasText("The Free Encyclopedia\n…in over 300 languages")
                    description.isDisplayed()
                }
            }
        }
    }

    @Test
    fun checkLanguageList() {
        run {
            step("Проверка, что список языков отображается")
            {
                NewOnboardingScreen.languagesList.isDisplayed()
           }
        }
    }

    @Test
    fun checkSkipAndContinueButtons() {
        run {
            step("Проверяем, что кнопки Пропустить и Продолжить видны") {
                NewOnboardingScreen.skipButton.isDisplayed()
                NewOnboardingScreen.continueButton.isDisplayed()
            }
        }
    }

    @Test
    fun checkLastOnboardingScreen() {
        run {
            step("Листаем до последнего экрана Onboarding") {
                repeat(3) {
                    NewOnboardingScreen.slider.swipeLeft()
                }
            }

            step("Проверяем, что кнопка Продолжить стала невидимой, а кнопка Начать появилась") {
                NewOnboardingScreen.continueButton.isGone()
                NewOnboardingScreen.getStartedButton.isDisplayed()
            }
        }
    }
}
