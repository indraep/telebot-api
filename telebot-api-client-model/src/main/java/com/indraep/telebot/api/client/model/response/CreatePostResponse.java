package com.indraep.telebot.api.client.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostResponse {

  private boolean ok;

  private Result result;

  private Error error;

  @Data
  public static class Result {

    @JsonProperty("post_id")
    private String postId;

    private String link;

  }

  @Data
  public static class Error {

    private int code;

    private String name;

  }

}
