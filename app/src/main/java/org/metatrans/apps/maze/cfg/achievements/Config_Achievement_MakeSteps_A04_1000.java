package org.metatrans.apps.maze.cfg.achievements;


import org.metatrans.apps.maze.lib.R;


public class Config_Achievement_MakeSteps_A04_1000 extends Config_Achievement_MakeSteps_Base {
	
	
	public Config_Achievement_MakeSteps_A04_1000(int id) {
		super(id, 1000);
	}
	
	
	@Override
	public int getScores() {
		return R.integer.achievement_score_make_steps_1000;
	}
	
	
	@Override
	public int getMaxCount() {
		return R.integer.achievement_maxcount_make_steps_1000;
	}
	
	
	@Override
	public int getIncrementsCount() {
		return R.integer.achievement_increments_make_steps_1000;
	}
}
