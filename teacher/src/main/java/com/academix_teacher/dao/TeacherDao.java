package com.academix_teacher.dao;

import com.academix_teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TeacherDao extends JpaRepository<Teacher,Integer> {

    @Query("SELECT o FROM Teacher o WHERE o.teacher_email = :email")
    Optional<Teacher> findByTeacherEmail(@Param("email") String email);
}
