package com.indraep.telebot.api.rest.controller.configuration;

import com.indraep.telebot.api.properties.TelebotProperties;
import com.indraep.telebot.client.TelebotClient;
import com.indraep.telebot.client.config.TelebotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelebotClientConfiguration {

  @Autowired
  private TelebotProperties telebotProperties;

  @Bean
  public TelebotClient telebotClient() {
    TelebotConfiguration configuration = new TelebotConfiguration();
    configuration.setHost(telebotProperties.getServiceUrl());
    configuration.setToken(telebotProperties.getToken());

    return new TelebotClient(configuration);
  }

}
