package org.wikipedia.homeworks.homework026

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R


class CloseCustomizeYourToolBarSmartScenario(testContext: TestContext<*>) : BaseSmartScenario(testContext) {
    override val stepInfo: String = "Закрвывает Balloon кастомизации тулбара"
    override val action: (StepInfo) -> Unit = {
        KView {
            withId(R.id.buttonView)
        }.click()
    }

    override fun isConditionMet() = waitElementById("balloon_card")
}