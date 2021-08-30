package com.maze_squirrel.cfg.world;


import org.metatransapps.commons.app.Application_Base;

import com.maze_squirrel.lib.R;
import com.maze_squirrel.model.WorldGenerator_Labyrints;


public class Configuration_World extends Configuration_World_Base {
	
	
	private String name;
	private String description;
	
	
	public Configuration_World(int id, int count_challengers, float spaceMultiplier) {
		
		super(id, count_challengers, spaceMultiplier);
		
		description = getDescription(count_challengers, spaceMultiplier);
		name 		= getName(count_challengers, spaceMultiplier);
	}
	
	
	private String getDescription(int challengers, float spaceMultiplier) {
		
		//int[] cells_count = WorldGenerator_Labyrints.getCellsCount(spaceMultiplier);
		return ""; //"Cells " + cells_count[0] + "x" + cells_count[1] + ", Enemies " + challengers;
	}
	
	
	private String getName(int challengers, float spaceMultiplier) {
		
		String name = Application_Base.getInstance().getString(R.string.level) + " " + getID();
		
		int[] cells_count = WorldGenerator_Labyrints.getCellsCount(spaceMultiplier);
		
		name += " (" + cells_count[0] + "x" + cells_count[1] + " " + Application_Base.getInstance().getString(R.string.steps)
				+ ", " + challengers + " " + Application_Base.getInstance().getString(R.string.enemies) + " )";
		
		return name;
	}
	
	
	@Override
	public int getName() {
		throw new UnsupportedOperationException();
	}
	
	
	@Override
	public int getIconResID() {
		return R.drawable.ic_star_gold;
	}
	
	
	@Override
	public int getDescription() {
		throw new UnsupportedOperationException();
	}


	@Override
	public String getName_String() {	
		return name;
	}


	@Override
	public String getDescription_String() {
		return description;
	}
}
