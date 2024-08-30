package com.example.demo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // 필수
public class Customer {
	@Id // 필수
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 20, nullable = false)
	private String name;
	@Column(length = 20, nullable = false, unique = true)
	private String phone;
	
	private String email;
	@CreationTimestamp
	private Timestamp rdt;
	@UpdateTimestamp
	private Timestamp udt;
}
