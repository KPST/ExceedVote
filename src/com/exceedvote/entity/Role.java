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
	/**
	 * Constructor
	 */
    public Role() {
    }
    /**
     * getId
     * @return id of the role
     */
	public int getId() {
		return this.id;
	}
	/**
	 * setId
	 * @param id id of the role
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * getBallotMultiply 
	 * @return float ballotMultiply of this role.
	 */
	public float getBallotMultiply() {
		return this.ballotMultiply;
	}
	/**
	 * setBallotMultiply
	 * @param ballotMultiply ballotMultiply of this role.
	 */
	public void setBallotMultiply(float ballotMultiply) {
		this.ballotMultiply = ballotMultiply;
	}
	/**
	 * getName
	 * @return name of the role.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * setName
	 * @param name name of the role.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getUsers
	 * @return getAllUser in this Role
	 */
	public List<User> getUsers() {
		return this.users;
	}
	/**
	 * setUsers
	 * @param users List<User> that are in this role.
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}