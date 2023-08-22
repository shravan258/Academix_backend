package com.academix_student.entity;


import com.sharedclasses.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "student")
public class Student implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;

    private String student_name;

    private String student_email;

    private String student_password;

    private Integer student_organization;

    private Integer student_roll;

    private String branch;

    private Integer year;

    private Role role = Role.STUDENT;

    @ElementCollection
    List<Integer> student_classrooms = new ArrayList<>();

    public Student() {
    }

    public Student(Integer student_id, String student_name, String student_email, String student_password, Integer student_organization, Integer student_roll, String branch, Integer year, Role role, List<Integer> student_classrooms) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_email = student_email;
        this.student_password = student_password;
        this.student_organization = student_organization;
        this.student_roll = student_roll;
        this.branch = branch;
        this.year = year;
        this.role = role;
        this.student_classrooms = student_classrooms;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Integer getStudent_organization() {
        return student_organization;
    }

    public void setStudent_organization(Integer student_organization) {
        this.student_organization = student_organization;
    }

    public Integer getStudent_roll() {
        return student_roll;
    }

    public void setStudent_roll(Integer student_roll) {
        this.student_roll = student_roll;
    }

    public List<Integer> getStudent_classrooms() {
        return student_classrooms;
    }

    public void setStudent_classrooms(List<Integer> student_classrooms) {
        this.student_classrooms = student_classrooms;
    }

    public String getBranch() {
        return branch;
    }

    public Integer getYear() {
        return year;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_email='" + student_email + '\'' +
                ", student_password='" + student_password + '\'' +
                ", student_organization=" + student_organization +
                ", student_roll=" + student_roll +
                ", branch='" + branch + '\'' +
                ", year=" + year +
                ", role=" + role +
                ", student_classrooms=" + student_classrooms +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return student_password;
    }

    @Override
    public String getUsername() {
        return student_email;
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
}
