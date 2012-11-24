package com.exceedvote.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.exceedvote.jpa.Auth;

public class UserJpaDao implements IUserDao{
	EntityManager em;
	public UserJpaDao(EntityManager em) {
	this.em = em;
	}
	public Auth findUser(String user,String pass){
		Query q = em.createQuery("SELECT a from Auth a where a.user = :user and a.pass = :pass");
		q.setParameter("user", user);
		q.setParameter("pass", pass);
		try{
		return (Auth) q.getResultList().get(0);
		}catch (Exception e) {
			return null;
		}
	}
	public Auth findUser(String user){
		Query q = em.createQuery("SELECT a from Auth a where a.user = :user");
		q.setParameter("user", user);
		try{
		return (Auth) q.getResultList().get(0);
		}catch (Exception e) {
			return null;
		}
	}
	public void saveUser(Auth a){
		EntityTransaction tx = em.getTransaction(); 
	    tx.begin();
	    em.persist(a);
	    tx.commit();
	}
	public void deleteUser(int id){
		EntityTransaction tx = em.getTransaction( ); 
		Query q = em.createQuery("SELECT b FROM Auth b WHERE b.id = :id");
		q.setParameter("id", id); 
		Auth b = (Auth) q.getSingleResult();
		tx = em.getTransaction( ); 
		tx.begin(); 
		em.remove(b); 
		tx.commit(); 
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Auth[] getAllUser() {
		Query q = em.createQuery("SELECT a from Auth a");
		List te = q.getResultList();
		Auth[] a = new Auth[te.size()];
		te.toArray(a);
		return a;
	}
}
