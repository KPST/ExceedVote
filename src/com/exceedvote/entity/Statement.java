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
	/**
	 * Constructor
	 */
    public Statement() {
    }
    /**
     * getId
     * @return id of statement
     */
	public int getId() {
		return this.id;
	}
	/**
	 * setId
	 * @param id id of statement
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * getBallotMultiply of this statement.
	 * @return
	 */
	public int getBallotMultiply() {
		return this.ballotMultiply;
	}
	/**
	 * setBallotMultyply
	 * @param ballotMultiply ballotMultiply of this statement.
	 */
	public void setBallotMultiply(int ballotMultiply) {
		this.ballotMultiply = ballotMultiply;
	}
	/**
	 * getDescription
	 * @return description of the statement
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * setDescription
	 * @param description of the statement.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}