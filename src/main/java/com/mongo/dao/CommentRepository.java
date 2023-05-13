package com.mongo.dao;


import com.mongo.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
//评论的持久层接口
public interface CommentRepository extends MongoRepository<Comment,String> {
    Page<Comment> findByParentId(String parentId, Pageable pageable);
}