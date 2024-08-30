package com.example.demo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // 필수
public class Departments {
	// 타입은 되도록 클래스(Long, Integer 등)로 주자(그래야 null 처리 가능)
	@Id // 필수
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id", nullable = false)
	private Long departmentId;
	@Column(name = "department_name", nullable = false)
	private String departmentName;
	@Column(name = "manager_id")
	private Integer managerId;
	@Column(name = "location_id")
	private Integer locationId;
}
