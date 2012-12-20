package com.exceedvote.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ballot database table.
 * @author Kunat Pipatanakul
 * @version 2012.11.11
 */
@Entity
public class Ballot implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="choice")
	private Choice choice;
	@ManyToOne
	@JoinColumn(name="questionid")
	private Statement questionid;
	@ManyToOne
	@JoinColumn(name="user")
	private User user;

    public Ballot() {
    }
    /**
	 * Initialize User, Statement, Choice
	 */
    public Ballot(User user,Statement question,Choice choice){
    	this.choice= choice;
    	this.questionid = question;
    	this.user = user;
    }

    /**
     * This is a getId method that returns id from entity
	 * @return id
	 */
	public int getId() {
		return this.id;
	}
	/**
     * This is a setId method that sets id for entity
     * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
     * This is a getChoice method that returns choice from entity
	 * @return choice
	 */
	public Choice getChoice() {
		return this.choice;
	}
	/**
     * This is a setChoice method that sets choice to entity
	 * @param choice
	 */
	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	/**
     * This is a getQuestionid method that returns question from entity
	 * @return questionid
	 */
	public Statement getQuestionid() {
		return this.questionid;
	}

	/**
     * This is a setQuestionid method that sets question to entity
	 * @oaram questionid
	 */
	public void setQuestionid(Statement questionid) {
		this.questionid = questionid;
	}
	
	/**
     * This is a getUser method that returns id from entity
	 * @return user
	 */
	public User getUser() {
		return this.user;
	}

	/**
     * This is a setUser method that sets user from entity
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

}