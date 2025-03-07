package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import okhttp3.internal.wait
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.NewsItem
import org.wikipedia.main.MainActivity

class ExploreScreenTests : TestCase() {

    @get:Rule
    val activityScenarioRule : ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun scrollToThirdImageAndClick() {
        run {
            step("Пропуск онбординга") {
                OnboardingScreen.skipButton.click()
            }

            step("Проверяем, что виден блок 'In the news'") {
                ExploreScreen.newsBlock.isDisplayed()
            }

            step("Скроллим до третьего элемента в 'In the news'") {
                ExploreScreen.newsBlock.images.scrollTo(2)
            }

            step("Кликаем по третьему изображению") {
                ExploreScreen.newsBlock.images.childAt<NewsItem>(2) {
                    image.click()
                }
            }
        }
    }

}
