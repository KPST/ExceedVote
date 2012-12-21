package com.exceedvote.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Project;

/**
 * Rank strategy that include the score.
 * @author Kunat Pipatanakul
 * @version 2012.11.15
 */
public class RankScore implements RankStategy{
	
	/**
	 * Constructor
	 */
	public RankScore() {
	
	}

	@Override
	public Collection<Object[]> computeRank(List<Ballot> ballots,Project[] projects) {
		Map<Project, Integer> map = new HashMap<Project, Integer>();
		for(int i = 0 ; i < projects.length ; i++){
			map.put(projects[i], 0);
		}
		for(int i = 0 ; i < ballots.size() ; i++){
			for(int j = 0 ; j < projects.length ;j++){
				if(ballots.get(i).getProject()==projects[j]){
					int oldscore = map.get(projects[j]);
					map.put(projects[j], oldscore+1);
				}
			}
		}
		List<Object[]> cols = new ArrayList<Object[]>();
		for(int i = 0 ; i < projects.length ; i++){
			Object[] ob = new Object[2];
			ob[0] = projects[i];
			ob[1] = map.get(projects[i]);
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
		return cols;
	}
	
}
