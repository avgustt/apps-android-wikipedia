package org.wikipedia.homeworks.homework19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.NewsItem
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework08.screen.NewOnboardingScreen
import org.wikipedia.homeworks.homework08.screen.OnboardingViewItem
import org.wikipedia.homeworks.homework09.ArticlePageScreen
import org.wikipedia.homeworks.homework09.ArticleScreen
import org.wikipedia.main.MainActivity

class OnboardingTest19 : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOnboardingElementsDisplayed() {
        run {
            steps {
                step("Проверка отображения элементов Onboarding") {
                    NewOnboardingScreen.slider.childAt<OnboardingViewItem>(0) {
                        isDisplayed(image)
                        hasText(title, "The Free Encyclopedia\n…in over 300 languages")
                        isDisplayed(description)
                    }
                }
            }
        }
    }

    @Test
    fun checkLanguageList() {
        run {
            steps {
                step("Проверка, что список языков отображается") {
                    isDisplayed(NewOnboardingScreen.languagesList)
                }
            }
        }
    }

    @Test
    fun checkSkipAndContinueButtons() {
        run {
            steps {
                step("Проверяем, что кнопки Пропустить и Продолжить видны") {
                    isDisplayed(NewOnboardingScreen.skipButton)
                    isDisplayed(NewOnboardingScreen.continueButton)
                }
            }
        }
    }

    @Test
    fun checkLastOnboardingScreen() {
        run {
            steps {
                step("Листаем до последнего экрана Onboarding") {
                    repeat(3) { NewOnboardingScreen.slider.swipeLeft() }
                }

                step("Проверяем финальные элементы") {
                    NewOnboardingScreen.continueButton.isGone()
                    isDisplayed(NewOnboardingScreen.getStartedButton)
                }
            }
        }
    }

    @Test
    fun inTheNewsTest() {
        run {
            steps {
                step("Пропускаем онбординг") {
                    flakySafely(50000) {
                        click(OnboardingScreen.skipButton)
                        isDisplayed(ExploreScreen.toolbarTitle)
                    }
                }

                step("Кликаем на третий элемент в новостях") {
                    ExploreScreen.items
                        .childWith<NewsCardViewItem> {
                            withDescendant { withText(R.string.view_card_news_title) }
                        }.perform {
                            newsBlock.childAt<NewsItem>(2) {
                                click(image)
                            }
                        }
                }

                step("Кликаем на вторую статью") {
                    click(ArticlePageScreen.articleTitle)
                }

                step("Проверяем, что статья открылась") {
                    isVisible(ArticleScreen.pageWebView)
                }
            }
        }
    }
}
