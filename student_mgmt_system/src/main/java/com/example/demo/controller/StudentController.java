package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.model.CourseDTO;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
		return new ResponseEntity<>(studentService.registerStudent(student), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{studentId}/{courseId}/")
	public ResponseEntity<String> assignCourseToStudent(@PathVariable("studentId") Integer studentId, @PathVariable("courseId") Integer courseId) {
		return new ResponseEntity<>(studentService.assignCourse(studentId, courseId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{name}/")
	public ResponseEntity<List<StudentDTO>> getStudentsByNameHandler(@PathVariable("name") String name) {
		return new ResponseEntity<>(studentService.getStudentByName(name),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{studentId}/")
	public ResponseEntity<StudentDTO> updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody StudentDTO student, @RequestParam("dob") String dob) {
		return new ResponseEntity<>(studentService.updateStudentDetails(studentId, student, dob), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{studentId}/{courseId}/")
	public ResponseEntity<String> removeStudentFromCourseHandler(@PathVariable("studentId") Integer studentId, @PathVariable("courseId") Integer courseId, @RequestParam("dob") String dob) {
		return new ResponseEntity<>(studentService.leaveCourse(studentId, courseId, dob), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CourseDTO>> getAssignedCoursesOfStudentHandler(@RequestParam("studentId") Integer studentId, @RequestParam("dob") String dob) {
		return new ResponseEntity<>(studentService.searchAssignedCourseForStudent(studentId, dob), HttpStatus.ACCEPTED);
	}
	
}
