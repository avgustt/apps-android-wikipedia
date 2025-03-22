package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.main.MainActivity


class WebViewTest : TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun vebViewTestForHomework13() {
        run{
            OnboardingScreen.skipButton.click()
            ExploreScreen.items.childWith<NewsCardViewItem> {
                withDescendant { withText("Featured article") }
            }.perform {
                click()
            }
            ArticleForHomework13{
                webView{
                    withElement(Locator.ID,"References") {
                        scroll()
                    }
                }
                webView{
                    withElement(Locator.ID,"References") {
                        hasText("References")
                    }
                }
                webView{
                    withElement(Locator.XPATH,"//*[@id='cite_ref-OBrien_5-0']") {
                        scroll()
                        click()
                    }
                }
            }
            ScreenForHomework13.number.hasText("5")
            device.uiDevice.pressBack()
            ArticleForHomework13{
                webView{
                    withElement(Locator.CSS_SELECTOR, ".mw-redirect[2]") {
                        click()
                    }
                }
            }
            ScrollForHomework13.readArticleButton.click()
            NewViewScreenForHomework13{
                newWebView{
                    withElement(Locator.ID, "References"){
                        scroll()
                    }
                }
            }
        }
    }



}



