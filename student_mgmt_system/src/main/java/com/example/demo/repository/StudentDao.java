package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{
	public List<Student> findByName(String studentName);
//	@Query("from Student where courses_course_id = :courseId and student_id = :studentId")
//	public Student getStudent(Integer studentId, Integer courseId);
}
