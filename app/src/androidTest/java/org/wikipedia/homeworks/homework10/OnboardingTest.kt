package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingTest : TestCase() {
    @get:Rule

    val activityScenarioRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkButtons() {
        run {
            step("Check skip button") {
                OnboardingScreen.skipButton.isClickable()
                OnboardingScreen.skipButton.isDisplayed()
                OnboardingScreen.skipButton.isEnabled()
                OnboardingScreen.skipButton.containsText("Skip")
            }
            step("Check continue button") {
                OnboardingScreen.continueButton.isClickable()
                OnboardingScreen.continueButton.isDisplayed()
                OnboardingScreen.continueButton.isEnabled()
                OnboardingScreen.continueButton.containsText("Continue")
            }
            step("Swipe") {
                OnboardingScreen.scrollViewContainer.swipeLeft()
            }
        }
    }

    @Test
    fun addLanguage() {
        run {
            step("Check language list container") {
                OnboardingScreen.languageListContainer.isDisplayed()
            }
            step("Click on 'add or edit language' button") {
                OnboardingScreen.addLanguageButton.click()
            }
        }
    }
}