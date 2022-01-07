package org.metatrans.apps.maze.cfg.world;


import org.metatrans.apps.maze.lib.R;
import org.metatrans.apps.maze.model.WorldGenerator_Labyrints;
import org.metatrans.commons.app.Application_Base;


public class Configuration_World extends Configuration_World_Base {
	
	
	public Configuration_World(int id, int _count_challengers, float _spaceMultiplier) {
		
		super(id, _count_challengers, _spaceMultiplier);
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
		return getName(count_challengers, spaceMultiplier);
	}


	@Override
	public String getDescription_String() {
		return "";
	}
}
