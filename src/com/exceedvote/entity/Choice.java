package com.exceedvote.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the choice database table.
 * @author Kunat Pipatanakul
 * @version 2012.11.11
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

    /**
     * This is a getId method that returns id from entity
	 * @return id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
     * This is a getImg method that returns imageURL from entity
	 * @return img
	 */
	public String getImg(){
		return this.img;
	}
	
	/**
     * This is a setImg method that sets imageURL to entity
	 * @param img
	 */
	public void setImg(String img){
		this.img = img;
	}
}
