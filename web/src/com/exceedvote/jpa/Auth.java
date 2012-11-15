package com.exceedvote.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the auth database table.
 * 
 */
@Entity
public class Auth implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int ballot;
	private String pass;
	private int priority;
	private String user;

    public Auth() {
    	
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBallot(){
		return ballot;
	}
	public void setBallot(int ballot){
		this.ballot = ballot;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}


	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}