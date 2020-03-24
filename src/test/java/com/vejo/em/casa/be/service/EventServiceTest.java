package com.vejo.em.casa.be.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vejo.em.casa.be.entity.Category;
import com.vejo.em.casa.be.entity.Creator;
import com.vejo.em.casa.be.entity.Event;

@SpringBootTest()
@ExtendWith({SpringExtension.class})
@ActiveProfiles("dev")

public class EventServiceTest {

	
	
	private static final Logger log = LoggerFactory.getLogger(EventServiceTest.class);

	@Autowired
	EventService eventService;
	
	@Autowired 
	CategoryService categoryService;
	
	@Autowired
	CreatorService creatorService;
	
	
	Category c1;
	Category c2;

	Creator creator1;
	Creator creator2;
	
	
	@BeforeEach
	public void init() {
		
		c1 = new Category();
		c1.setName("c1");
		c1 = categoryService.save(c1);
		log.info("Saved category [{}] with id [{}]", c1.getName(), c1.getId());
		
		
		c2 = new Category();
		c2.setName("c2");
		c2 = categoryService.save(c2);
		log.info("Saved category [{}] with id [{}]", c2.getName(), c2.getId());
		
		
		creator1 = new Creator();
		creator1.setName("creator1");
		creator1 = creatorService.save(creator1);
		
		
		creator2 = new Creator();
		creator2.setName("creator1");
		creator2 = creatorService.save(creator2);
		
		

		
		
		Event event = new Event();
		event.setTitle("Good event");
		event.setApproved(false);
		event.setTime(LocalDateTime.of(2020, 1, 1, 1, 1));
		event.setCategory(c1);
		eventService.save(event);
		
		Event event2 = new Event();
		event2.setTitle("Very Good event");
		event2.setApproved(false);
		event2.setTime(LocalDateTime.of(2020, 3, 3, 3, 3));
		event2.setCategory(c2);
		event2.setCreator(creator1);
		eventService.save(event2);
		
		
		Event event3 = new Event();
		event3.setTitle("Very Good event");
		event3.setApproved(false);
		event3.setTime(LocalDateTime.of(2020, 3, 3, 3, 3));
		event3.setCategory(c2);
		event3.setCreator(creator2);
		eventService.save(event3);
		
	}
	
	@Test
	@Transactional
	public void save() {
		Event event = new Event();
		event.setTitle("title");
		eventService.save(event);
	}
	
	
	@Test
	@Transactional
	public void getByCategory() {
		Page<Event> res = eventService.getAllEvents(c1.getId(), null, 0, 50);
		
		log.info("Result: {}", res.getContent());
		assertEquals(1, res.getContent().size());
	}
	
	
	@Test
	@Transactional
	public void getByCategoryAndCreator() {
		Page<Event> res = eventService.getAllEvents(c2.getId(), creator2.getId(), 0, 50);
		
		log.info("Result: {}", res.getContent());
		assertEquals(1, res.getContent().size());
	}
}
