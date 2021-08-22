package com.maze_squirrel.cfg.world;


public abstract class Configuration_World_Base implements IConfigurationWorld {
	
	
	private int id;
	private int count_challengers;
	private float spaceMultiplier;
	
	
	public Configuration_World_Base(int _id, int _count_challengers, float _spaceMultiplier) {
		id = _id;
		count_challengers = _count_challengers;
		spaceMultiplier = _spaceMultiplier;
	}
	
	
	@Override
	public int getID() {
		return id;
	}
	
	
	@Override
	public int getCountChallengers() {
		return count_challengers;
	}
	
	
	@Override
	public float getSpaceMultiplier() {
		return spaceMultiplier;
	}
}
