package com.academix_teacher.entity;


import com.sharedclasses.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="teacher")
public class Teacher implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacher_id;
    private String teacher_name;

    @ElementCollection
    List<Integer> teacher_classroom_ids = new ArrayList<>();

    private String teacher_email;
    private String teacher_subject;
    private Integer teacher_organization_id;

    private String teacher_org_code;
    private String password;
    private Role role = Role.TEACHER;
    @ElementCollection
    List<Integer> teacher_posts = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String teacher_name, String password,List<Integer> teacher_classroom_ids, String teacher_subject, Integer teacher_organization_id, String teacher_org_code, List<Integer> teacher_posts,String teacher_email) {
        this.teacher_name = teacher_name;
        this.teacher_classroom_ids = teacher_classroom_ids;
        this.teacher_subject = teacher_subject;
        this.teacher_organization_id = teacher_organization_id;
        this.teacher_org_code = teacher_org_code;
        this.teacher_posts = teacher_posts;
        this.teacher_email = teacher_email;
        this.password = password;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public List<Integer> getTeacher_classroom_ids() {
        return teacher_classroom_ids;
    }

    public void setTeacher_classroom_id(List<Integer> teacher_classroom_ids) {
        this.teacher_classroom_ids = teacher_classroom_ids;
    }

    public String getTeacher_subject() {
        return teacher_subject;
    }

    public void setTeacher_subject(String teacher_subject) {
        this.teacher_subject = teacher_subject;
    }

    public Integer getTeacher_organization_id() {
        return teacher_organization_id;
    }

    public void setTeacher_organization_id(Integer teacher_organization_id) {
        this.teacher_organization_id = teacher_organization_id;
    }

    public List<Integer> getTeacher_posts() {
        return teacher_posts;
    }

    public void setTeacher_posts(List<Integer> teacher_posts) {
        this.teacher_posts = teacher_posts;
    }

    public String getTeacher_org_code() {
        return teacher_org_code;
    }

    public void setTeacher_org_code(String teacher_org_code) {
        this.teacher_org_code = teacher_org_code;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public void addClassroom(Integer classroom_id){
        teacher_classroom_ids.add(classroom_id);
    }

    public void setTeacher_classroom_ids(List<Integer> teacher_classroom_ids) {
        this.teacher_classroom_ids = teacher_classroom_ids;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return teacher_email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_classroom_ids=" + teacher_classroom_ids +
                ", teacher_email='" + teacher_email + '\'' +
                ", teacher_subject='" + teacher_subject + '\'' +
                ", teacher_organization_id=" + teacher_organization_id +
                ", teacher_org_code='" + teacher_org_code + '\'' +
                ", password='" + password + '\'' +
                ", teacher_posts=" + teacher_posts +
                '}';
    }
}
