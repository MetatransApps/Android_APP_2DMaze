package org.metatrans.apps.maze.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatrans.apps.maze.app.Application_Maze;
import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Collectible;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;


public class Entity2D_Collectible_Star_Labyrinths extends Entity2D_Collectible {
	
	
	private static final long serialVersionUID = -7189099627812359294L;


	public Entity2D_Collectible_Star_Labyrinths(RectF _evelop) {
		super(_evelop, IEntity2D.SUBTYPE_COLLECTIBLE_STAR);
	}
	
	
	@Override
	public Bitmap getBitmap() {
		return ((World_Labyrints) Application_Maze.getInstance().getWorld()).getBitmap_star();
	}
}
