package vilvay.blog.service.blog.vilvay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vilvay.blog.service.blog.vilvay.resource.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
