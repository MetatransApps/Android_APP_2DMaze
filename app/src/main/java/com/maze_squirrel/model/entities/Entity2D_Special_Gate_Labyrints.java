package com.maze_squirrel.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import com.apps.mobile.android.commons.graphics2d.model.entities.Entity2D_Special;
import com.apps.mobile.android.commons.graphics2d.model.entities.IEntity2D;
import com.maze_squirrel.model.World_Labyrints;


public class Entity2D_Special_Gate_Labyrints extends Entity2D_Special {
	
	
	private static final long serialVersionUID = -4487276789823271266L;


	public Entity2D_Special_Gate_Labyrints(RectF _evelop) {
		super(_evelop, IEntity2D.SUBTYPE_SPECIAL_EXIT);
	}
	
	
	@Override
	public Bitmap getBitmap() {
		return World_Labyrints.getBitmap_gate();
	}
}
