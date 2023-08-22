package com.academix_student.StudentDao;

import com.academix_student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentDao extends JpaRepository<Student,Integer> {

    @Query("SELECT o FROM Student o WHERE o.student_roll = :roll and o.year = :year and o.branch = :branch")
    public Student findByStudentRoll(Integer roll,Integer year,String branch);

    @Query("SELECT o FROM Student o WHERE o.student_email = :email")
    Optional<Student> findByStudentEmail(@Param("email") String email);
}
