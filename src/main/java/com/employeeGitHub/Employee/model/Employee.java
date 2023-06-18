package com.employeeGitHub.Employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.employeeGitHub.Employee.requestDTO.EmployeeRequestDTO;
import com.employeeGitHub.Employee.responseDTO.EmployeeResposeDTO;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String employeeName;
	private String employeeAdddress;
	private String employeePlace;
	private Integer age;
	private Long salary;

	public EmployeeResposeDTO convertToModel(Employee employee) {
		BeanUtils.copyProperties(employee, this);
		return new EmployeeResposeDTO(employee);
	}
	
	public EmployeeRequestDTO convertToRequestModel(Employee employee) {
		BeanUtils.copyProperties(employee, this);
		return new EmployeeRequestDTO(employee);
	}
}
