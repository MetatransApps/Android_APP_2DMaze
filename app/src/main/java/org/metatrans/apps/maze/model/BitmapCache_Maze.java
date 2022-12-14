package org.metatrans.apps.maze.model;


import org.metatrans.commons.model.BitmapCache_Base;


public class BitmapCache_Maze extends BitmapCache_Base {


	public static final int BITMAP_ID_LEVEL 					= 11;


	public BitmapCache_Maze(Integer cache_id) {

		super(cache_id);
	}


	@Override
	public void initBitmaps() {


		System.out.println("!EXPENSIVE OP: RE-INIT BITMAPS OF THE WORLD");


		/*BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_LEVEL,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_level));
		*/
	}
}
