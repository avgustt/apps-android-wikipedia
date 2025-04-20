        package org.wikipedia.homeworks.homework20

        import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
        import com.kaspersky.kaspresso.testcases.models.info.StepInfo
        import io.github.kakaocup.kakao.check.CheckableActions
        import io.github.kakaocup.kakao.check.CheckableAssertions
        import io.github.kakaocup.kakao.common.actions.BaseActions
        import io.github.kakaocup.kakao.common.assertions.BaseAssertions
        import io.github.kakaocup.kakao.edit.EditableActions
        import io.github.kakaocup.kakao.text.KButton
        import io.github.kakaocup.kakao.text.TextViewAssertions
        import org.wikipedia.homeworks.homework21.customAssertions.CustomAssertion

        class NamedSteps(val testContext: TestContext<*>) {

            private fun execute(stepText: String, actions: (StepInfo) -> Unit) {
                testContext.step(stepText, actions)
            }

            operator fun invoke(function: NamedSteps.() -> Unit) {
                function()
            }

            fun click(item: BaseActions) {
                testContext.step("Нажимаем на элемент '${item.getName()}'") {
                    item.click()
                }
            }

            fun isVisible(item: BaseAssertions) {
                val name = (item as? BaseActions)?.getName() ?: "Неизвестный элемент"
                testContext.step("Проверяем видимость элемента $name") {
                    item.isVisible()
                }
            }

            fun paused(millis: Long) {
                testContext.step("Делаем паузу $millis миллисекунд") {
                    Thread.sleep(millis)
                }
            }

            fun disableNetwork() {
                testContext.step("Отключаем сеть") {
                    testContext.device.network.toggleWiFi(false)
                }
            }

            fun enableNetwork() {
                testContext.step("Включаем сеть") {
                    testContext.device.network.toggleWiFi(true)
                }
            }

            fun typeText(item: EditableActions, text: String) {
                val name = (item as? BaseActions)?.getName() ?: "Неизвестный элемент"
                testContext.step("Вводим текст: '$text' в элемент $name") {
                    item.replaceText(text)
                }
            }

            fun setChecked(item: CheckableActions, state: Boolean) {
                val name = (item as? BaseActions)?.getName() ?: "Неизвестный элемент"
                testContext.step("Устанавливаем состояние элемента $name в $state") {
                    item.setChecked(state)
                }
            }

            fun setOrientationLeft() {
                testContext.step("Устанавливаем ориентацию влево") {
                    testContext.device.uiDevice.setOrientationLeft()
                }
            }

            fun setOrientationRight() {
                testContext.step("Устанавливаем ориентацию вправо") {
                    testContext.device.uiDevice.setOrientationRight()
                }
            }

            fun setOrientationNatural() {
                testContext.step("Устанавливаем ориентацию по умолчанию") {
                    testContext.device.uiDevice.setOrientationNatural()
                }
            }

            fun hasText(item: TextViewAssertions, text: String) {
                val name = (item as? BaseActions)?.getName() ?: "Неизвестный элемент"
                testContext.step("Проверяем, что элемент $name содержит текст: '$text'") {
                    item.hasText(text)
                }
            }

            fun hasAnyText(item: TextViewAssertions) {
                val name = (item as? BaseActions)?.getName() ?: "Неизвестный элемент"
                testContext.step("Проверяем, что элемент $name содержит любой текст") {
                    item.hasAnyText()
                }
            }

            fun containsText(item: TextViewAssertions, text: String) {
                val name = (item as? BaseActions)?.getName() ?: "Неизвестный элемент"
                testContext.step("Проверяем, что элемент $name содержит текст: '$text'") {
                    item.containsText(text)
                }
            }

            fun isChecked(item: CheckableAssertions) {
                val name = (item as? BaseActions)?.getName() ?: "Неизвестный элемент"
                testContext.step("Проверяем, что элемент $name отмечен (checked)") {
                    item.isChecked()
                }
            }

            fun isNotChecked(item: CheckableAssertions) {
                val name = (item as? BaseActions)?.getName() ?: "Неизвестный элемент"
                testContext.step("Проверяем, что элемент $name не отмечен (not checked)") {
                    item.isNotChecked()
                }
            }

            fun isDisplayed(item: BaseAssertions) {
                val name = (item as? BaseActions)?.getName() ?: "Неизвестный элемент"
                testContext.step("Проверяем, что элемент $name отображается") {
                    item.isDisplayed()
                }
            }

            fun hasTextKButton(item: KButton, text: String) {
                val name = (item as? BaseActions)?.getName() ?: "Неизвестная кнопка"
                testContext.step("Проверяем, что кнопка $name содержит текст: '$text'") {
                    item.checkText(text)
                }
            }
            fun KButton.checkText(expected: String) {
                view.check(CustomAssertion(expected))
            }
        }