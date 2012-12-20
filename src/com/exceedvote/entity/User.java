package com.exceedvote.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;
	
	@Column(nullable=false, length=255)
	private String pass;

	@Column(nullable=false, length=255)
	private String user;

	//bi-directional many-to-many association to Role
    @ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
		name="user_type"
		, joinColumns={
			@JoinColumn(name="user", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="role", nullable=false)
			}
		)
	private List<Role> roles;

    public User() {
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
     * This is a getPass method that returns password from entity
	 * @return pass
	 */
	public String getPass() {
		return this.pass;
	}

	/**
     * This is a setPass method that sets password to entity
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
     * This is a getUser method that returns user from entity
	 * @return user
	 */
	public String getUser() {
		return this.user;
	}

	/**
     * This is a setUser method that sets user to entity
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
     * This is a getRoles method that returns roles from entity
	 * @return roles
	 */
	public List<Role> getRoles() {
		return this.roles;
	}
	/**
     * This is a setRoles method that returns id from entity
	 * @param id
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	/**
     * This is a hasRole method that returns true or false by condition from entity
     * @param name
	 * @return ture if matching,
	 * 		   false
	 */
	public boolean hasRoles(String name){
		for(int i = 0 ; i < roles.size() ; i++){
			if(roles.get(i).getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}
	/**
     * This is a getBallot method that returns count of vote from entity
	 * @return count
	 */
	public float getBallot(){
		float count = 0;
		for(int i = 0 ; i < roles.size() ;i++){
			count+=roles.get(i).getBallotMultiply();
		}
		return count;
	}
}