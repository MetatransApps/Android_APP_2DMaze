package org.metatrans.apps.maze.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatrans.apps.maze.app.Application_Maze;
import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Special;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;


public class Entity2D_Special_Gate_Labyrints extends Entity2D_Special {
	
	
	private static final long serialVersionUID = -4487276789823271266L;


	public Entity2D_Special_Gate_Labyrints(RectF _evelop) {
		super(_evelop, IEntity2D.SUBTYPE_SPECIAL_EXIT);
	}
	
	
	@Override
	public Bitmap getBitmap() {
		return ((World_Labyrints) Application_Maze.getInstance().getWorld()).getBitmap_gate();
	}
}
