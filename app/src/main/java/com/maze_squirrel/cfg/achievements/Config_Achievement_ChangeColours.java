package com.maze_squirrel.cfg.achievements;


import com.apps.mobile.android.commons.cfg.achievements.Config_Achievement_Base;
import com.maze_squirrel.lib.R;


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
