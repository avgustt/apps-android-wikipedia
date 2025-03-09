package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework07.NewsItem
import org.wikipedia.main.MainActivity

class ExploreScreenTests : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun inTheNewsTest() {
        run {
            step("Пропускаем онбординг") {
                OnboardingScreen.skipButton.click()
            }

            step("Скроллим к блоку 'In the news'") {
                flakySafely {
                    ExploreScreen.items.childWith<NewsItem> {
                        withText("In the news")
                    }
                }.perform { inTheNewsHeaderTitle.hasAnyText() }
            }
        }
    }
}





