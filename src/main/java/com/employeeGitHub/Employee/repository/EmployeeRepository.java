package com.employeeGitHub.Employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.employeeGitHub.Employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer>,JpaSpecificationExecutor<Employee>{

	Employee findByempId(Integer id);
	
	List<Employee> findByEmployeeName(String empName);

}
