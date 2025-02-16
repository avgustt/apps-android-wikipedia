package org.wikipedia.lessons.lesson06

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.greaterThanOrEqualTo
import org.hamcrest.Matchers.`in`
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.lessThanOrEqualTo
import org.junit.Assert.assertTrue


data class SuspiciousActivity(val isDetected: Boolean, val suspicionLevel: Int, val notes: String)

fun ifStyle(activity: SuspiciousActivity) {
    if (!activity.isDetected ||
        activity.suspicionLevel !in 5..10 ||
        !(activity.notes == "unusual behavior" || activity.notes == "unauthorized access")
    ) {

        throw AssertionError("Verification failed for: $activity")
    }
}

//fun assertStyle(activity: SuspiciousActivity) {
//    assertTrue(activity.isDetected, "Activity should be detected")
//    assertTrue(
//        activity.suspicionLevel in 5..10,
//        "Suspicion level should be within the range 5 to 10"
//    )
//    assertTrue(
//        activity.notes == "unusual behavior" || activity.notes == "unauthorized access",
//        "Notes should be valid"
//    )
//}

fun matcherStyle(activity: SuspiciousActivity) {
    assertThat("isDetected field", activity.isDetected, `is`(true))

    assertThat(
        "suspicionLevel field",
        activity.suspicionLevel,
        allOf(greaterThanOrEqualTo(5), lessThanOrEqualTo(10))
    )

    assertThat(
        "notes field",
        activity.notes,
        anyOf(equalTo("unusual behavior"), `in`(listOf("unauthorized access")))
    )
}