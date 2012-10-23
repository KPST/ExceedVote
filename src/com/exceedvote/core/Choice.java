package com.exceedvote.core;

/**
 * Choice that in the database
 * 
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 * 
 */
public class Choice {
	int id;
	String name;
	String description;

	/**
	 * Constructor
	 */
	public Choice() {
	}

	/**
	 * Get id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set id
	 * 
	 * @param id,id of choice
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get choice
	 * 
	 * @return choice
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set choice
	 * 
	 * @param name,name of choice
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the Description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set Description
	 * 
	 * @param description,Description of this choice
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
