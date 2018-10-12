package com.target.service.serviceimpl;

import com.target.request.UserCommentRequest;
import com.target.response.*;
import com.target.service.ValidationService;
import com.target.utils.ObjectionableWords;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ValidationServiceImpl implements ValidationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationServiceImpl.class);

    @Override
    public UserCommentResponse checkObjectionableContent(UserCommentRequest userCommentRequest){
        LOGGER.debug("Checking Objectionable Content with request {}",userCommentRequest);
        short objectionableWordCount=0;
        ObjectionableWords objectionableWords = new ObjectionableWords();

        List<String> objectionableWordsList = Arrays.asList(objectionableWords.getObjectionableWordsList());
        objectionableWordCount = countObjectionableWords(userCommentRequest.getComment(),objectionableWordsList);

        return getUserCommentResponse(objectionableWordCount);

    }

    private short countObjectionableWords(String comment, List objectionableWordsList) {
        LOGGER.debug("countObjectionableWords execution started with comment {}, objectionableWordsList {}",
                comment,objectionableWordsList);
        short count=0;
        int wordLength;
        String [] commentWords = comment.split(" ");
        wordLength = commentWords.length;

        if(objectionableWordsList.isEmpty()){
            LOGGER.error("objectionableWordsList is empty");
            return 0;
        }

        for(int i = 0 ;i<wordLength;i++){
            if(objectionableWordsList.contains(commentWords[i])){
                count++;
            }
        }
        LOGGER.debug("objectionableWordsList execution ended");

        return count;
    }

    private UserCommentResponse getUserCommentResponse(short count){
        LOGGER.debug("getUserCommentResponse execution started");
        UserCommentResponse userCommentResponse = new UserCommentResponse();
        userCommentResponse.setObjectionableWordCount(count);
        if(count>0){
            userCommentResponse.setContainsObjectionableWords(true);
        }
        else{
            userCommentResponse.setContainsObjectionableWords(false);
        }
        return userCommentResponse;
    }

}
