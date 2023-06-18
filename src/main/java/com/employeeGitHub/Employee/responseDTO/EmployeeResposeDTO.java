package com.employeeGitHub.Employee.responseDTO;

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
public class EmployeeResposeDTO {
 
	private Integer empId;
	private String employeeName;
	private String employeeAdddress;
	private String employeePlace;
	private Integer age;
	private Long salary;

	public EmployeeResposeDTO(Employee employee) {
		BeanUtils.copyProperties(employee, this);
	}
	
//	public List<EmployeeResposeDTO> convertToModel(List<Employee> employee){
//		List<EmployeeResposeDTO> dtos = new ArrayList<>();
//		BeanUtils.copyProperties(employee, dtos);
//		return dtos;
//	}
}
