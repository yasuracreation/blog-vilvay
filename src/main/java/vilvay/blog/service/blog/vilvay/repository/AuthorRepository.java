package vilvay.blog.service.blog.vilvay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vilvay.blog.service.blog.vilvay.resource.Author;

public interface AuthorRepository extends JpaRepository<Author , Integer> {

}
