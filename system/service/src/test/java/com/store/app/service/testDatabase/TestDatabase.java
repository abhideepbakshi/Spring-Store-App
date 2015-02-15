package com.store.app.service.testDatabase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.store.app.model.entity.Item;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")

public class TestDatabase {

	@PersistenceContext
	private EntityManager manager;
	
	@Test
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void testDatabase() {
	
		Item find = manager.find(Item.class, 1);
		System.out.println(find.getItemName());
	}
	
}
