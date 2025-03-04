package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
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
    fun checkNewsNavigation() {
        run {
            step("Пропуск онбординга") {
                OnboardingScreen.skipButton.click()
            }

            step("Проверяем, что виден блок 'In the news'") {
                ExploreScreen.newsBlock.isDisplayed()
            }

            ExploreScreen.newsBlock.images.childAt<NewsItem>(2) {
                isDisplayed()
                click()
            }

            ExploreScreen.newsBlock.articleList.childAt<NewsItem>(1) {
                isDisplayed()
                click()
            }

            step("Проверяем, что открылся экран статьи") {
                ArticleScreen.pageWebView.isDisplayed()
            }
        }
    }

}
