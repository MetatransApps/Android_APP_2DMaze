package org.metatrans.apps.maze.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatrans.apps.maze.app.Application_Maze;
import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Collectible;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;


public class Entity2D_Collectible_Acorn_Labyrinths extends Entity2D_Collectible {
	
	
	private static final long serialVersionUID = 7416665108604375873L;


	public Entity2D_Collectible_Acorn_Labyrinths(RectF _evelop) {
		super(_evelop, IEntity2D.SUBTYPE_COLLECTIBLE_BULLET);
	}


	@Override
	public Bitmap getBitmap() {
		return ((World_Labyrints) Application_Maze.getInstance().getWorld()).getBitmap_acorn();
	}
}
