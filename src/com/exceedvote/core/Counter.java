package com.exceedvote.core;

import java.util.ArrayList;

public class Counter {
	DatebaseManager dm;
	int[][] choicevalue;
	int statementsize;
	int choicesize;
	public Counter(DatebaseManager dm) {
		this.dm = dm;
		statementsize = dm.getListFromDatabase(DatebaseManager.STATEMENT).size();
    	choicesize = dm.getListFromDatabase(DatebaseManager.CHOICE).size();
    	choicevalue = new int[statementsize][choicesize];
	}
	public String getResult(){
		ArrayList<Object[]> t =  dm.getListFromDatabase(DatebaseManager.BALLOT);
		for(int i = 0 ; i < t.size() ; i++){
			choicevalue[((Integer) t.get(i)[0])-1][((Integer) t.get(i)[1])-1]+=1;
		}
		int[] nummax = new int[statementsize];
		for(int i = 0 ; i < statementsize ; i++){
			int max = 0;
			for(int j = 0 ; j < choicesize ; j++){
				if(choicevalue[i][j] > max){
					max = choicevalue[i][j];
					nummax[i] = j;
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int k = 0 ; k < nummax.length ; k++){
			sb.append("Question : "+(k+1)+" : ");
			sb.append((nummax[k]+1)+" With : "+choicevalue[k][nummax[k]]+" Vote.");
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
}
