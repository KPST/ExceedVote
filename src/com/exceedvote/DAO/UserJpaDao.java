package com.exceedvote.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.exceedvote.jpa.User;

public class UserJpaDao implements IUserDao{
	EntityManager em;
	public UserJpaDao(EntityManager em) {
	this.em = em;
	}
	public User findUser(String user,String pass){
		Query q = em.createQuery("SELECT a from User a where a.user = :user and a.pass = :pass");
		q.setParameter("user", user);
		q.setParameter("pass", pass);
		try{
		return (User) q.getResultList().get(0);
		}catch (Exception e) {
			return null;
		}
	}
	public User findUser(String user){
		Query q = em.createQuery("SELECT a from User a where a.user = :user");
		q.setParameter("user", user);
		try{
		return (User) q.getResultList().get(0);
		}catch (Exception e) {
			return null;
		}
	}
	public void saveUser(User a){
		EntityTransaction tx = em.getTransaction(); 
	    tx.begin();
	    em.persist(a);
	    tx.commit();
	}
	public void deleteUser(int id){
		EntityTransaction tx = em.getTransaction( ); 
		Query q = em.createQuery("SELECT b FROM User b WHERE b.id = :id");
		q.setParameter("id", id); 
		User b = (User) q.getSingleResult();
		tx = em.getTransaction( ); 
		tx.begin(); 
		em.remove(b); 
		tx.commit(); 
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public User[] getAllUser() {
		Query q = em.createQuery("SELECT a from User a");
		List te = q.getResultList();
		User[] a = new User[te.size()];
		te.toArray(a);
		return a;
	}
}
