package com.indraep.telebot.api.client.fallback;

import com.indraep.telebot.api.client.CommentClient;
import com.indraep.telebot.api.client.model.response.CreatePostResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CommentClientFallback implements CommentClient {
  @Override
  public Mono<CreatePostResponse> createPost(String type, long ownerId, String text) {
    return Mono.fromCallable(() -> CreatePostResponse.builder()
        .ok(false)
        .build());
  }
}
