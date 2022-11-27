package org.metatrans.apps.maze.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.graphics2d.model.World;

import java.util.HashMap;
import java.util.Map;


public class Entity2D_Terrain_Empty_Labyrinths extends Entity2D_Terrain_Labyrinths {
	
	
	private static final long serialVersionUID = -434579107405800961L;


	private static final int DIRECTION_NONE 	= 0;
	public static final int DIRECTION_DOWN 	= 1;
	public static final int DIRECTION_UP 	= 2;
	public static final int DIRECTION_LEFT 	= 3;
	public static final int DIRECTION_RIGHT = 4;

	private int direction;

	private transient Map<Integer, Bitmap> bitmap_cache;


	public Entity2D_Terrain_Empty_Labyrinths(World world, RectF _evelop, int _index_x, int _index_y) {

		super(world, _evelop, SUBTYPE_GROUND_EMPTY, _index_x,_index_y);

		direction = DIRECTION_NONE;
	}


	public void setDirection(int direction) {

		this.direction = direction;
	}


	@Override
	public Bitmap getBitmap() {

		//if (true) return null;

		if (bitmap_cache == null) {

			bitmap_cache = new HashMap<Integer, Bitmap>();
		}

		Bitmap cached = bitmap_cache.get(direction);

		if (cached == null) {

			switch (direction) {

				case DIRECTION_NONE:
					cached = scaleBitmapToRectangleForDrawing(((World_Labyrints) world).getBitmap_grass());
					break;

				case DIRECTION_DOWN:
					cached = scaleBitmapToRectangleForDrawing( ((World_Labyrints) world).getBitmap_step_down());
					break;

				case DIRECTION_UP:
					cached = scaleBitmapToRectangleForDrawing(((World_Labyrints) world).getBitmap_step_up());
					break;

				case DIRECTION_LEFT:
					cached = scaleBitmapToRectangleForDrawing(((World_Labyrints) world).getBitmap_step_left());
					break;

				case DIRECTION_RIGHT:
					cached = scaleBitmapToRectangleForDrawing(((World_Labyrints) world).getBitmap_step_right());
					break;

				default:
					throw new IllegalStateException("direction=" + direction);
			}

			bitmap_cache.put(direction, cached);
		}

		return cached;
	}
}
