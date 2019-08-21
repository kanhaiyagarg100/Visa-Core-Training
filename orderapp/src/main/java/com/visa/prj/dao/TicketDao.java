package com.visa.prj.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Repository
public class TicketDao {
	@PersistenceContext
	private EntityManager em;
	
	public void addTicket(Ticket t) {
		em.persist(t);
	}
	public void addEmployee(Employee e) {
		em.persist(e);
	}
	
}
