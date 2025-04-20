package org.wikipedia.homeworks.homework20

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.homeworks.homework03.OnboardingScreen



class Test20 : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testFor20() {
        run {
            namedSteps {
                // Пропускаем онбординг
                click(OnboardingScreen.skipButton)

                // Проверяем наличие значка поиска
                isVisible(ExploreScreenNew.searchIcon)

                // Проверяем контейнер
                isVisible(ExploreScreenNew.announcementContainer)

                // Проверяем наличие текста у блока "Top read"
                ExploreScreenNew.topReadItem(3) {
                    isVisible(viewCardHeaderTitle)
                    click(imageMenu)
                }

//                // Кликаем по иконке меню внутри Top read
//                ExploreScreenNew.topReadItem( 3) {
//                    click(imageMenu)
//                }

                // Рекламная пауза
                paused(1000)
            }
        }
    }
}


