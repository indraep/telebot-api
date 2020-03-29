package com.indraep.telebot.api.rest.controller;

import com.blibli.oss.backend.common.helper.ResponseHelper;
import com.blibli.oss.backend.common.model.response.Response;
import com.indraep.telebot.client.TelebotClient;
import com.indraep.telebot.client.model.InlineKeyboardButton;
import com.indraep.telebot.api.client.CommentClient;
import com.indraep.telebot.api.helpers.TimeHelpers;
import com.indraep.telebot.api.properties.TelebotProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@RestController
@RequestMapping("/wallet")
@Slf4j
public class WalletController extends BaseController {

  @Autowired
  private TimeHelpers timeHelpers;

  @Autowired
  private CommentClient commentClient;

  @Autowired
  private TelebotClient telebotClient;

  @Autowired
  private TelebotProperties telebotProperties;

  @GetMapping(value = "/notif-standup")
  public Mono<Response<Boolean>> standup() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
    String dateTime = formatter.format(timeHelpers.getCurrentDate());

    return commentClient.createPost("text", telebotProperties.getAdminUserId(), String.format("Standup %s", dateTime))
        .flatMap(response -> {
          log.info("comments bot response: {}", response);

          try {
            telebotClient.sendMessageWithInlineBtn(telebotProperties.getWalletBroadcastChannelId(),
                String.format("Put today standup here (%s)", dateTime),
                Arrays.asList(
                    Arrays.asList(
                        InlineKeyboardButton.builder()
                            .text("Open Comments")
                            .url(response.getResult().getLink())
                            .build()
                    )
                )
            );
          } catch (Exception e) {
            log.error("error when sending chat", e);

            return Mono.fromCallable(() -> ResponseHelper.ok(false));
          }

          return Mono.fromCallable(() -> ResponseHelper.ok(true));
        });
  }

  @GetMapping(value = "/notif-code-review")
  public Mono<Response<Boolean>> codeReview() {
    final String[] templates = new String[]{
        "Code review time!",
        "Don't forget to review the Pull Requests!",
        "Have you reviewed the Pull Requests today?",
    };

    String template = templates[(int)Math.floor(Math.random() * templates.length)];

    return Mono.fromCallable(() -> {
      telebotClient.sendMessageWithInlineBtn(telebotProperties.getWalletBroadcastChannelId(),
          template,
          Arrays.asList(
              Arrays.asList(
                  InlineKeyboardButton.builder()
                      .text("GKS Repository")
                      .url("https://wallet-repository.gdn-app.com/")
                      .build()
              ),
              Arrays.asList(
                  InlineKeyboardButton.builder()
                      .text("GDN Repository")
                      .url("https://stash.gdn-app.com")
                      .build()
              )
          ));

      return ResponseHelper.ok(true);
    });
  }

}
