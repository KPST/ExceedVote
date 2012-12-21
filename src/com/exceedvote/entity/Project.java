package com.exceedvote.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the choice database table.
 * @author Kunat Pipatanakul
 * @version 2012.11.11
 */
@Entity
@Table(name="choice")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private String name;
	private String img;
    /**
     * Constructor
     */
    public Project() {
    }


	/**
	 * getId
	 * @return id of choice
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	/**
	 * setId
	 * @param id id of choice
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * getDescription
	 * @return description of the choice
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * setDescription
	 * @param description of the choice
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * getName
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return
	 */
	public String getImg(){
		return this.img;
	}
	/**
	 * @param img
	 */
	public void setImg(String img){
		this.img = img;
	}
}