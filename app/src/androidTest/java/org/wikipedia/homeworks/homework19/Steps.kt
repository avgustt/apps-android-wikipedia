package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions

class Steps(private val testContext: TestContext<*>) {

    private fun execute(textOfStep: String, actions: StepInfo.() -> Unit) {
        testContext.step(textOfStep, actions)
    }

    operator fun invoke(function: Steps.() -> Unit) {
        function()
    }

    private fun defaultName(item: Any): String {
        val str = item.toString()
        return if (str.contains('@')) "элемент" else str
    }

    fun click(item: BaseActions) {
        execute("Нажимает на элемент '${item}'") {
            item.click()
        }
    }

    fun isVisible(item: BaseAssertions, name: String = defaultName(item)) {
        execute("Проверяем видимость элемента '$name'") {
            item.isVisible()
        }
    }

    fun sleep(time: Long) {
        execute("Сделать паузу в $time миллисекунд") {
            Thread.sleep(time)
        }
    }

    fun disableNetwork() {
        execute("Отключаем сеть"){
            testContext.device.network.toggleWiFi(false)
        }
    }

    fun enableNetwork() {
        execute("Включаем сеть") {
            testContext.device.network.toggleWiFi(true)
        }
    }

    fun typeText(item: EditableActions, text: String) {
        execute("Печатаем текст '$text'") {
            item.replaceText(text)
        }
    }

    fun setChecked(item: CheckableActions, state: Boolean, name: String = defaultName(item)) {
        execute("Устанавливаем состояние '$name' в '$state'") {
            item.setChecked(state)
        }
    }

    fun setOrientationLeft() {
        execute("Поворачиваем устройство влево") {
            testContext.device.uiDevice.setOrientationLeft()
        }
    }

    fun setOrientationRight() {
        execute("Поворачиваем устройство вправо") {
            testContext.device.uiDevice.setOrientationRight()
        }
    }

    fun setOrientationNatural() {
        execute("Устанавливаем ориентацию по умолчанию") {
            testContext.device.uiDevice.setOrientationNatural()
        }
    }

    fun hasText(item: TextViewAssertions, text: String, name: String = defaultName(item)) {
        execute("Проверяем у элемента '$name' наличие текста '$text'") {
            item.hasText(text)
        }
    }

    fun hasAnyText(item: TextViewAssertions, name: String = defaultName(item)) {
        execute("Проверяем у элемента '$name' наличие любого текста") {
            item.hasAnyText()
        }
    }

    fun containsText(item: TextViewAssertions, text: String, name: String = defaultName(item)) {
        execute("Проверяем что элемент '$name' содержит текст '$text'") {
            item.containsText(text)
        }
    }

    fun isChecked(item: CheckableAssertions, name: String = defaultName(item)) {
        execute("Проверяем, что элемент '$name' отмечен") {
            item.isChecked()
        }
    }

    fun isNotChecked(item: CheckableAssertions, name: String = defaultName(item)) {
        execute("Проверяем, что элемент '$name' не отмечен") {
            item.isNotChecked()
        }
    }

    fun isDisplayed(item: BaseAssertions, name: String = item.toString()) {
        execute("Проверяем, что ${(item as BaseActions)} отображается") {
            item.isDisplayed()
        }
    }

    fun pressBack(){
        execute("Нажимаем 'назад'"){
            testContext.device.uiDevice.pressBack()
        }
    }

    fun waitForIdle(time: Long){
        execute("Ждём пока устаканится в теченинии $time миллисекунд"){
            testContext.device.uiDevice.waitForIdle(time)
        }
    }
}
