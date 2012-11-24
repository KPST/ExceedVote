package com.exceedvote.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.exceedvote.jpa.Statement;

public class StatementJpaDao implements IStatementDao{
	EntityManager em;
	public StatementJpaDao(EntityManager em) {
	this.em = em;
	}
	@SuppressWarnings("unchecked")
	public Statement[] getStatement(){
		Query q = em.createQuery("SELECT s from Statement s");
		
		@SuppressWarnings("rawtypes")
		List temp =q.getResultList();
		Statement[] g = new Statement[temp.size()];
		temp.toArray(g);
		return g;
	}
	public void saveStatement(Statement s){
		EntityTransaction tx = em.getTransaction(); 
	    tx.begin();
	    em.persist(s);
	    tx.commit();
	}
	public void deleteStatement(int id){
		EntityTransaction tx = em.getTransaction( ); 
		Query q = em.createQuery("SELECT s FROM Statement s WHERE s.id = :id");
		q.setParameter("id", id); 
		Statement b = (Statement) q.getSingleResult();
		tx = em.getTransaction( ); 
		tx.begin(); 
		em.remove(b); 
		tx.commit(); 
	}
}
