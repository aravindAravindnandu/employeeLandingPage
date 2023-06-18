package com.employeeGitHub.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeGitHub.Employee.requestDTO.EmployeeRequestDTO;
import com.employeeGitHub.Employee.responseDTO.EmployeeResposeDTO;
import com.employeeGitHub.Employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/getAll") 
	public List<EmployeeResposeDTO> getAllEmployee() throws Exception {
		return service.findAllEmployee();
	}

	@GetMapping("/{id}")
	public EmployeeResposeDTO getEmplyById(@PathVariable Integer id) throws Exception {
		return service.findById(id);
	}

	@GetMapping("/empName/{name}")
	public List<EmployeeResposeDTO> getEmplyByName(@PathVariable String name) throws Exception {
		return service.findByEmployee(name);
	}

	@PostMapping()
	public EmployeeResposeDTO save(@RequestBody EmployeeRequestDTO requestDTO) throws Exception {
		return service.save(requestDTO);
	}

	@PutMapping("/update/{id}")
	public EmployeeResposeDTO update(@PathVariable Integer id, @RequestBody EmployeeRequestDTO requestDTO)
			throws Exception {
		return service.update(id, requestDTO);
	}

	@DeleteMapping("/{id}")
	public EmployeeResposeDTO delete(@PathVariable Integer id) throws Exception {
		return service.deleteById(id);
	}

}
