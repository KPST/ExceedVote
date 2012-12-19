package com.exceedvote.DAO.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.exceedvote.DAO.IUserDao;
import com.exceedvote.entity.User;

/**
 * JpaUserDAO is the DAO that do all the User action in type of JPA.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 */
public class JpaUserDao implements IUserDao{
	EntityManager em;
	/**
	 * Constructor
	 * @param em EntityManager
	 */
	public JpaUserDao(EntityManager em) {
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
	@Override
	public void deleteAll() {
		EntityTransaction tx = em.getTransaction( ); 
		Query q = em.createQuery("SELECT a from User a");
		@SuppressWarnings("unchecked")
		List<User> users = q.getResultList();
		tx.begin();
		for(int i = 0 ; i < users.size() ; i++){
			em.remove(users.get(i));
		}
		em.createNativeQuery("ALTER TABLE User AUTO_INCREMENT=1").executeUpdate();
		em.createNativeQuery("ALTER TABLE User_type AUTO_INCREMENT=1").executeUpdate();
		tx.commit();
	}
}
