package com.exceedvote.DAO.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.exceedvote.DAO.IRoleDao;
import com.exceedvote.entity.Role;
/**
 * JpaRoleDAO is the DAO class that do all action about Role in type of JPA.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 */
public class JpaRoleDao implements IRoleDao{
	EntityManager em;
	/**
	 * Constructor
	 * @param em EntityManager
	 */
	public JpaRoleDao(EntityManager em) {
		this.em = em;
	}
	@Override
	public void save(Role role) {
		EntityTransaction tx = em.getTransaction(); 
	    tx.begin();
	    em.persist(role);
	    tx.commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Role[] findAll() {
		Query q = em.createQuery("SELECT r from Role r");
		List<Role> te = q.getResultList();
		Role[] a = new Role[te.size()];
		te.toArray(a);
		return a;
	}

	@Override
	public Role findRole(int id) {
		Query q = em.createQuery("SELECT a from Role a where a.id = :id");
		q.setParameter("id", id);
		try{
		return (Role) q.getSingleResult();
		}catch (Exception e) {
			return null;
		}
	}
	@Override
	public void delete(int id) {
		EntityTransaction tx = em.getTransaction( ); 
		Query q = em.createQuery("SELECT b FROM Role b WHERE b.id = :id");
		q.setParameter("id", id); 
		Role b = (Role) q.getSingleResult();
		tx = em.getTransaction( ); 
		tx.begin(); 
		em.remove(b); 
		tx.commit(); 
	}
	@Override
	public Role[] findNormalRole() {
		Query q = em.createQuery("SELECT b FROM Role b WHERE b.ballotMultiply != :id");
		q.setParameter("id", 0);
		@SuppressWarnings("unchecked")
		List<Role> roles = q.getResultList();
		Role[] temp = new Role[roles.size()];
		roles.toArray(temp);
		return temp;
	}
	@Override
	public Role findRole(String name) {
		Query q = em.createQuery("SELECT b FROM Role b WHERE b.name = :name");
		q.setParameter("name", name);
		return (Role) q.getSingleResult();
	}
	
}
