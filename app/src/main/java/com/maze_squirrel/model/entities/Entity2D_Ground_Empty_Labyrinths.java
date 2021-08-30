package com.maze_squirrel.model.entities;


import android.graphics.RectF;

import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Ground;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;


public class Entity2D_Ground_Empty_Labyrinths extends Entity2D_Ground {
	
	
	private static final long serialVersionUID = -434579107405800961L;


	public Entity2D_Ground_Empty_Labyrinths(RectF _evelop) {
		super(_evelop, IEntity2D.SUBTYPE_GROUND_EMPTY);
	}
	
	
	public int getBackgroundColour() {
		return Application_Base.getInstance().getColoursCfg().getColour_Background();
	}
	
	
	public int getBitmapTransparency() {
		throw new IllegalStateException("no bitmap");
	}
}
