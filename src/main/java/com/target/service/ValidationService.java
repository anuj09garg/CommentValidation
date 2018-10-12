package com.target.service;

import com.target.request.UserCommentRequest;
import com.target.response.*;

public interface ValidationService {

    UserCommentResponse checkObjectionableContent(UserCommentRequest userCommentRequest) throws Exception;
}
