package org.metatrans.apps.maze.cfg.achievements;


import org.metatrans.apps.maze.lib.R;
import org.metatrans.commons.cfg.achievements.Config_Achievement_Base;


public class Config_Achievement_ChangeColours extends Config_Achievement_Base {
	
	
	@Override
	public int getID() {
		return CFG_ACHIEVEMENT_CHANGE_COLOURS;
	}
	
	
	@Override
	public int geIDReference() {
		throw new UnsupportedOperationException();
		//return R.string.achievement_id_change_colours;
	}
	
	
	@Override
	public int getScores() {
		return R.integer.achievement_score_change_colours;
	}

	@Override
	public int getMaxCount() {
		return R.integer.achievement_maxcount_change_colours;
	}

	@Override
	public int getIncrementsCount() {
		return R.integer.achievement_increments_change_colours;
	}
	
	@Override
	public int getName() {
		return R.string.achievement_title_change_colours;
	}
	
	
	@Override
	public int getDescription() {
		return R.string.achievement_desc_change_colours;
	}
	
	
	@Override
	public int getIconResID() {
		return R.drawable.ic_gift_change_colors;
	}


	@Override
	public boolean isHidden() {
		return false;
	}
}
