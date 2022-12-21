package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	
	@NotNull(message = "name cannot be null")
	@NotEmpty(message = "name cannot be empty")
	@Size(min=2, message = "please enter a valid name")
	private String name;
	
	@Size(min=10, max=10, message = "please enter a valid mobile number")
	private String mobile;
	
	@NotNull(message = "father's name cannot be null")
	@NotEmpty(message = "father's name cannot be empty")
	@Size(min=2, message = "please enter a valid name")
	private String fatherName;
	
	@NotNull(message = "mother's name cannot be null")
	@NotEmpty(message = "mother's name cannot be empty")
	@Size(min=2, message = "please enter a valid name")
	private String motherName;
	
	private LocalDate dob;
	
	private String gender;
	
	@NotNull(message = "email cannot be null")
	@NotEmpty(message = "email cannot be empty")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<StudentAddress> studentAddresses = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();
	
}
