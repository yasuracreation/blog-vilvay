package vilvay.blog.service.blog.vilvay.customImpl;

import vilvay.blog.service.blog.vilvay.repository.CustomCommentRepository;
import vilvay.blog.service.blog.vilvay.resource.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomCommentRepositoryImpl implements CustomCommentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> getAllCommentByPostId(int postId ) {
        return (List<Comment>) entityManager.createQuery("FROM Comment c WHERE c.postId = :postId").setParameter("postId",postId).getResultList();
    }


}
