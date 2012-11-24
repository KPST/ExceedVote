package com.exceedvote.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.exceedvote.jpa.Choice;

public class ChoiceJpaDao implements IChoiceDao{
	EntityManager em;
	public ChoiceJpaDao(EntityManager em) {
		this.em = em;
	}
	@SuppressWarnings("unchecked")
	public Choice[] getChoice(){
		Query q = em.createQuery("SELECT c from Choice c");
		@SuppressWarnings("rawtypes")
		List temp = q.getResultList();
		Choice[] g = new Choice[temp.size()];
		temp.toArray(g);
		return g;
	}
	public void saveChoice(Choice c){
		EntityTransaction tx = em.getTransaction(); 
	    tx.begin();
	    em.persist(c);
	    tx.commit();
	}
	public void deleteChoice(int id){
		EntityTransaction tx = em.getTransaction( ); 
		Query q = em.createQuery("SELECT c FROM Choice c WHERE c.id = :id");
		q.setParameter("id", id); 
		Choice b = (Choice) q.getSingleResult();
		tx = em.getTransaction( ); 
		tx.begin(); 
		em.remove(b); 
		tx.commit(); 
	}
}
