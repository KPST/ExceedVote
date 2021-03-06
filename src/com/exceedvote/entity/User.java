package com.exceedvote.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * @author Kunat Pipatanakul
 * @version 2012.12.20
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

	/**
	 * Constructor
	 */
	public User() {
	}
	/**
	 * getId
	 * @return id
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * setId
	 * @param id id of user.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getPass
	 * @return pass password
	 */
	public String getPass() {
		return this.pass;
	}
	/**
	 * setPass
	 * @param pass password
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**
	 * getUser
	 * @return user username
	 */
	public String getUser() {
		return this.user;
	}

	/**
	 * setUser
	 * @param user username
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * getRoles
	 * @return all of Role this User are in.
	 */
	public List<Role> getRoles() {
		return this.roles;
	}
	/**
	 * setRole
	 * @param roles List<Role> that user are.
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	/**
	 * hasRoles
	 * @param name name of Role
	 * @return true if user contain this role,false if not.
	 */
	public boolean hasRoles(String name){
		for(int i = 0 ; i < roles.size() ; i++){
			if(roles.get(i).getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}
	/**
	 * getBallot
	 * @return all ballot_multiply that user have on the role.
	 */
	public float getBallot(){
		float count = 0;
		for(int i = 0 ; i < roles.size() ;i++){
			count+=roles.get(i).getBallotMultiply();
		}
		return count;
	}
}