package com.app.service;

import java.util.List;

import com.app.dto.EventDTO;
import com.app.pojos.Event;

public interface EventService {
	List<EventDTO> getEvents();
	EventDTO getEvent(Long event_id);
	String addEvent(EventDTO event);
	String updateEvent(Long event_id, EventDTO event);
	String deleteEvent(Long event_id);

}
