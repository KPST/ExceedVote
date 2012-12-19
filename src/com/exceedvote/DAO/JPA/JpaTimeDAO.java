package com.exceedvote.DAO.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.exceedvote.DAO.ITimeDAO;
import com.exceedvote.entity.Time;

/**
 * JpaTimeDAO is the DAO the do all action about Time in type of JPA.
 * @author Kunat Pipatanakul
 * @version 2012.12.19
 */
public class JpaTimeDAO implements ITimeDAO{
	private EntityManager em;
	/**
	 * Constructor
	 */
	public JpaTimeDAO(EntityManager em){
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Time> getTimer() {
		Query q = em.createQuery("SELECT t from Time t order by t.id desc");
		return q.getResultList();
	}

	@Override
	public void setTimer(Time time) {
		EntityTransaction tx = em.getTransaction(); 
		tx.begin();
		em.persist(time);
		tx.commit();
	}

	@Override
	public void delete(int id) {
		EntityTransaction tx = em.getTransaction( ); 
		Query q = em.createQuery("SELECT t FROM Time t WHERE t.id = :id");
		q.setParameter("id", id); 
		Time b = (Time) q.getSingleResult();
		tx.begin(); 
		em.remove(b); 
		tx.commit();
	}
}
