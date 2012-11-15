package com.exceedvote.core;


import java.util.List;

import javax.persistence.*;


import com.exceedvote.jpa.Auth;
import com.exceedvote.jpa.Ballot;
import com.exceedvote.jpa.Choice;
import com.exceedvote.jpa.Statement;
/**
 * JpaDAO
 * @author Kunat Pipatanakul
 * @version 2012.11.14
 */
public class JpaDAO implements ExceedDAO{
	EntityManager em;
	public static int FLAG_USER = 1;
	public static int FLAG_CHOICE = 2;
	public JpaDAO() {
			EntityManagerFactory fac = Persistence.createEntityManagerFactory("ExceedVote");
			em = fac.createEntityManager();
		}
		public Statement[] getStatement(){
			Query q = em.createQuery("SELECT s from Statement s");
			List temp =q.getResultList();
			Statement[] g = new Statement[temp.size()];
			temp.toArray(g);
			return g;
		}
		public Choice[] getChoice(){
			Query q = em.createQuery("SELECT c from Choice c");
			List temp = q.getResultList();
			Choice[] g = new Choice[temp.size()];
			temp.toArray(g);
			return g;
		}
		public Ballot findBallot(int id){
			Query q = em.createQuery("SELECT b from Ballot b where b.id = :id");
			q.setParameter("id", id );
			try{
			return (Ballot) q.getSingleResult();
			}catch (Exception e) {
				return null;
				}
		}
		public List<Ballot> findBallots(int id,int question,int flag){
			Query q;
			if(flag == FLAG_USER)
			q = em.createQuery("SELECT b from Ballot b where b.user = :id and b.questionid = :question");
			else
			q = em.createQuery("SELECT b from Ballot b where b.questionid = :question and b.choice = :id");
			q.setParameter("id", id);
			q.setParameter("question", question);
			return q.getResultList();
		}
		
		public void deleteBallot(int id){
			EntityTransaction tx = em.getTransaction( ); 
			Query q = em.createQuery("SELECT b FROM Ballot b WHERE b.id = :id");
			q.setParameter("id", id); 
			Ballot b = (Ballot) q.getSingleResult();
			tx = em.getTransaction( ); 
			tx.begin(); 
			em.remove(b); 
			tx.commit(); 
		}
		public void saveBallot(Ballot b){
			EntityTransaction tx = em.getTransaction(); 
		    tx.begin();
		    em.persist(b);
		    tx.commit();
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
		public Auth[] getAllUser() {
			Query q = em.createQuery("SELECT a from Auth a");
			List te = q.getResultList();
			Auth[] a = new Auth[te.size()];
			te.toArray(a);
			return a;
		}
		
}
