package com.exceedvote.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the criteria database table.
 * 
 */
@Entity
@Table(name="statement")
public class Criteria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="ballot_multiply", nullable=false)
	private int ballotMultiply;

	@Column(nullable=false, length=50)
	private String description;
	/**
	 * Constructor
	 */
    public Criteria() {
    }
    /**
     * getId
     * @return id of criteria
     */
	public int getId() {
		return this.id;
	}
	/**
	 * setId
	 * @param id id of criteria
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * getBallotMultiply of this criteria.
	 * @return
	 */
	public int getBallotMultiply() {
		return this.ballotMultiply;
	}
	/**
	 * setBallotMultyply
	 * @param ballotMultiply ballotMultiply of this criteria.
	 */
	public void setBallotMultiply(int ballotMultiply) {
		this.ballotMultiply = ballotMultiply;
	}
	/**
	 * getDescription
	 * @return description of the criteria
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * setDescription
	 * @param description of the criteria.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}