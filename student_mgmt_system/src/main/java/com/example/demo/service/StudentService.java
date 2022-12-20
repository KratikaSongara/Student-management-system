package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Course;
import com.example.demo.model.Student;

public interface StudentService {
	public Student registerStudent(Student student);
	public Student assignCourse(Integer studentId, Integer courseId);
	public Student getStudentByName(String studentName);
	public List<Student> getStudentsFromCourse(Integer courseId);
	public Student updateStudentDetails(Integer studentId, Student student);
	public List<Course> searchCourseForStudent(Integer studentId);
	public String leaveCourse(Integer studentId, Integer courseId);
}