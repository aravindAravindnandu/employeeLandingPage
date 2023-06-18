package com.employeeGitHub.Employee.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.employeeGitHub.Employee.model.Employee;
import com.employeeGitHub.Employee.repository.EmployeeRepository;
import com.employeeGitHub.Employee.requestDTO.EmployeeRequestDTO;
import com.employeeGitHub.Employee.responseDTO.EmployeeResposeDTO;
import com.employeeGitHub.Employee.service.EmployeeService;

@Service
public class EmployeeImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	private ModelMapper mapper = new ModelMapper();

	@Override
	public List<EmployeeResposeDTO> findAllEmployee() throws Exception {
		List<EmployeeResposeDTO> empList = employeeRepository.findAll().stream().map(EmployeeResposeDTO::new).toList();
		if (empList != null && !ObjectUtils.isEmpty(empList)) {
			return empList;
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public EmployeeResposeDTO findById(Integer id) throws Exception {
		Employee employee = employeeRepository.findByempId(id);
		if (employee != null && !ObjectUtils.isEmpty(employee)) {
			return new EmployeeResposeDTO(employee);
		} else {
			return null;
		}
	}

	@Override
	public List<EmployeeResposeDTO> findByEmployee(String empName) throws Exception {
		List<Employee> employeeList = employeeRepository.findByEmployeeName(empName);
		if (employeeList != null && !ObjectUtils.isEmpty(employeeList)) {
			List<EmployeeResposeDTO> deptDTO = Arrays.asList(mapper.map(employeeList, EmployeeResposeDTO[].class));
			return deptDTO;
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public EmployeeResposeDTO save(EmployeeRequestDTO employeeRequestDTO) throws Exception {
		if (employeeRequestDTO != null && !ObjectUtils.isEmpty(employeeRequestDTO)) {
			Employee employee = employeeRequestDTO.convertToModel(employeeRequestDTO);
			 return new EmployeeResposeDTO(employeeRepository.save(employee));
		} else {
			return null;
		}
	}

	@Override
	public EmployeeResposeDTO update(Integer id, EmployeeRequestDTO employeeRequestDTO) throws Exception {
		Employee employee = employeeRepository.findByempId(id);
		if (employee != null && !ObjectUtils.isEmpty(employee)) {
			Employee emp = employeeRequestDTO.convertToModelRequest(employee);
			 return new EmployeeResposeDTO(employeeRepository.save(emp));
		} else {
			return null;
		}
	}

	@Override
	public EmployeeResposeDTO deleteById(Integer id) throws Exception {
		Employee employee = employeeRepository.findByempId(id);
		if (employee != null && !ObjectUtils.isEmpty(employee)) {
			employeeRepository.deleteById(id);
			return new EmployeeResposeDTO(employee);
		} else {
			return null;
		}
	}

}
