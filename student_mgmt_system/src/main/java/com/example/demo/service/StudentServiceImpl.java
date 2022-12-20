package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.repository.CourseDao;
import com.example.demo.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private CourseDao courseDao;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Student registerStudent(Student student) {
		studentDao.save(student);
		return student;
	}

	@Override
	public String assignCourse(Integer studentId, Integer courseId) {
		Optional<Course> courseOpt = courseDao.findById(courseId);
//		if(!courseOpt.isPresent()) return null;
		Course course = courseOpt.get();
		Optional<Student> studentOpt = studentDao.findById(studentId);
		Student student = studentOpt.get();
		student.getCourses().add(courseOpt.get());
		course.getStudentList().add(student);
		studentDao.save(student);
		return "course assigned to student with id "+student.getStudentId()+" successfully";
	}

	@Override
	public List<StudentDTO> getStudentByName(String studentName) {
		List<Student> student = studentDao.findByName(studentName);
		List<StudentDTO> list = new ArrayList<>();
		for(Student s : student) {
			list.add(modelMapper.map(s, StudentDTO.class));
		}
		return list;
	}

//	@Override
//	public List<StudentDTO> getStudentsFromCourse(Integer courseId) {
//		List<Student> student = studentDao.getStudentsByCourse(courseId);
//		List<StudentDTO> list = new ArrayList<>();
//		for(Student s : student) {
//			list.add(modelMapper.map(s, StudentDTO.class));
//		}
//		return list;
//	}

	@Override
	public StudentDTO updateStudentDetails(Integer studentId, StudentDTO student) {
		Optional<Student> opt = studentDao.findById(studentId);
		if(!opt.isPresent()) return null;
		Student student2 = modelMapper.map(student, Student.class);
		studentDao.save(student2);
		return student;
	}

//	@Override
//	public List<Course> searchAssignedCourseForStudent(Integer studentId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String leaveCourse(Integer studentId, Integer courseId) {
		Optional<Student> studentopt = studentDao.findById(studentId);
		Optional<Course> courseopt = courseDao.findById(courseId);
		Student student = studentopt.get();
		Course course = courseopt.get();
		if(student.getCourses().contains(course)) {
			student.getCourses().remove(course);
		}
		if(course.getStudentList().contains(student)) {
			course.getStudentList().remove(student);
		}
		studentDao.save(student);
		courseDao.save(course);
		return "student successfully removed";
	}

}
