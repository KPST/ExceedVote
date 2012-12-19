package com.exceedvote.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Choice;
/**
 * Rank strategy that not include score.
 * @author Kunat Pipatanakul
 *
 */
public class Rank implements RankStategy{

	@Override
	public Collection<Object[]> computeRank(List<Ballot> ballots,Choice[] choices) {
		Map<Choice, Integer> map = new HashMap<Choice, Integer>();
		for(int i = 0 ; i < choices.length ; i++){
			map.put(choices[i], 0);
		}
		for(int i = 0 ; i < ballots.size() ; i++){
			for(int j = 0 ; j < choices.length ;j++){
				if(ballots.get(i).getChoice()==choices[j]){
					int oldscore = map.get(choices[j]);
					map.put(choices[j], oldscore+1);
				}
			}
		}
		List<Object[]> cols = new ArrayList<Object[]>();
		for(int i = 0 ; i < choices.length ; i++){
			Object[] ob = new Object[2];
			ob[0] = choices[i];
			ob[1] = map.get(choices[i]);
			cols.add(ob);
		}
		Collections.sort(cols, new Comparator<Object[]>(){

			@Override
			public int compare(Object[] o1, Object[] o2) {
				if((Integer)o1[1]>(Integer)o2[1]){
					return -1;
				}
				else if((Integer)o1[1]<(Integer)o2[1]){
					return 1;
				}
				else{
					return 0;
				}
			}
		});
		List<Object[]> col = new ArrayList<Object[]>();
		for(int i = 0 ; i < choices.length ; i++){
			Object[] ob = new Object[1];
			ob[0] = cols.get(i)[0];
			col.add(ob);
		}
		return col;
	}

}
