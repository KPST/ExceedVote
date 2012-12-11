package com.exceedvote.model;

import java.util.List;
import java.util.Map;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Choice;

public interface RankStategy {
	public Map<Choice, Integer> computeRank(List<Ballot> ballots,Choice[] choices);
}
