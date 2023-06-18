package com.employeeGitHub.Employee.service;

import java.util.List;

import com.employeeGitHub.Employee.requestDTO.EmployeeRequestDTO;
import com.employeeGitHub.Employee.responseDTO.EmployeeResposeDTO;

public interface EmployeeService {

	List<EmployeeResposeDTO> findAllEmployee() throws Exception;
	
	EmployeeResposeDTO findById(Integer id) throws Exception;
	
	List<EmployeeResposeDTO> findByEmployee(String empName)throws Exception;
	
	EmployeeResposeDTO save(EmployeeRequestDTO employeeRequestDTO)throws Exception;
	
	EmployeeResposeDTO update(Integer id,EmployeeRequestDTO employeeRequestDTO) throws Exception;
	
	EmployeeResposeDTO deleteById(Integer id) throws Exception;
	
}
