package com.exceedvote;

import java.util.ArrayList;



public class ChoiceList {
	ArrayList<Choice> choices = new ArrayList<Choice>();
	DatebaseManager dm;
	public ChoiceList(DatebaseManager dm) {
		// TODO Auto-generated constructor stub
	this.dm = dm;
	}
	public void getChoiceFromDatabase(){
		ArrayList<Object[]> o = dm.getListFromDatabase(DatebaseManager.CHOICE);
		for(int i = 0 ; i < o.size(); i++){
			addChoice((String)o.get(i)[0], (Integer)o.get(i)[1] , (String) o.get(i)[2]);
		}
	}
	public void addChoice(String des,int id,String name){
		Choice st = new Choice();
		st.setDescription(des);
		st.setId(id);
		st.setName(name);
		choices.add(st); 
	}
	//return all statement
	public Choice[] getAllChoices(){
		Choice[] state = new Choice[choices.size()];
		for(int i = 0 ; i < choices.size() ; i ++){
			state[i] = choices.get(i);
		}
		return state;
	}
}
