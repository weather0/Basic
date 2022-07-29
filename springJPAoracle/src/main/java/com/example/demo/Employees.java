package com.example.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // 필수
public class Employees {
	// 타입은 되도록 클래스(Long, Integer 등)로 주자(그래야 null 처리 가능)
	@Id // 필수
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id", length = 6, nullable = false)
	private Long employeeId;
	@Column(name = "first_name", length = 20, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 25, nullable = false)
	private String lastName;
	@Column(length = 25, nullable = false, unique = true)
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "hire_date", nullable = false)
	@Temporal(TemporalType.DATE) // <- java.util.Date일 경우 필수
	private Date hireDate;
	@Column(name = "job_id", nullable = false)
	private String jobId;
	private Integer salary;
	@Column(name = "commission_pct")
	private Double commissionPct;
	@Column(name = "manager_id")
	private Integer managerId;
	
//	@Column(name = "department_id")
//	private Integer departmentId;
	// 조인
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Departments departments;
}
