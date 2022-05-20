package org.metatrans.apps.maze.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatrans.apps.maze.app.Application_Maze;
import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Ground;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;


public class Entity2D_Ground_Empty_Labyrinths extends Entity2D_Terrain_Labyrinths {
	
	
	private static final long serialVersionUID = -434579107405800961L;


	private static final int DIRECTION_NONE 	= 0;
	public static final int DIRECTION_DOWN 	= 1;
	public static final int DIRECTION_UP 	= 2;
	public static final int DIRECTION_LEFT 	= 3;
	public static final int DIRECTION_RIGHT = 4;

	private int direction;


	public Entity2D_Ground_Empty_Labyrinths(World world, RectF _evelop, int _index_x, int _index_y) {

		super(world, _evelop, SUBTYPE_GROUND_EMPTY, _index_x,_index_y);

		direction = DIRECTION_NONE;
	}
	
	
	public int getBackgroundColour() {
		return Application_Base.getInstance().getColoursCfg().getColour_Background();
	}
	
	
	public int getBitmapTransparency() {
		return 128;
	}


	public Bitmap getBitmap() {

		switch (direction) {

			case DIRECTION_NONE:
				return ((World_Labyrints) Application_Maze.getInstance().getWorld()).getBitmap_grass();

			case DIRECTION_DOWN:
				return ((World_Labyrints) Application_Maze.getInstance().getWorld()).getBitmap_step_down();

			case DIRECTION_UP:
				return ((World_Labyrints) Application_Maze.getInstance().getWorld()).getBitmap_step_up();

			case DIRECTION_LEFT:
				return ((World_Labyrints) Application_Maze.getInstance().getWorld()).getBitmap_step_left();

			case DIRECTION_RIGHT:
				return ((World_Labyrints) Application_Maze.getInstance().getWorld()).getBitmap_step_right();

			default:
				throw new IllegalStateException("direction=" + direction);
		}
	}


	public void setDirection(int direction) {

		this.direction = direction;
	}
}
