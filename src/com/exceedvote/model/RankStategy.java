package com.exceedvote.model;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Choice;

public interface RankStategy {
	public Collection<Object[]> computeRank(List<Ballot> ballots,Choice[] choices);
}
