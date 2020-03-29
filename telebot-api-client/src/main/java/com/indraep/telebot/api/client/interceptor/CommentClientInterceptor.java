package com.indraep.telebot.api.client.interceptor;

import com.blibli.oss.backend.apiclient.interceptor.ApiClientInterceptor;
import com.indraep.telebot.api.properties.CommentBotProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;

@Component
public class CommentClientInterceptor implements ApiClientInterceptor {

  @Autowired
  private CommentBotProperties commentBotProperties;

  @Override
  public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
    return Mono.just(request)
        .map(clientRequest -> {
              URI uri = UriComponentsBuilder.fromUri(clientRequest.url())
                  .queryParam("api_key", commentBotProperties.getApiKey())
                  .build()
                  .toUri();

              return ClientRequest.from(clientRequest)
                  .url(uri)
                  .build();
            }
        ).flatMap(next::exchange);
  }
}
