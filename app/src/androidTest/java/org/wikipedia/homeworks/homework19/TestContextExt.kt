package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext


private val stepMap = mutableMapOf<TestContext<*>, Steps>()

val TestContext<*>.steps: Steps
    get() {
        if (stepMap.containsKey(this)) {
            return stepMap.getValue(this)
        } else {
            val steps = Steps(this)
            stepMap[this] = steps
            return steps
        }
    }
