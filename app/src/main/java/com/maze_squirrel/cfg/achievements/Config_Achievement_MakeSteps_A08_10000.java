package com.maze_squirrel.cfg.achievements;


import com.maze_squirrel.lib.R;


public class Config_Achievement_MakeSteps_A08_10000 extends Config_Achievement_MakeSteps_Base {
	
	
	public Config_Achievement_MakeSteps_A08_10000(int id) {
		super(id, 10000);
	}
	
	
	@Override
	public int getScores() {
		return R.integer.achievement_score_make_steps_10000;
	}
	
	
	@Override
	public int getMaxCount() {
		return R.integer.achievement_maxcount_make_steps_10000;
	}
	
	
	@Override
	public int getIncrementsCount() {
		return R.integer.achievement_increments_make_steps_10000;
	}
}
