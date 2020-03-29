package com.indraep.telebot.api.rest.controller;

import com.blibli.oss.backend.reactor.scheduler.SchedulerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.scheduler.Scheduler;

public class BaseController {

  @Autowired
  private SchedulerHelper schedulerHelper;

  protected Scheduler getScheduler() {
    return schedulerHelper.of("default");
  }

  protected Scheduler getScheduler(String name) {
    return schedulerHelper.of(name);
  }

}
