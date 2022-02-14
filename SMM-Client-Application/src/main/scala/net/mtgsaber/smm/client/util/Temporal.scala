package net.mtgsaber.smm.client.util

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object Temporal {
  enum DateTimeFormatPatterns(val pattern: String) {

    case Default extends DateTimeFormatPatterns("yyyy.MM.dd.HH.mm")
  }

  def timestamp(dateTimePattern: String = DateTimeFormatPatterns.Default.pattern): String = {
    ZonedDateTime.now format DateTimeFormatter.ofPattern(dateTimePattern)
  }
}
