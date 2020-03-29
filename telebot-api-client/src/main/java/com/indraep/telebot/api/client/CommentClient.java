package com.indraep.telebot.api.client;

import com.blibli.oss.backend.apiclient.annotation.ApiClient;
import com.indraep.telebot.api.client.error_resolver.CommentClientErrorResolver;
import com.indraep.telebot.api.client.fallback.CommentClientFallback;
import com.indraep.telebot.api.client.interceptor.CommentClientInterceptor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.indraep.telebot.api.client.model.response.CreatePostResponse;
import reactor.core.publisher.Mono;

@ApiClient(
    name = "commentClient",
    fallback = CommentClientFallback.class,
    errorResolver = CommentClientErrorResolver.class,
    interceptors = CommentClientInterceptor.class
)
public interface CommentClient {

  @RequestMapping(value = "/createPost",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  Mono<CreatePostResponse> createPost(
      @RequestParam("type") String type,
      @RequestParam("owner_id") long ownerId,
      @RequestParam("text") String text);

}
