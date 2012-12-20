package com.exceedvote.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="ballot_multiply", nullable=false)
	private float ballotMultiply;

	@Column(nullable=false, length=255)
	private String name;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="roles",cascade=CascadeType.PERSIST)
	private List<User> users;

    public Role() {
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
     * This is a getBallotMultiply method that returns ballotMultiply from entity
	 * @return ballotMultiply
	 */
	public float getBallotMultiply() {
		return this.ballotMultiply;
	}

	/**
     * This is a setBallotMultiply method that sets ballotMultiply to entity
	 * @param ballotMultiply
	 */
	public void setBallotMultiply(float ballotMultiply) {
		this.ballotMultiply = ballotMultiply;
	}
	
	/**
     * This is a getName method that returns name from entity
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
     * This is a setName method that sets name to entity
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
     * This is a getUsers method that returns users from entity
	 * @return users
	 */
	public List<User> getUsers() {
		return this.users;
	}

	/**
     * This is a setUsers method that sets users to entity
	 * @param users
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}