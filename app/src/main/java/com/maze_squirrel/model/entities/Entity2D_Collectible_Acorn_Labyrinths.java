package com.maze_squirrel.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatrans.commons.graphics2d.model.entities.Entity2D_Collectible;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;

import com.maze_squirrel.model.World_Labyrints;


public class Entity2D_Collectible_Acorn_Labyrinths extends Entity2D_Collectible {
	
	
	private static final long serialVersionUID = 7416665108604375873L;


	public Entity2D_Collectible_Acorn_Labyrinths(RectF _evelop) {
		super(_evelop, IEntity2D.SUBTYPE_COLLECTIBLE_BULLET);
	}
	
	
	@Override
	public Bitmap getBitmap() {
		return World_Labyrints.getBitmap_acorn();
	}
}
