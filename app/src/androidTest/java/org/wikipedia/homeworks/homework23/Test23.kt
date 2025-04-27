package org.wikipedia.homeworks.homework23

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.namedSteps
import org.wikipedia.main.MainActivity

class WidgetTest: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWithWidget() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExplorerScreenWithWidget.searchWidget {
                    isVisible(searchText)
                    isVisible(voiceIcon)
                }
                ExploreScreenNew.TopReadCardViewItem {
                    ExplorerScreenWithWidget.topReadWidget {
                        isVisible(headerTitle)
                        isVisible(headerMenu)
                    }
                }
            }
        }
    }
}