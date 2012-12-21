package com.exceedvote.model;

import java.util.Collection;
import java.util.List;

import com.exceedvote.entity.Ballot;
import com.exceedvote.entity.Project;
/**
 * RankStategy for Ranking.
 * @author Kunat Pipatanakul
 *
 */
public interface RankStategy {
	/**
	 * computeRank
	 * @param ballots all ballots.
	 * @param projects all projects.
	 * @return information that use for displaying.
	 */
	public Collection<Object[]> computeRank(List<Ballot> ballots,Project[] projects);
}
