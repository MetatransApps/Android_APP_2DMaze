package org.metatrans.apps.maze.cfg.achievements;


import org.metatrans.apps.maze.lib.R;


public class Config_Achievement_MakeSteps_A12_100000 extends Config_Achievement_MakeSteps_Base {
	
	
	public Config_Achievement_MakeSteps_A12_100000(int id) {
		super(id, 100000);
	}
	
	
	@Override
	public int getScores() {
		return R.integer.achievement_score_make_steps_100000;
	}
	
	
	@Override
	public int getMaxCount() {
		return R.integer.achievement_maxcount_make_steps_100000;
	}
	
	
	@Override
	public int getIncrementsCount() {
		return R.integer.achievement_increments_make_steps_100000;
	}
}
