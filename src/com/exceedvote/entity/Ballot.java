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
    public Ballot(User user,Statement question,Choice choice){
    	this.choice= choice;
    	this.questionid = question;
    	this.user = user;
    }

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Choice getChoice() {
		return this.choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}


	public Statement getQuestionid() {
		return this.questionid;
	}

	public void setQuestionid(Statement questionid) {
		this.questionid = questionid;
	}


	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}