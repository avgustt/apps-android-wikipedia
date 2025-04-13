package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val namedStepsMap = mutableMapOf<TestContext<*>, NamedSteps>()

val TestContext<*>.namedSteps: NamedSteps
    get(){
        return namedStepsMap.getOrPut(this){NamedSteps(this)}
    }