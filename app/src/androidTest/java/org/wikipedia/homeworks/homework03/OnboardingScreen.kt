package org.wikipedia.homeworks.homework03

import android.widget.ImageView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

val wikiLogo = listOf(
    ImageView::class.java,  //Класс
    "main_toolbar_wordmark", //id
    null, //нет текста
)

val searchBottom = listOf(
    ImageView::class.java,  //Класс
    null,  //Нет ID
    null, //нет текста
)

val descriptionWikipedia = listOf(
    MaterialTextView::class.java,   //Класс
    "view_announcement_text", //id
    "wikipedia_2024_review", //ID текста
)

val moreRandomArticlesButton = listOf(
    MaterialButton::class.java, // Класс
    "view_featured_article_card_footer", // ID кнопки
    "more_random_articles", // ID текста
)



