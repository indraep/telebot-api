package com.indraep.telebot.api.rest.controller;

import com.blibli.oss.backend.common.helper.ResponseHelper;
import com.blibli.oss.backend.common.model.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HomeController extends BaseController {

  @GetMapping("home")
  public Mono<Response<String>> home() {
    return Mono.fromCallable(() -> ResponseHelper.ok("OK"))
        .subscribeOn(getScheduler());
  }

}
