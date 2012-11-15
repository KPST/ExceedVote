package com.exceedvote.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the statement database table.
 * 
 */
@Entity
public class Statement implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;

    public Statement() {
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

}