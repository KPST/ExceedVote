package com.exceedvote.DAO.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.exceedvote.DAO.ICriteriaDao;
import com.exceedvote.entity.Criteria;
/**
 * JpaStatementDAO is the DAO the do all action about Statement in type of JPA.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 */
public class JpaCriteriaDao implements ICriteriaDao{
	EntityManager em;
	/**
	 * Constructor
	 * @param em EntityManager
	 */
	public JpaCriteriaDao(EntityManager em) {
	this.em = em;
	}
	@SuppressWarnings("unchecked")
	public Criteria[] getCriteria(){
		Query q = em.createQuery("SELECT s from Criteria s");
		@SuppressWarnings("rawtypes")
		List temp =q.getResultList();
		Criteria[] g = new Criteria[temp.size()];
		temp.toArray(g);
		return g;
	}
	public void saveCriteria(Criteria s){
		EntityTransaction tx = em.getTransaction(); 
	    tx.begin();
	    em.persist(s);
	    tx.commit();
	}
	public void deleteCriteria(int id){
		EntityTransaction tx = em.getTransaction( ); 
		Query q = em.createQuery("SELECT s FROM Criteria s WHERE s.id = :id");
		q.setParameter("id", id); 
		Criteria b = (Criteria) q.getSingleResult();
		tx = em.getTransaction( ); 
		tx.begin(); 
		em.remove(b); 
		tx.commit(); 
	}
	@Override
	public Criteria getCriteriaById(int id) {
		Query q = em.createQuery("SELECT s from Criteria s WHERE s.id = :id");
		q.setParameter("id", id);
		return (Criteria) q.getSingleResult();
	}
}
