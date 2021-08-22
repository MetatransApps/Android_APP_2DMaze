package com.maze_squirrel.cfg.achievements;


import com.apps.mobile.android.commons.cfg.achievements.Config_Achievement_Base;
import com.maze_squirrel.lib.R;


public class Config_Achievement_StopPiecesOnLoading extends Config_Achievement_Base {
	
	
	@Override
	public int getID() {
		return CFG_ACHIEVEMENT_STOP_PIECES;
	}
	
	
	@Override
	public int geIDReference() {
		throw new UnsupportedOperationException();
		//return R.string.achievement_id_stop_pieces;
	}
	
	
	@Override
	public int getScores() {
		return R.integer.achievement_score_stop_pieces;
	}
	
	@Override
	public int getMaxCount() {
		return R.integer.achievement_maxcount_stop_pieces;
	}

	@Override
	public int getIncrementsCount() {
		return R.integer.achievement_increments_stop_pieces;
	}
	
	@Override
	public int getName() {
		return R.string.achievement_title_stop_pieces;
	}
	
	
	@Override
	public int getDescription() {
		return R.string.achievement_desc_stop_pieces;
	}
	
	
	@Override
	public int getIconResID() {
		return R.drawable.ic_gift_stop_pieces;
	}


	@Override
	public boolean isHidden() {
		return false;
	}
}
