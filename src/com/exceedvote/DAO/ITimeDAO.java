package com.exceedvote.DAO;

import java.util.List;

import com.exceedvote.entity.Time;

/**
 * ITimeDAO is a Interface the contain all method Time DAO have to implements.
 * @author Kunat Pipatanakul
 * @version 2012.12.10
 */
public interface ITimeDAO {
	/**
	 * getTimer from database
	 * @return Time object.
	 */
	public List<Time> getTimer();
	/**
	 * setEndTimer
	 * @param time Time object
	 */
	public void setTimer(Time time);
	/**
	 * deleteTime from database
	 * @param id id of time object.=.
	 */
	public void delete(int id);
}
