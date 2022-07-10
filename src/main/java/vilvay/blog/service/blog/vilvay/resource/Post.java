package vilvay.blog.service.blog.vilvay.resource;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
    @Column(name = "authorId")
    private int authorId;
    @Column(name = "createdOn")
    private Timestamp createdOn;
    @Column(name = "modifiedOn")
    private Timestamp modifiedOn;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "postId")
    private List<Comment> comments = new ArrayList<>();
    public Post( String title, String body, int authorId) {
        this.title = title;
        this.body = body;
        this.authorId = authorId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Timestamp modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
