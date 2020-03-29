package com.indraep.telebot.api.helpers;

import java.time.LocalDateTime;

public interface TimeHelpers {

  Long toEpochMillis(LocalDateTime localDateTime);

  LocalDateTime getCurrentDate();

  long getCurrentTime();

}
