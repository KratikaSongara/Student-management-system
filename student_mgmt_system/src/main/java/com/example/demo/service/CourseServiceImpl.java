package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseDao;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> getAllCourses() {
		List<Course> list = courseDao.findAll();
		if(list.size() == 0) return null;
 		return list;
	}

	@Override
	public Course uploadCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public String removeCourse(Integer courseId) {
		courseDao.deleteById(courseId);
		return "course deleted successfully!";
	}

	@Override
	public Course updateCourse(Integer courseId, Course course) {
		Optional<Course> opt = courseDao.findById(courseId);
		if(!opt.isPresent()) return null;
		course.setCourseId(opt.get().getCourseId());
		return course;
	}

}
