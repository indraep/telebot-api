package com.indraep.telebot.api.client.error_resolver;

import com.blibli.oss.backend.apiclient.error.ApiErrorResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.lang.reflect.Method;

@Slf4j
@Component
public class CommentClientErrorResolver implements ApiErrorResolver {

  @Override
  public Mono<Object> resolve(Throwable throwable, Class<?> type, Method method, Object[] arguments) {
    log.error("failed to send request to comment api", throwable);
    return Mono.empty();
  }

}
