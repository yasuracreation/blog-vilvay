package vilvay.blog.service.blog.vilvay.repository;

import vilvay.blog.service.blog.vilvay.resource.Comment;

import java.util.List;

public interface CustomCommentRepository {
     List<Comment> getAllCommentByPostId(int postId);


}
