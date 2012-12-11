package com.exceedvote.model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Choice;

/**
 * Admin class contain Rank logic
 * @author Kunat Pipatanakul
 * @version 2012.11.15
 */
public class Rank implements RankStategy{
	public Rank() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<Choice,Integer> computeRank(List<Ballot> ballots,Choice[] choices) {
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
		return map;
	}
	
}
