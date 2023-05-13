package com.footohigh.mongo.service;

import com.mongo.ArticleApplication;
import com.mongo.po.Comment;
import com.mongo.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes= ArticleApplication.class)
class CommentServiceTest {
    @Autowired
    private CommentService commentService;
    @Test
    void saveComment() {

        Comment comment=new Comment();
        comment.setArticleid("100000");
        comment.setContent("测试添加的数据");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("凯撒大帝");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        commentService.saveComment(comment);
    }

    @Test
    void updateComment() {
    }

    @Test
    void deleteCommentById() {
    }

    @Test
    void findCommentList() {
    }

    @Test
    void findCommentById() {
    }
}