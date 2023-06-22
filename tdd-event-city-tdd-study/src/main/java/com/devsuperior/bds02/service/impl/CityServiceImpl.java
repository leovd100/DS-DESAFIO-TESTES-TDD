package com.devsuperior.bds02.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;

public interface CityServiceImpl {
	
	List<CityDTO> findAll(Pageable page);
	
	City findById(Long id); 

	CityDTO insertCity(CityDTO dto);

	void deleteById(Long id);
}
