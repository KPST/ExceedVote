package com.exceedvote.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.exceedvote.jpa.Role;
import com.exceedvote.jpa.User;

public class RoleJpaDao implements IRoleDao{
	EntityManager em;
	public RoleJpaDao(EntityManager em) {
		this.em = em;
	}
	@Override
	public void save(Role role) {
		EntityTransaction tx = em.getTransaction(); 
	    tx.begin();
	    em.persist(role);
	    tx.commit();
		
	}

	@Override
	public Role[] findAll() {
		Query q = em.createQuery("SELECT r from Role r");
		List te = q.getResultList();
		Role[] a = new Role[te.size()];
		te.toArray(a);
		return a;
	}

	@Override
	public Role findRole(String name) {
		Query q = em.createQuery("SELECT a from Role a where a.name = :name");
		q.setParameter("name", name);
		try{
		return (Role) q.getResultList().get(0);
		}catch (Exception e) {
			return null;
		}
	}
	
}
