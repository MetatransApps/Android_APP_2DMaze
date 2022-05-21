package org.metatrans.apps.maze.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatrans.apps.maze.app.Application_Maze;
import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.model.IWorld;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Ground;


public abstract class Entity2D_Terrain_Labyrinths extends Entity2D_Ground {


	private static final long serialVersionUID = -434579107405800961L;


	public Entity2D_Terrain_Labyrinths(IWorld world, RectF _evelop, int _subtype, int _index_x, int _index_y) {

		super(world, _evelop, _subtype, _index_x, _index_y);
	}


	protected Bitmap getBitmap1() {

		boolean flag1 = getFlag1();

		boolean is_border = world.isOuterBorder(getCellIndex_X(), getCellIndex_Y());

		return flag1 ? ((World_Labyrints) Application_Maze.getInstance().getWorld()).getBitmap_wall(!is_border)
				: ((World_Labyrints) Application_Maze.getInstance().getWorld()).getBitmap_wall(is_border);
	}


	protected boolean getFlag1() {

		return true;

		/*throw new UnsupportedOperationException();

		int currOrderNumber = ConfigurationUtils_Dinosaurs.getOrderNumber(((UserSettings_Dinosaurs) Application_Base.getInstance().getUserSettings()).dinosaurs_id);
		int dinosaurs_id = ConfigurationUtils_Dinosaurs.getID(currOrderNumber);
		IConfigurationDinosaurs dinosaurs_cfg = (IConfigurationDinosaurs) ConfigurationUtils_Dinosaurs.getConfigByID(dinosaurs_id);
		boolean flag1 = dinosaurs_cfg.likesFlowers();

		return flag1;
		*/
	}


	public int getBackgroundColour() {
		return Application_Base.getInstance().getColoursCfg().getColour_Square_White();
	}


	public int getBitmapTransparency() {
		return 255;
	}


	@Override
	public Bitmap getBitmap() {

		Entity2D_Ground terrain_entity = world.getTerrainCell(getCellIndex_X(), getCellIndex_Y());

		//System.out.println("getCellIndex_X()=" + getCellIndex_X() + ", getCellIndex_Y()=" + getCellIndex_Y() + ", terrain_entity=" + terrain_entity);


		if (terrain_entity instanceof Entity2D_Terrain_Empty_Labyrinths) {

			throw new UnsupportedOperationException("terrain_entity instanceof Entity2D_Terrain_Empty_Labyrinths");

		} else if (terrain_entity instanceof Entity2D_Terrain_Labyrinths) {

			return getBitmap1();

		} else {

			throw new IllegalStateException("terrain_entity = " + terrain_entity);
		}
	}


	/*@Override
	public Bitmap getBitmap() {

		Entity2D_Ground terrain_entity = world.getTerrainCell(getCellIndex_X(), getCellIndex_Y());

		if (terrain_entity instanceof Entity2D_Terrain_Empty_Labyrinths) {

			throw new UnsupportedOperationException("terrain_entity instanceof Entity2D_Terrain_Empty_Labyrinths");

		} else if (terrain_entity instanceof Entity2D_Terrain_Wall_Labyrinths) {

			return ((World_Labyrints) Application_Maze.getInstance().getWorld()).getBitmap_wall_1();

		} else if (terrain_entity instanceof Entity2D_Ground_Wall_Border_Labyrinths) {

			return ((World_Labyrints) Application_Maze.getInstance().getWorld()).getBitmap_wall_2();

		} else {

			throw new IllegalStateException("terrain_entity = " + terrain_entity);
		}
	}*/
}
