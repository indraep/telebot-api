package com.indraep.telebot.api;

import com.indraep.telebot.api.properties.CommentBotProperties;
import com.indraep.telebot.api.properties.TelebotProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    CommentBotProperties.class,
    TelebotProperties.class
})
public class MainApplication {

  public static void main(String[] args) {
    SpringApplication.run(MainApplication.class, args);
  }

}
