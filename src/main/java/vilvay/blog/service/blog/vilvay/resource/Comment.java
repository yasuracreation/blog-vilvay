package vilvay.blog.service.blog.vilvay.resource;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "Comment")
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name") private String name;
    @Column(name = "email") private String email;
    @Column(name = "body")  private String body;
    @Column(name = "createdOn")  private Timestamp createdOn;
    @Column(name = "modifiedOn")  private Timestamp modifiedOn;
    @Column(name = "postId")
    private int postId;


    public Comment(String name, String email, String body, int postId) {
        this.name = name;
        this.email = email;
        this.body = body;
        this.postId = postId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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


}
