package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;

public interface CourseService {
	public List<Course> getAllCourses();
	public Course uploadCourse(Course course);
	public String removeCourse(Integer courseId);
	public Course updateCourse(Integer courseId, Course course);
	public List<StudentDTO> getStudentsFromCourse(Integer courseId);
	public List<Course> searchAssignedCourseForStudent(Integer studentId);
}
