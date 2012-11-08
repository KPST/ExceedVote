package Core;


import java.util.List;

import javax.persistence.*;


import com.exceedvote.jpa.Auth;
import com.exceedvote.jpa.Ballot;
import com.exceedvote.jpa.Choice;
import com.exceedvote.jpa.Statement;

public class BloatDAO {
	EntityManager em;
		public BloatDAO() {
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
			return (Ballot) q.getSingleResult();
		}
		public List<Ballot> findBallots(int userid,int question){
			Query q = em.createQuery("SELECT b from Ballot b where b.user = :id and b.questionid = :question");
			q.setParameter("id", userid);
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
			return (Auth) q.getSingleResult();
		}
		
}
