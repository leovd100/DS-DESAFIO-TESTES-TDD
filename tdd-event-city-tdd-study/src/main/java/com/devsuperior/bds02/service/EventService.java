package com.devsuperior.bds02.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.exception.CityException;
import com.devsuperior.bds02.exception.EventException;
import com.devsuperior.bds02.repository.EventRepository;
import com.devsuperior.bds02.service.impl.CityServiceImpl;
import com.devsuperior.bds02.service.impl.EventServiceImpl;

@Service
public class EventService implements EventServiceImpl{

	@Autowired
	private EventRepository repository;
	
	@Autowired
	private CityServiceImpl cityService;
	
	@Override
	public EventDTO putEvent(Long id, EventDTO dto) {
	
			Event event = repository.findById(id).orElseThrow(() -> new EventException("Event Id Not Found"));
			City city = cityService.findById(dto.getCityId());
			convertDtoToEvent(id,event, dto, city);
			return new EventDTO(repository.save(event));
		
	}
	
	private void convertDtoToEvent(Long id,Event entity,EventDTO dto, City city) {
		entity.setCity(city);
		entity.setDate(dto.getDate());
		entity.setName(dto.getName());
		entity.setUrl(dto.getUrl());
	}
}
