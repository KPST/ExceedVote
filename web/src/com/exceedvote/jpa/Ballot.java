package com.exceedvote.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ballot database table.
 * 
 */
@Entity
public class Ballot implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int choice;
	private int questionid;
	private int user;

    public Ballot() {
    }
    public Ballot(int user,int question,int choice){
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


	public int getChoice() {
		return this.choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}


	public int getQuestionid() {
		return this.questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}


	public int getUser() {
		return this.user;
	}

	public void setUser(int user) {
		this.user = user;
	}

}