package org.wikipedia.homeworks.homework24

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.kautomator.system.UiSystem.click
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.screen.NewOnboardingScreen
import org.wikipedia.homeworks.homework20.ExploreScreenNew

import org.wikipedia.main.MainActivity

const val REFERENCE_INDEX = 2
const val REFERENCE_TITLE = "References"
const val REFERENCE_INDEX_TEXT = "[${REFERENCE_INDEX}]"

class WebViewTest() {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    class WebViewTest : AllureSupportTest() {
        @get:Rule
        val activityRule = ActivityScenarioRule(MainActivity::class.java)

        @Test
        fun testWebView() = run {
            actions {
                click(NewOnboardingScreen.skipButton)
                ExploreScreenNew.inTheNewsItem {
                    tabNewsItem(EXPLORE_SCREEN_ITEM) {
                        click(this)
                    }
                }
                ArticlesScreen {
                    cardItemView(ARTICLES_SCREEN_ITEM) {
                        click(this)
                    }
                }
            }
            WebViewDSLScreen {
                actions {
                    referenceTitle {
                        click(this)
                    }
                }
                checks {
                    hasText(referenceTitle, REFERENCE_TITLE)
                    referenceItem(REFERENCE_INDEX) {
                        containsText(this, REFERENCE_INDEX_TEXT)
                    }
                }

            }
        }
    }