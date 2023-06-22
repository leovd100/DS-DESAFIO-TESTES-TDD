package com.devsuperior.bds02.service.impl;

import com.devsuperior.bds02.dto.EventDTO;

public interface EventServiceImpl {
	EventDTO putEvent(Long id, EventDTO dto);
}
