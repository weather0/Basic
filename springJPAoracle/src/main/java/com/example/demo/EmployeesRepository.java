package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long>{
	public List<Employees> findByEmail(String email);
	
	// 부서별로 검색 first_name 정렬
	// 쿼리작성주의!!!) 실제 DB테이블이 아니라 자바 클래스명(Employees)과 VO객체명을 적어야 한다!!!!
//	@Query("select e from Employees e where departmentId like ?1 order by firstName")
//	public List<Employees> findByDepartmentId(Integer departmentId);
	
}
