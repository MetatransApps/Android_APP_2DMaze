package com.maze_squirrel.cfg.achievements;


import com.apps.mobile.android.commons.cfg.achievements.Config_Achievement_Base;
import com.maze_squirrel.lib.R;


public class Config_Achievement_Invite3Friends extends Config_Achievement_Base {
	
	
	@Override
	public int getID() {
		return CFG_ACHIEVEMENT_INVITE_3_FRIENDS;
	}
	
	
	@Override
	public int geIDReference() {
		throw new UnsupportedOperationException();
		//return R.string.achievement_id_invite_3_friends;
	}
	
	
	@Override
	public int getScores() {
		return R.integer.achievement_score_invite_3_friends;
	}
	
	@Override
	public int getMaxCount() {
		return R.integer.achievement_maxcount_invite_3_friends;
	}

	@Override
	public int getIncrementsCount() {
		return R.integer.achievement_increments_invite_3_friends;
	}
	
	@Override
	public int getName() {
		return R.string.achievement_title_invite_3_friends;
	}
	
	
	@Override
	public int getDescription() {
		return R.string.achievement_desc_invite_3_friends;
	}
	
	
	@Override
	public int getIconResID() {
		return R.drawable.ic_gift_invite;
	}


	@Override
	public boolean isHidden() {
		return false;
	}
}
