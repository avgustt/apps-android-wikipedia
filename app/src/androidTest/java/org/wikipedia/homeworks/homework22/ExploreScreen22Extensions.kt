package org.wikipedia.homeworks.homework22

import org.wikipedia.R
import org.wikipedia.homeworks.homework07.*


fun ExploreScreen22.searchCard(block: SearchCardViewItem.() -> Unit) {
    items.invokeByID(
        targetIndex = 0,
        targetID = R.id.voice_search_button,
        blockName = "Search Card",
        limiter = 5,
        function = block
    )
}

fun ExploreScreen22.announcementCard(block: AnnounceCardViewItem.() -> Unit) {
    items.invokeByID(
        targetIndex = 0,
        targetID = R.id.view_announcement_header_image,
        blockName = "Announcement Card",
        limiter = 5,
        function = block
    )
}
