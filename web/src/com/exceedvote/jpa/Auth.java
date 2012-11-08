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
	private byte noBallot;
	private String pass;
	private int priority;
	private String user;

    public Auth() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name="no_ballot")
	public byte getNoBallot() {
		return this.noBallot;
	}

	public void setNoBallot(byte noBallot) {
		this.noBallot = noBallot;
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