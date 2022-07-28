package com.example.demo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpVO {
	String employeeId;
	String firstName;
	String lastName;
	String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	Date hireDate;
	int salary;
	String jobId;
	String departmentId;
	String managerId;
	Double commissionPct;
}
