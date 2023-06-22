package com.devsuperior.bds01.dto;

import com.devsuperior.bds01.entities.Department;

public class DepartmentDto {
	public Long id;
	public String name;
	
	public void DeparmentDto() {
		
	}

	public DepartmentDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public DepartmentDto(Department entity) {
		this.id = entity.id;
		this.name = entity.name;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
