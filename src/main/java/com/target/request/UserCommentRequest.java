package com.target.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCommentRequest {
    long userId;

    String emailId;

    long itemId;

    String comment;
}
