package com.indraep.telebot.api.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("telebot")
public class TelebotProperties {

  private String name;

  private String serviceUrl;

  private String token;

  private long adminUserId;

  private long walletBroadcastChannelId;

}
