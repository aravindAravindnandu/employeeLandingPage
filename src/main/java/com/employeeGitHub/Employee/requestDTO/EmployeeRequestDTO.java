package com.employeeGitHub.Employee.requestDTO;

import org.apache.maven.surefire.shared.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.employeeGitHub.Employee.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {

	private String employeeName;
	private String employeeAdddress;
	private String employeePlace;
	private Integer age;
	private Long salary;

	public Employee convertToModelRequest(Employee employee) {
		if (StringUtils.isNotBlank(this.employeeName)) {
			employee.setEmployeeName(this.employeeName);
		}
		if (StringUtils.isNotBlank(this.employeeAdddress)) {
			employee.setEmployeeAdddress(this.employeeAdddress);
		}
		if (StringUtils.isNotBlank(this.employeePlace)) {
			employee.setEmployeePlace(this.employeePlace);
		}
		if (this.age != null && this.age > 0) {
			employee.setAge(this.age);
		}
		if (this.salary != null && this.salary > 0) {
			employee.setSalary(this.salary);
		}
		return employee;
	}
	
	public EmployeeRequestDTO(Employee employee) {
		BeanUtils.copyProperties(this, employee);
	}
	
	public Employee convertToModel(EmployeeRequestDTO requestDTO) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(requestDTO, employee);
		return employee;
	}

}
