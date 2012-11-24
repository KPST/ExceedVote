package com.exceedvote.core;

import java.util.ArrayList;

/**
 * ChoiceList is a group of list.
 * 
 * @author Kunat Pipatanakul
 * @version 2012.10.23
 * 
 */
public class ChoiceList {
	ArrayList<Choice> choices = new ArrayList<Choice>();
	DatebaseManager dm;

	public ChoiceList(DatebaseManager dm) {
		// TODO Auto-generated constructor stub
		this.dm = dm;
	}

	/**
	 * getList form database
	 */
	public void getChoiceFromDatabase() {
		ArrayList<Object[]> o = dm.getListFromDatabase(DatebaseManager.CHOICE);
		for (int i = 0; i < o.size(); i++) {
			addChoice((String) o.get(i)[0], (Integer) o.get(i)[1],
					(String) o.get(i)[2]);
		}
	}

	/**
	 * create choice and addChoice to List<Choice>
	 * 
	 * @param des
	 *            Description of choice
	 * @param id
	 *            id of choice
	 * @param name
	 *            name of choice
	 */
	public void addChoice(String des, int id, String name) {
		Choice st = new Choice();
		st.setDescription(des);
		st.setId(id);
		st.setName(name);
		choices.add(st);
	}

	/**
	 * getAll choice in the List
	 * 
	 * @return Choice[] that in the list.
	 */
	public Choice[] getAllChoices() {
		Choice[] state = new Choice[choices.size()];
		for (int i = 0; i < choices.size(); i++) {
			state[i] = choices.get(i);
		}
		return state;
	}
}
