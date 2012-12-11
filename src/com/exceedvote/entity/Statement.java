package com.exceedvote.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the statement database table.
 * 
 */
@Entity
@Table(name="statement")
public class Statement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="ballot_multiply", nullable=false)
	private int ballotMultiply;

	@Column(nullable=false, length=50)
	private String description;

    public Statement() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBallotMultiply() {
		return this.ballotMultiply;
	}

	public void setBallotMultiply(int ballotMultiply) {
		this.ballotMultiply = ballotMultiply;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}