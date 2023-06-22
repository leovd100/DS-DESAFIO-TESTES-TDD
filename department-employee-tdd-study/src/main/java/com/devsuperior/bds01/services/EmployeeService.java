package com.devsuperior.bds01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repository.EmployeeRepository;
import com.devsuperior.bds01.services.impl.EmployeeServiceImpl;

@Service
public class EmployeeService implements EmployeeServiceImpl{
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private DepartmentService departmentService;

	@Override
	public Page<EmployeeDTO> findAll(Pageable pageable) {
		Page<Employee> page = repository.findAll(pageable);
		return page.map(EmployeeDTO::new);
	}

	@Override
	public EmployeeDTO save(EmployeeDTO employeeDto) {
		Department department = findDepartmentById(employeeDto.getDepartmentId());
		Employee employee = new Employee(employeeDto, department);
		employee = repository.save(employee);
		return new EmployeeDTO(employee);
	}
	
	private Department findDepartmentById(Long id) {
		 return departmentService.findDepartmentById(id);
	}
	
}
