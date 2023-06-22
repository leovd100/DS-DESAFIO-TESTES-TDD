package com.devsuperior.bds01.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devsuperior.bds01.dto.EmployeeDTO;

public interface EmployeeServiceImpl {

	Page<EmployeeDTO> findAll(Pageable pageable);

	EmployeeDTO save(EmployeeDTO employee);

}
