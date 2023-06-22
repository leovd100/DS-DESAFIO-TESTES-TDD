package com.devsuperior.bds01.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.bds01.dto.DepartmentDto;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.exceptions.DepartmentException;
import com.devsuperior.bds01.repository.DepartmentRepository;
import com.devsuperior.bds01.services.impl.DepartmentServiceImpl;

@Service
public class DepartmentService implements DepartmentServiceImpl{
	
	@Autowired
	public DepartmentRepository repository;
	
	@Override
	public List<DepartmentDto> findAll(Pageable page) {
		return repository.findAll(page).stream().map(DepartmentDto::new).collect(Collectors.toList());
	}
	
	protected Department findDepartmentById(Long id) {
		Optional<Department> department = repository.findById(id);
		return department.orElseThrow(() -> new DepartmentException("Id not found"));
	}
}
