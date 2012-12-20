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
    
    /**
     * This is a getId method that returns id from entity
	 * @return id
	 */
	public int getId() {
		return this.id;
	}
	
	/**
     * This is a setId method that sets id to entity
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
     * This is a getBallotMultiply method that returns bollotMultiply from entity
	 * @return ballotMultiply
	 */
	public int getBallotMultiply() {
		return this.ballotMultiply;
	}

	/**
     * This is a setBallotMultiply method that sets ballotMultiply to entity
	 * @param ballotMultiply
	 */
	public void setBallotMultiply(int ballotMultiply) {
		this.ballotMultiply = ballotMultiply;
	}

	/**
     * This is a getDescription method that returns description from entity
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
     * This is a setDescription method that sets description to entity
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}