package org.wikipedia.homeworks.homework28

import com.kaspersky.kaspresso.logger.UiTestLogger
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class HappyTestRule(private val testLogger: UiTestLogger) : TestRule {
    override fun apply(base: Statement?, description: Description?): Statement {
        return HappyStatement(testLogger, description, base)
    }


    private class HappyStatement(
        val testLogger: UiTestLogger,
        val description: Description?,
        val base: Statement?
    ) : Statement() {
        override fun evaluate() {
            testLogger.i("Hello test ${description?.className} ${description?.methodName}")
            try {
                base?.evaluate()
            } catch (e: Throwable) {
                throw e
            } finally {
                testLogger.i("Bye-bye test")
            }
        }
    }
}