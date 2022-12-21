package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Course;
import com.example.demo.model.CourseDTO;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;

public interface CourseService {
	public List<CourseDTO> getAllCourses();
	public CourseDTO uploadCourse(Course course);
	public String removeCourse(Integer courseId);
	public CourseDTO updateCourse(Integer courseId, Course course);
	public List<StudentDTO> getStudentsFromCourse(Integer courseId);
}
