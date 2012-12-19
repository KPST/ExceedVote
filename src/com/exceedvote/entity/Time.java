package com.exceedvote.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the time database table.
 * 
 */
@Entity
@Table(name="time")
public class Time implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int day;

	@Column(nullable=false)
	private int hour;

	@Column(nullable=false)
	private int min;

	@Column(nullable=false)
	private int month;

	@Column(nullable=false)
	private int timezone;

	@Column(nullable=false)
	private int year;

    public Time() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDay() {
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return this.hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return this.min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getTimezone() {
		return this.timezone;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}