package com.exceedvote.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.exceedvote.jpa.Ballot;

public class BallotJpaDAO implements IBallotDao{

	private EntityManager em;

	public BallotJpaDAO(EntityManager em) {
	this.em = em;
	}
	@Override
	public Ballot findBallot(int id) {
		Query q = em.createQuery("SELECT b from Ballot b where b.id = :id");
		q.setParameter("id", id );
		try{
		return (Ballot) q.getSingleResult();
		}catch (Exception e) {
			return null;
			}
	}
	@SuppressWarnings("unchecked")
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

}
