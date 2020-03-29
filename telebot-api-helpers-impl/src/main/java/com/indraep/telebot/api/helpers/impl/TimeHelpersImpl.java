package com.indraep.telebot.api.helpers.impl;

import com.indraep.telebot.api.helpers.TimeHelpers;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TimeHelpersImpl implements TimeHelpers {
  @Override
  public Long toEpochMillis(LocalDateTime localDateTime) {
    return localDateTime
        .atZone(ZoneId.systemDefault())
        .toInstant()
        .toEpochMilli();
  }

  @Override
  public LocalDateTime getCurrentDate() {
    return LocalDateTime.now();
  }

  @Override
  public long getCurrentTime() {
    return toEpochMillis(getCurrentDate());
  }
}
