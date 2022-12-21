package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	
	@NotNull(message = "course name cannot be null")
	@NotEmpty(message = "course name cannot be empty")
	private String courseName;
	
	@NotNull(message = "course description cannot be null")
	@NotEmpty(message = "course description cannot be empty")
	private String description;
	
	@NotNull(message = "course type cannot be null")
	@NotEmpty(message = "course type cannot be empty")
	private String courseType;
	
	@NotNull(message = "course duration cannot be null")
	@NotEmpty(message = "course duration cannot be empty")
	private String duration;
	
	@NotNull(message = "course topics cannot be null")
	@NotEmpty(message = "course topics cannot be empty")
	private String topics;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student> studentList = new ArrayList<>();
}
