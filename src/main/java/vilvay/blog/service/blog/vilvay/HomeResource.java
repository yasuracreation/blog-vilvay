package vilvay.blog.service.blog.vilvay;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vilvay.blog.service.blog.vilvay.resource.Author;
import vilvay.blog.service.blog.vilvay.resource.Comment;
import vilvay.blog.service.blog.vilvay.resource.Post;
import vilvay.blog.service.blog.vilvay.services.BlogService;

import java.util.List;

@RestController
public class HomeResource {


    private BlogService blogService;
    public HomeResource(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPost(){

        return blogService.getAllPost();
    }
    @PostMapping("/post")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
      return blogService.createPost(post);
    }
    @PutMapping("/post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") int id , @RequestBody Post post){
        return blogService.updatePost(id,post);

    }
    @DeleteMapping("/post/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable int id ){
       return blogService.deletePost(id);
    }

    @GetMapping("/author")
    public ResponseEntity<List<Author>> getAllAuthor(){
       return blogService.getAllAuthor();
    }
    @PostMapping("/author")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
       return blogService.createAuthor(author);
    }
    @PutMapping("/author/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") int id , @RequestBody Author author){
        return blogService.updateAuthor(id, author);

    }
    @DeleteMapping("/author/{id}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable int id ){
       return blogService.deleteAuthor(id);
    }


    @GetMapping("/comment")
    public ResponseEntity<List<Author>> getAllComment(){
        return blogService.getAllAuthor();
    }
    @PostMapping("/comment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
        return blogService.createComment(comment);
    }
    @PutMapping("/comment/{id}")
    public ResponseEntity<Comment> updateAuthor(@PathVariable("id") int id , @RequestBody Comment comment){
        return blogService.updateComment(id, comment);

    }
    @DeleteMapping("/comment/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable int id ){
        return blogService.deleteAuthor(id);
    }
    @GetMapping("/post/{id}/comments")
    public ResponseEntity<List<Comment>> getAllCommentsByPostId(@PathVariable("postId") int postId ){
        return blogService.getAllCommentByPostId(postId);
    }
//    @GetMapping("/author/{id}/post")
//    public ResponseEntity<List<Post>> getAllPostByAuthorId(@PathVariable("authorId") int authorId ){
//        return blogService.getAllPostByAuthorId(authorId);
//    }
}
