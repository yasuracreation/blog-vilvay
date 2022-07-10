package vilvay.blog.service.blog.vilvay.customImpl;

import vilvay.blog.service.blog.vilvay.repository.CustomPostRepository;
import vilvay.blog.service.blog.vilvay.resource.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomPostRepositoryImpl implements CustomPostRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Post> getAllPostByAuthor(int authorId) {
        return (List<Post>) entityManager.createQuery("FROM Post p WHERE p.authorId = :authorId").setParameter("authorId",authorId).getResultList();
    }
}
