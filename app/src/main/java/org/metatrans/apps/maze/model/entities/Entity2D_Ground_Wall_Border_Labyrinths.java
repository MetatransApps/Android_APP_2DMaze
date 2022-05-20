package org.metatrans.apps.maze.model.entities;


import android.graphics.RectF;

import org.metatrans.commons.graphics2d.model.IWorld;


public class Entity2D_Ground_Wall_Border_Labyrinths extends Entity2D_Terrain_Labyrinths {


	private static final long serialVersionUID = -9092028927106771746L;


	public Entity2D_Ground_Wall_Border_Labyrinths(IWorld world, RectF _evelop, int _index_x, int _index_y) {
		super(world, _evelop, SUBTYPE_GROUND_WALL, _index_x, _index_y);
	}
}
