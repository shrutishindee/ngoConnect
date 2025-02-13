package com.app.service;

import java.nio.MappedByteBuffer;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customExceptions.ResourceNotFoundException;
import com.app.dao.EventDao;
import com.app.dao.ProjectDao;
import com.app.dto.EventDTO;
import com.app.pojos.Event;
import com.app.pojos.Project;

@Service
@Transactional
public class EventServiceImpl implements EventService{

	@Autowired
	private EventDao eventDao;
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ProjectDao projectDao;
	private Project project;
	@Autowired
	public EventServiceImpl(ProjectDao projectDao) {
		this.projectDao=projectDao;
	}

	@Override
	public List<EventDTO> getEvents() {
	    List<Event> events = eventDao.findAll();

	    List<EventDTO> eventDtoList = events.stream().map(event -> {
	    	EventDTO dto = modelMapper.map(event, EventDTO.class); 

	        if (event.getProject() != null) {
	            dto.setProjectId(event.getProject().getProjectId()); 
	        }

	        return dto;
	    }).collect(Collectors.toList());

	    return eventDtoList; 
	}


	@Override
	public EventDTO getEvent(Long event_id) {
		Event event = eventDao.findById(event_id).orElseThrow(()->new ResourceNotFoundException("No such event found"));
		EventDTO eventdto = modelMapper.map(event, EventDTO.class);
		if(event.getProject()!=null) {
			eventdto.setProjectId(event.getProject().getProjectId());
		}
		return eventdto;
	}

	@Override
	public String addEvent(EventDTO event) {
		
		Project project = projectDao.findById(event.getProjectId()).orElseThrow(() -> new ResourceNotFoundException("Project not fount with ID: " + event.getProjectId()));
		Event events = modelMapper.map(event, Event.class);
		events.setProject(project);
		
		Event savedEvent = eventDao.save(events);
		return "New event added";
	}

	@Override
	public String updateEvent(Long event_id, EventDTO event) {
		if(eventDao.existsById(event_id)) {
			Event events = modelMapper.map(event, Event.class);
			Project project = projectDao.findById(event.getProjectId()).orElseThrow(() -> new ResourceNotFoundException("Project not fount with ID: " + event.getProjectId()));
			events.setProject(project);
			eventDao.save(events);
			return "Event updated";
		}
		throw new ResourceNotFoundException("Event doesnt exist");
		
	}

	@Override
	public String deleteEvent(Long event_id) {
		if(eventDao.existsById(event_id)) {
			eventDao.deleteById(event_id);
			return "Deleted Event";
		}
		throw new ResourceNotFoundException("Event doesnt exist");
	}
		
}
