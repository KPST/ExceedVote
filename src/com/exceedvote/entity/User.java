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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Role> getRoles() {
		return this.roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public boolean hasRoles(String name){
		for(int i = 0 ; i < roles.size() ; i++){
			if(roles.get(i).getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}
	public float getBallot(){
		float count = 0;
		for(int i = 0 ; i < roles.size() ;i++){
			count+=roles.get(i).getBallotMultiply();
		}
		return count;
	}
}