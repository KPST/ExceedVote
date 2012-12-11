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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBallotMultiply() {
		return this.ballotMultiply;
	}

	public void setBallotMultiply(float ballotMultiply) {
		this.ballotMultiply = ballotMultiply;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}