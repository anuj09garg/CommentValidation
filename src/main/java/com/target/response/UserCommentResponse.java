package com.target.response;

import lombok.Data;

@Data
public class UserCommentResponse {
    boolean containsObjectionableWords;
    short objectionableWordCount;
    String error;
}
