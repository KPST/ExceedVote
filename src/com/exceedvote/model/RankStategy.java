package com.exceedvote.model;

import java.util.Collection;
import java.util.List;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Choice;
/**
 * RankStategy for Ranking.
 * @author Kunat Pipatanakul
 *
 */
public interface RankStategy {
	/**
	 * computeRank
	 * @param ballots all ballots.
	 * @param choices all choices.
	 * @return information that use for displaying.
	 */
	public Collection<Object[]> computeRank(List<Ballot> ballots,Choice[] choices);
}
