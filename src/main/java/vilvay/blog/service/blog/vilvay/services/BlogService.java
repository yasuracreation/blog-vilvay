package vilvay.blog.service.blog.vilvay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import vilvay.blog.service.blog.vilvay.repository.AuthorRepository;
import vilvay.blog.service.blog.vilvay.repository.CommentRepository;
import vilvay.blog.service.blog.vilvay.repository.PostRepository;
import vilvay.blog.service.blog.vilvay.resource.Author;
import vilvay.blog.service.blog.vilvay.resource.Comment;
import vilvay.blog.service.blog.vilvay.resource.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CommentRepository commentRepository;

    public BlogService(PostRepository postRepository , AuthorRepository authorRepository){
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;

    }
    public ResponseEntity<List<Post>> getAllPost(){
        List<Post> posts = new ArrayList<>(postRepository.findAll());
        if(posts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts , HttpStatus.OK);
    }
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        try {
            Post _post = postRepository.save(new Post(post.getTitle(),post.getBody() , post.getAuthorId()));
            return new ResponseEntity<>(_post , HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Post> updatePost(@PathVariable("id") int id , @RequestBody Post post){
        Optional<Post> _post =  postRepository.findById(id);
        if(_post.isPresent()){
            try {
                Post postData = _post.get();
                if(StringUtils.hasText(post.getTitle())){
                    postData.setTitle(post.getTitle());
                }
                if(StringUtils.hasText(post.getBody())){
                    postData.setBody(post.getBody());
                }
                if(post.getAuthorId() > 0){
                    // post author id should grater than 0
                    postData.setAuthorId(post.getAuthorId());
                }
                return new ResponseEntity<>(postRepository.save(postData),HttpStatus.OK);

            }catch (Exception e){
                return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<HttpStatus> deletePost(@PathVariable int id ){
        try {
            postRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<List<Author>> getAllAuthor(){
        List<Author> authors = new ArrayList<>(authorRepository.findAll());
        if(authors.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(authors , HttpStatus.OK);
    }
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        try {
            Author _author = authorRepository.save(new Author(author.getName(),author.getUserName() , author.getEmail(),author.getAddress()));
            return new ResponseEntity<>(_author , HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") int id , @RequestBody Author author){
        Optional<Author> _author =  authorRepository.findById(id);
        if(_author.isPresent()){
            try {
                Author authorData = _author.get();
                if(StringUtils.hasText(author.getName())){
                    authorData.setName(author.getName());
                }
                if(StringUtils.hasText(author.getUserName())){
                    authorData.setUserName(author.getUserName());
                }
                if(StringUtils.hasText(author.getEmail())){
                    // post author id should grater than 0
                    authorData.setEmail(author.getEmail());
                }
                return new ResponseEntity<>(authorRepository.save(authorData),HttpStatus.OK);

            }catch (Exception e){
                return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable int id ){
        try {
            authorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    public ResponseEntity<List<Comment>> getAllComment(){
        List<Comment> authors = new ArrayList<>(commentRepository.findAll());
        if(authors.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(authors , HttpStatus.OK);
    }
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
        try {
            Comment _comment = commentRepository.save(new Comment(comment.getName(),comment.getEmail() , comment.getBody(),comment.getPostId()));
            return new ResponseEntity<>(_comment , HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Comment> updateComment(@PathVariable("id") int id , @RequestBody Comment comment){
        Optional<Comment> _comment =  commentRepository.findById(id);
        if(_comment.isPresent()){
            try {
                Comment commentData = _comment.get();
                if(StringUtils.hasText(comment.getName())){
                    commentData.setName(comment.getName());
                }
                if(StringUtils.hasText(comment.getBody())){
                    commentData.setBody(comment.getBody());
                }
                if(StringUtils.hasText(comment.getEmail())){
                    // post author id should grater than 0
                    commentData.setEmail(comment.getEmail());
                }
                if(comment.getPostId() > 0){
                    // post author id should grater than 0
                    commentData.setPostId(comment.getPostId());
                }
                return new ResponseEntity<>(commentRepository.save(commentData),HttpStatus.OK);

            }catch (Exception e){
                return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable int id ){
        try {
            commentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Comment>> getAllCommentByPostId(int postId) {
       return (ResponseEntity<List<Comment>>) commentRepository.getAllCommentByPostId(postId);
    }
//    public ResponseEntity<List<Post>> getAllPostByAuthorId(int authorId){
//        return (ResponseEntity<List<Post>>) postRepository.getAllPostByAuthor(authorId);
//    }
}
