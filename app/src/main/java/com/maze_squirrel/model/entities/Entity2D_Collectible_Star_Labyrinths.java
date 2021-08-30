package com.maze_squirrel.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatransapps.commons.graphics2d.model.entities.Entity2D_Collectible;
import org.metatransapps.commons.graphics2d.model.entities.IEntity2D;

import com.maze_squirrel.model.World_Labyrints;


public class Entity2D_Collectible_Star_Labyrinths extends Entity2D_Collectible {
	
	
	private static final long serialVersionUID = -7189099627812359294L;


	public Entity2D_Collectible_Star_Labyrinths(RectF _evelop) {
		super(_evelop, IEntity2D.SUBTYPE_COLLECTIBLE_STAR);
	}
	
	
	@Override
	public Bitmap getBitmap() {
		return World_Labyrints.getBitmap_star();
	}
}
