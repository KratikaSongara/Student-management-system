package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	private Integer studentId;
	private String name;
	private String mobile;
	private String fatherName;
	private String motherName;
	private LocalDate dob;
	private String gender;
	private String email;
	private List<StudentAddress> studentAddresses = new ArrayList<>();
}
