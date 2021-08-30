package com.maze_squirrel.cfg.achievements;


import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.achievements.Config_Achievement_Base;

import com.maze_squirrel.lib.R;


public abstract class Config_Achievement_MakeSteps_Base extends Config_Achievement_Base {
	
	
	private int id;
	private int count_steps;
	
	
	protected Config_Achievement_MakeSteps_Base(int _id, int _count_steps) {
		id = _id;
		count_steps = _count_steps;
	}
	
	
	@Override
	public int getID() {
		return id;
	}
	
	
	@Override
	public String getName_String() {
		return Application_Base.getInstance().getString(R.string.make)
				+ " " + count_steps + " "
				+ Application_Base.getInstance().getString(R.string.steps);
	}
	
	
	@Override
	public String getDescription_String() {
		return " " + Application_Base.getInstance().getString(R.string.achievement_desc_1)
				+ " " + count_steps
				+ " " + Application_Base.getInstance().getString(R.string.achievement_desc_2);
	}
	
	
	@Override
	public int getIconResID() {
		return R.drawable.ic_cup;
	}
	
	
	@Override
	public int getName() {
		throw new UnsupportedOperationException("Call getName_String instead");
	}
	
	
	@Override
	public int getDescription() {
		throw new UnsupportedOperationException("Call getDescription_String instead");
	}
}
