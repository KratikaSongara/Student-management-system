package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.Course;
import com.example.demo.model.CourseDTO;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;

public interface StudentService {
	public Student registerStudent(Student student);
	public String assignCourse(Integer studentId, Integer courseId);
	public List<StudentDTO> getStudentByName(String studentName);
	public StudentDTO updateStudentDetails(Integer studentId, StudentDTO student, String dob);
	public String leaveCourse(Integer studentId, Integer courseId, String dob);
	public Boolean validateStudent(Integer studentId, String dob);
	public List<CourseDTO> searchAssignedCourseForStudent(Integer studentId, String dob);
}
