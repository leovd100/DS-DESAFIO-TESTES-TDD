package com.devsuperior.bds01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds01.dto.DepartmentDto;
import com.devsuperior.bds01.services.impl.DepartmentServiceImpl;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentServiceImpl service;
	
	@GetMapping
	public List<DepartmentDto> findAllDepartments(@PageableDefault(page = 0,size = 10, sort = "name", direction = Direction.ASC) Pageable pageable){
		return service.findAll(pageable);
	}
	
	
}
