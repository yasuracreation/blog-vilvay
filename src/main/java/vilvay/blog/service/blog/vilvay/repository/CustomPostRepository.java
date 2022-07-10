package vilvay.blog.service.blog.vilvay.repository;

import vilvay.blog.service.blog.vilvay.resource.Post;

import java.util.List;

public interface CustomPostRepository {
    List<Post> getAllPostByAuthor(int authorId);
}
