package com.devsuperior.bds01.services.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.devsuperior.bds01.dto.DepartmentDto;

public interface DepartmentServiceImpl {
	
	List<DepartmentDto> findAll(Pageable pageable);
	
}
