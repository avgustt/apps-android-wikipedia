package org.wikipedia.lessons.lesson13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.main.MainActivity

class VebViewTest: TestCase(){
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun vebViewTest() {
        run{
            OnboardingScreen.skipButton.click()
            ExploreScreen.items.childWith<SearchCardViewItem>{
                withDescendant { withText("Featured article") }
            }.perform {
                Thread.sleep(1000)
                click()
            }
            ArticlViewScreen{
                vebView{
                    withElement(Locator.XPATH, "//span[@class='mw-page-title-main']"){
                        hasText("Five pounds (gold coin)")
                    }
                }
            }
        }
    }
}