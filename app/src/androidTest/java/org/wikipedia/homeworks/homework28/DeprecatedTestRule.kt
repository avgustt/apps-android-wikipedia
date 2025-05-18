package org.wikipedia.homeworks.homework28

import com.kaspersky.kaspresso.logger.UiTestLogger
import org.junit.AssumptionViolatedException
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class DeprecatedTestRule(private val testLogger: UiTestLogger) : TestRule {
    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                val deprecatedAnnot = description?.getAnnotation(Deprecated::class.java)
                if (deprecatedAnnot != null) {
                    throw AssumptionViolatedException("Test is deprecated")
                }
                testLogger.i("Hello deprecated test =) ")
                try {
                    base?.evaluate()
                } catch (e: Throwable) {
                    throw e
                }
            }
        }
    }
}