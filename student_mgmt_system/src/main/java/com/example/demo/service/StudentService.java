package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;

public interface StudentService {
	public Student registerStudent(Student student);
	public String assignCourse(Integer studentId, Integer courseId);
	public List<StudentDTO> getStudentByName(String studentName);
	public StudentDTO updateStudentDetails(Integer studentId, StudentDTO student);
//	public List<Course> searchAssignedCourseForStudent(Integer studentId);
	public String leaveCourse(Integer studentId, Integer courseId);
//	public List<StudentDTO> getStudentsFromCourse(Integer courseId);
}
