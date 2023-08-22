package com.academix_classroom.Dao;

import com.academix_classroom.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassroomDao extends JpaRepository<Classroom,Integer> {


    @Query("SELECT o FROM Classroom o WHERE o.classroom_name = :name")
    public Classroom findByClassroomName(String name);

    @Query("SELECT o FROM Classroom o WHERE o.classroom_code = :code")
    public Classroom findByClassroomCode(String code);

}
