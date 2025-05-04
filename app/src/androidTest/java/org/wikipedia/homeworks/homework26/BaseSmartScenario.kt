package org.wikipedia.homeworks.homework026

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo

private const val WAITING_TIME_L = 100L

abstract class BaseSmartScenario(val testContext: TestContext<*>) {
    abstract val stepInfo: String
    abstract val action: (StepInfo) -> Unit
    abstract fun isConditionMet(): Boolean
    fun init(): Boolean {
        val conditions = isConditionMet()
        if (conditions) {
            testContext.step(stepInfo, action)
        }
        return conditions
    }

    fun waitElementById(id: String) = getElementById(id).waitForExists(WAITING_TIME_L)

    fun waitElementByText(text: String) = getElementByText(text).waitForExists(WAITING_TIME_L)

    private fun getElementById(id: String): UiObject {
        return testContext
            .device
            .uiDevice
            .findObject(
                UiSelector()
                    .resourceId("${testContext.device.targetContext.packageName}:id/$id)")
            )
    }

    private fun getElementByText(text: String): UiObject {
        return testContext
            .device
            .uiDevice
            .findObject(
                UiSelector()
                    .textContains(text)
            )
    }
}