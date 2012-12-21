package com.exceedvote.DAO.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.exceedvote.DAO.IBallotDao;
import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Project;
import com.exceedvote.entity.Criteria;
import com.exceedvote.entity.User;

/**
 * JpaBallotDAO is the DAO that do the Ballot action in type of JPA.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 */
public class JpaBallotDAO implements IBallotDao{

	private EntityManager em;

	/**
	 * Constructor
	 * @param em EntityManager
	 */
	public JpaBallotDAO(EntityManager em) {
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
	public List<Ballot> findBallots(User user,Criteria question){
		Query q;
		q = em.createQuery("SELECT b from Ballot b where b.user = :id and b.questionid = :question");
		q.setParameter("id", user);
		q.setParameter("question", question);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Ballot> findBallots(Project id,Criteria question){
		Query q;
		q = em.createQuery("SELECT b from Ballot b where b.questionid = :question and b.choice = :id");
		q.setParameter("id", id);
		q.setParameter("question", question);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Ballot> findBallotsByCriteria(Criteria question){
		Query q = em.createQuery("SELECT b from Ballot b WHERE b.questionid = :question");
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
	@SuppressWarnings("unchecked")
	public List<Ballot> findAllBallot() {
		Query q = em.createQuery("SELECT b FROM Ballot b");
		return q.getResultList();
	}

}
