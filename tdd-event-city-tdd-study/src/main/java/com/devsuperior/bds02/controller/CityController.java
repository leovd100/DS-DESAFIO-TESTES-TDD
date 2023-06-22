package com.devsuperior.bds02.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.service.impl.CityServiceImpl;

@RestController
@RequestMapping("/cities")
public class CityController {

	private final CityServiceImpl service;
	
	public CityController(CityServiceImpl serviceImpl) {
		this.service = serviceImpl;
	}
	
	@GetMapping
	public ResponseEntity<List<CityDTO>> findAll(@PageableDefault(page = 0,size = 10, sort = "name", direction = Direction.ASC) Pageable pageable){
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@PostMapping
	public ResponseEntity<CityDTO> insert(@RequestBody CityDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insertCity(dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
