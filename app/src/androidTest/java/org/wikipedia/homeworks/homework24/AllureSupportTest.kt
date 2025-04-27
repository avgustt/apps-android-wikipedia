package org.wikipedia.homeworks.homework24

import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase

abstract class AllureSupportTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()
)