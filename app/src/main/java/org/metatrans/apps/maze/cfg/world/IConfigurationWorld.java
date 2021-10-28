package org.metatrans.apps.maze.cfg.world;


import org.metatrans.commons.cfg.difficulty.IConfigurationDifficulty;


public interface IConfigurationWorld extends IConfigurationDifficulty {
	
	public float getSpaceMultiplier();
	public int getCountChallengers();
	
	public String getName_String();
	public String getDescription_String();
	
}
