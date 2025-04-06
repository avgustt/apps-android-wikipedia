package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework07.NewsItem
import org.wikipedia.main.MainActivity

class ExploreScreenTests : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun inTheNewsTest() {
        run {

            step("Пропускаем онбординг") {
                flakySafely(50000) {
                    OnboardingScreen.skipButton.click()
                    ExploreScreen.toolbarTitle.isDisplayed()
                }
            }
            ExploreScreen.items
                .childWith<NewsCardViewItem> {
                    withDescendant {
                        withText(R.string.view_card_news_title)
                    }

                }.perform {
                    step("кликаем на третий элемент") {
                        newsBlock.childAt<NewsItem>(2) {
                            image.click()
                        }
                    }
                }

            step("кликаем на вторую статью") {
                ArticlePageScreen.articleTitle.click()
            }

            step("проверка статьи") {
                ArticleScreen.pageWebView.isVisible()
            }
        }


    }

}









