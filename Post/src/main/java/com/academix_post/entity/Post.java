package com.academix_post.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_id;

    private String name;

    private String description;

    private String post_file;

    private String post_type;


    @ElementCollection
    List<String> comments = new ArrayList<String>();

    private String post_status;

    private Date post_due_date;

    private Date post_publish_date;

    private Integer classroom_id;

    private String grade;

    public Post() {
    }

    public Post(Integer post_id, String name, String description, String post_file, String post_type, List<String> comments, String post_status, Date post_due_date, Date post_publish_date, Integer classroom_id, String grade) {
        this.post_id = post_id;
        this.name = name;
        this.description = description;
        this.post_file = post_file;
        this.post_type = post_type;
        this.comments = comments;
        this.post_status = post_status;
        this.post_due_date = post_due_date;
        this.post_publish_date = post_publish_date;
        this.classroom_id = classroom_id;
        this.grade = grade;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPost_file() {
        return post_file;
    }

    public void setPost_file(String post_file) {
        this.post_file = post_file;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getPost_status() {
        return post_status;
    }

    public void setPost_status(String post_status) {
        this.post_status = post_status;
    }

    public Date getPost_due_date() {
        return post_due_date;
    }

    public void setPost_due_date(Date post_due_date) {
        this.post_due_date = post_due_date;
    }

    public Date getPost_publish_date() {
        return post_publish_date;
    }

    public void setPost_publish_date(Date post_publish_date) {
        this.post_publish_date = post_publish_date;
    }

    public Integer getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(Integer classroom_id) {
        this.classroom_id = classroom_id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void addcomment(String comment){
        comments.add(comment);
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", post_file='" + post_file + '\'' +
                ", post_type='" + post_type + '\'' +
                ", comments=" + comments +
                ", post_status='" + post_status + '\'' +
                ", post_due_date=" + post_due_date +
                ", post_publish_date=" + post_publish_date +
                ", classroom_id=" + classroom_id +
                ", grade='" + grade + '\'' +
                '}';
    }
}
