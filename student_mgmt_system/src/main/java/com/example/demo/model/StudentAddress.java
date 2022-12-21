package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class StudentAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	@NotNull(message = "please enter area")
	@NotEmpty(message = "please enter area")
	private String area;
	
	@NotNull(message = "please enter city")
	@NotEmpty(message = "please enter city")
	private String city;
	
	@NotNull(message = "please enter state")
	@NotEmpty(message = "please enter state")
	private String state;
	
	@NotNull(message = "please enter district")
	@NotEmpty(message = "please enter district")
	private String district;
	
	@NotNull(message = "please enter pincode")
	@NotEmpty(message = "please enter pincode")
	private String pincode;
	
	@NotNull(message = "please enter addressType")
	@NotEmpty(message = "please enter addressType")
	private String addressType; 
}
