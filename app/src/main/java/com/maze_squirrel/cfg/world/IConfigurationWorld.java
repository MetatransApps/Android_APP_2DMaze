package com.maze_squirrel.cfg.world;


import com.apps.mobile.android.commons.cfg.difficulty.IConfigurationDifficulty;


public interface IConfigurationWorld extends IConfigurationDifficulty {
	
	public float getSpaceMultiplier();
	public int getCountChallengers();
	
	public String getName_String();
	public String getDescription_String();
	
}
