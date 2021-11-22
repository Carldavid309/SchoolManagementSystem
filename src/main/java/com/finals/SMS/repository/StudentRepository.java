package com.finals.SMS.repository;

import java.util.List;

import com.finals.SMS.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    //ポイント①
    @Query("SELECT s FROM Student s ORDER BY s.id")
    List<Student> findAllOrderById();
}
