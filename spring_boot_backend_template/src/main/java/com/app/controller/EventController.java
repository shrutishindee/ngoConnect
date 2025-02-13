package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EventDTO;
import com.app.service.EventService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping
	public ResponseEntity<?> getAllEntites(){
		List<EventDTO> events = eventService.getEvents();
		if(events.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(events);
	}

	@GetMapping("/{event_id}")
	public ResponseEntity<?> getEvent(@PathVariable Long event_id){ 
			return ResponseEntity.ok(eventService.getEvent(event_id));
	}
	
	@PostMapping
	public ResponseEntity<?> addNewEvent(@RequestBody EventDTO event){
		return ResponseEntity.status(HttpStatus.CREATED).body(eventService.addEvent(event));
	}
	
	@PutMapping("/{event_id}")
	public ResponseEntity<?> updateEvent(@RequestBody EventDTO event, @PathVariable Long event_id){
		return ResponseEntity.ok(eventService.updateEvent(event_id, event));
	}
	
	@DeleteMapping("/{event_id}")
	public ResponseEntity<?> deleteEventById(@PathVariable Long event_id){
		return ResponseEntity.ok(eventService.deleteEvent(event_id));
	}
}
