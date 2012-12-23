package com.exceedvote.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the time database table.
 * @author Kunat Pipatanakul
 * @version 2012.12.20
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

    /**
     * Constructor
     */
    public Time() {
    }

	/**
	 * getId
	 * @return id of time.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * setId
	 * @param id id of time.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getDay day is a day of the month
	 * @return day of time.
	 */
	public int getDay() {
		return this.day;
	}

	/**
	 * setDay day is a day of the month
	 * @param day day of time
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * getHour hour is a 24 hour format
	 * @return hour of time
	 */
	public int getHour() {
		return this.hour;
	}

	/**
	 * setHour hour is a 24 hour format
	 * @param hour hour of time
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * getMin is a get minute
	 * @return minute of time
	 */
	public int getMin() {
		return this.min;
	}

	/**
	 * setMin set a minute
	 * @param min minute of time
	 */
	public void setMin(int min) {
		this.min = min;
	}
	
	/**
	 * getMonth start at month 1 = Jan
	 * @return month
	 */
	public int getMonth() {
		return this.month;
	}

	/**
	 * setMonth start at month 1 = Jan
	 * @param month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * getTimezone 
	 * @return Timezone of time
	 */
	public int getTimezone() {
		return this.timezone;
	}

	/**
	 * setTimezone Bangkok is +7
	 * @param timezone Timezone of time
	 */
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	/**
	 * getYear year in AD.
	 * @return year of the time
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * setYear year in AD.
	 * @param year of the time
	 */
	public void setYear(int year) {
		this.year = year;
	}

}