package com.target.controller;

import com.target.request.UserCommentRequest;
import com.target.response.*;
import com.target.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "target/v1")
public class ValidationController {

    @Autowired
    ValidationService validationService;

    @PostMapping(value = "/checkObjectionableContent")
    public UserCommentResponse checkObjectionableContent(RequestEntity<UserCommentRequest> requestEntity) throws Exception {
        return validationService.checkObjectionableContent(requestEntity.getBody());
    }

}
