package com.maze_squirrel.cfg.achievements;


import com.maze_squirrel.lib.R;


public class Config_Achievement_MakeSteps_A01_250 extends Config_Achievement_MakeSteps_Base {
	
	
	public Config_Achievement_MakeSteps_A01_250(int id) {
		super(id, 250);
	}
	
	
	@Override
	public int getScores() {
		return R.integer.achievement_score_make_steps_250;
	}
	
	
	@Override
	public int getMaxCount() {
		return R.integer.achievement_maxcount_make_steps_250;
	}
	
	
	@Override
	public int getIncrementsCount() {
		return R.integer.achievement_increments_make_steps_250;
	}
}
