package com.exceedvote.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ballot database table.
 * @author Kunat Pipatanakul
 * @version 2012.11.11
 */
@Entity
@Table(name="ballot")
public class Ballot implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="choice")
	private Project project;
	@ManyToOne
	@JoinColumn(name="questionid")
	private Criteria questionid;
	@ManyToOne
	@JoinColumn(name="user")
	private User user;

    /**
     * Constructor
     */
    public Ballot() {
    }
    /**
     * Constructor with user question project object.
     * @param user User that vote this.
     * @param question criteria this vote are on.
     * @param project project that voter choose.
     */
    public Ballot(User user,Criteria question,Project project){
    	this.project = project;
    	this.questionid = question;
    	this.user = user;
    }

	/**
	 * getId
	 * @return id of the ballot
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * setId 
	 * @param id of the ballot
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * getproject 
	 * @return project of this ballot.
	 */
	public Project getProject() {
		return this.project;
	}

	/**
	 * setproject
	 * @param project project of this ballot
	 */
	public void setProject(Project project) {
		this.project = project;
	}


	/**
	 * getQuestionid
	 * @return criteria this ballot are in.
	 */
	public Criteria getQuestionid() {
		return this.questionid;
	}

	/**
	 * setQuestionid
	 * @param questionid criteria of this ballot.
	 */
	public void setQuestionid(Criteria questionid) {
		this.questionid = questionid;
	}


	/**
	 * getUser
	 * @return user that vote this ballot
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * setUser
	 * @param user User who vote this ballot.
	 */
	public void setUser(User user) {
		this.user = user;
	}

}