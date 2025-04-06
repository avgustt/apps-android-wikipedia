package org.wikipedia.homeworks.homework18

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.wikipedia.homeworks.homework08.OnboardingTest08
import org.wikipedia.homeworks.homework09.ExploreScreenTests
import org.wikipedia.homeworks.homework10.OnboardingTest

@RunWith(Suite::class)
@Suite.SuiteClasses(
    ExploreScreenTests::class,
    OnboardingTest::class,
    OnboardingTest08::class,
)
class TestSuite