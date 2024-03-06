package com.studentManagement.repository;


import com.studentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {

//    @Query("SELECT * FROM students JOIN teachers on students.teacher_id=teachers.teacher_id")
//    List<Student> findAllEmployeesWithDepartment();
    @Query("SELECT s FROM Student s where s.teacherId = 101")
    List<Student> findAllStudentsOfTeacher();
    Optional<Student> findById(String stdid);
}
