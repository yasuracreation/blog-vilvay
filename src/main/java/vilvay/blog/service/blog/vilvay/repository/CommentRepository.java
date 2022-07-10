package vilvay.blog.service.blog.vilvay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import vilvay.blog.service.blog.vilvay.resource.Comment;
@EnableJpaRepositories
public interface CommentRepository extends JpaRepository<Comment , Integer> , CustomCommentRepository {
}
