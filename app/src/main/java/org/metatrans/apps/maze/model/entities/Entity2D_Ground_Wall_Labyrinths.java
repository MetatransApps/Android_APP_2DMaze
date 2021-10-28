package org.metatrans.apps.maze.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Ground;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;


public class Entity2D_Ground_Wall_Labyrinths extends Entity2D_Ground {
	
	
	private static final long serialVersionUID = -9092028927106771746L;


	public Entity2D_Ground_Wall_Labyrinths(RectF _evelop) {
		super(_evelop, IEntity2D.SUBTYPE_GROUND_WALL);
	}
	
	
	public int getBackgroundColour() {
		return Application_Base.getInstance().getColoursCfg().getColour_Square_White();
	}
	
	
	public int getBitmapTransparency() {
		return 99;
	}
	
	
	public Bitmap getBitmap() {
		return World_Labyrints.getBitmap_wall();
	}
}
