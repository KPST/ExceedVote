package com.exceedvote.DAO.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.exceedvote.DAO.IProjectDao;
import com.exceedvote.entity.Project;

/**
 * JpaChoiceDAO is the DAO that do all the Choice action in type of JPA.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 */
public class JpaProjectDao implements IProjectDao{
	EntityManager em;
	/**
	 * Constructor
	 * @param em EntityManager
	 */
	public JpaProjectDao(EntityManager em) {
		this.em = em;
	}
	@SuppressWarnings("unchecked")
	public Project[] getProject(){
		Query q = em.createQuery("SELECT c from Project c");
		@SuppressWarnings("rawtypes")
		List temp = q.getResultList();
		Project[] g = new Project[temp.size()];
		temp.toArray(g);
		return g;
	}
	public void saveProject(Project c){
		EntityTransaction tx = em.getTransaction(); 
	    tx.begin();
	    em.persist(c);
	    tx.commit();
	}
	public void deleteProject(int id){
		EntityTransaction tx = em.getTransaction( ); 
		Query q = em.createQuery("SELECT c FROM Project c WHERE c.id = :id");
		q.setParameter("id", id); 
		Project b = (Project) q.getSingleResult();
		tx = em.getTransaction( ); 
		tx.begin(); 
		em.remove(b); 
		tx.commit(); 
	}
}
