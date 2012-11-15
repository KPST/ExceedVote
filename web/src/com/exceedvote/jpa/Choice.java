package com.exceedvote.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the choice database table.
 * 
 */
@Entity
public class Choice implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private String name;
	private String img;
    public Choice() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getImg(){
		return this.img;
	}
	public void setImg(String img){
		this.img = img;
	}
}