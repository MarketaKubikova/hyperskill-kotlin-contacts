package contacts.utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object Formatter {
    fun formatDate(date: ZonedDateTime): String {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm"))
    }
}
