package com.indraep.telebot.api.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("comment.bot")
public class CommentBotProperties {

  private String apiKey;

}
