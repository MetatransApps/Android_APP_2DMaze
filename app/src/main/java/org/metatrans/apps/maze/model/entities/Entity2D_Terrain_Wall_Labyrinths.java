package org.metatrans.apps.maze.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.graphics2d.model.IWorld;

import java.util.HashMap;
import java.util.Map;


public class Entity2D_Terrain_Wall_Labyrinths extends Entity2D_Terrain_Labyrinths {
	
	
	private static final long serialVersionUID = -9092028927106771746L;

	private transient Map<Boolean, Bitmap> bitmap_cache;


	public Entity2D_Terrain_Wall_Labyrinths(IWorld world, RectF _evelop, int _index_x, int _index_y) {

		super(world, _evelop, SUBTYPE_GROUND_WALL, _index_x, _index_y);
	}


	@Override
	public Bitmap getBitmap() {

		//if (true) return null;

		boolean wall_index = getFlag1() ^ world.isOuterBorder(getCellIndex_X(), getCellIndex_Y());

		if (bitmap_cache == null) {

			bitmap_cache = new HashMap<Boolean, Bitmap>();
		}

		Bitmap cached = bitmap_cache.get(wall_index);

		if (cached == null) {

			cached = scaleBitmapToRectangleForDrawing(((World_Labyrints) world).getBitmap_wall(wall_index));

			bitmap_cache.put(wall_index, cached);
		}

		return cached;
	}
}
