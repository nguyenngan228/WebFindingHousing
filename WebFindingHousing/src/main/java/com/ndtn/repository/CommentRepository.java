/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndtn.repository;

import com.ndtn.pojo.Comment;
import java.util.List;

/**
 *
 * @author thanh
 */
public interface CommentRepository {
    Comment addComment(Comment cmt);
    List<Comment> getComments(int postId);
}
