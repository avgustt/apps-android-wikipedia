package org.wikipedia.homeworks.homework03

import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout

val fragmentContainer = listOf(
    FrameLayout::class.java,
    "fragment_container"
)

val scrollViewContainer = listOf(
    LinearLayout::class.java,
    "scrollViewContainer"
)

val imageViewCentered = listOf(
    ImageView::class.java,
    "imageViewCentered"
)

val primaryTextView = listOf(
    org.wikipedia.views.AppTextView::class.java,
    "primaryTextView",
    "onboarding_welcome_title_v2"
)

val secondaryTextView = listOf(
    org.wikipedia.views.AppTextView::class.java,
    "secondaryTextView",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
)

val languagesList = listOf(
    androidx.recyclerview.widget.RecyclerView::class.java,
    "languagesList"
)

val optionLabel = listOf(
    org.wikipedia.views.AppTextView::class.java,
    "option_label",
    "English"
)

val addLanguageButton = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)

val scrollView = listOf(
    androidx.core.widget.NestedScrollView::class.java,
    "scrollView",
)

val skipButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)

val pageIndicator = listOf(
    TabLayout::class.java,
    "view_onboarding_page_indicator",
    "onboarding_page"
)

val forwardButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_continue"
)