package com.devsuperior.bds02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.exception.CityException;
import com.devsuperior.bds02.exception.DataBaseException;
import com.devsuperior.bds02.repository.CityRepository;
import com.devsuperior.bds02.service.impl.CityServiceImpl;

@Service
public class CityServices implements CityServiceImpl {

	
	private final CityRepository repository;
	
	public CityServices(CityRepository cityRepository) {
		this.repository = cityRepository;
	}
	
	@Override
	public List<CityDTO> findAll(Pageable page) {
		return repository.findAll(page).map(CityDTO::new).toList();
	}

	@Override
	public CityDTO insertCity(CityDTO dto) {
		City city = new City();
		city.setName(dto.getName());
		return new CityDTO(repository.save(city));
	}
	


	@Override
	public void deleteById(Long id) {
		try {
			this.repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new CityException("Id not found");
		}catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation");
		}
	}

	@Override
	public City findById(Long id) {
		try {
			return repository.findById(id).get();
		}catch(IllegalArgumentException e) {
			throw new CityException("Id not found");
		}catch (EmptyResultDataAccessException e) {
			throw new CityException("Id not found");
		}
	}

}
