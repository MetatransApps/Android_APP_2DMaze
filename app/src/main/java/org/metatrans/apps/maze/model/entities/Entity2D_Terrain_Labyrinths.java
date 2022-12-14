package org.metatrans.apps.maze.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.model.IWorld;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Ground;
import org.metatrans.commons.ui.utils.BitmapUtils;


public abstract class Entity2D_Terrain_Labyrinths extends Entity2D_Ground {


	private static final long serialVersionUID = -434579107405800961L;


	public Entity2D_Terrain_Labyrinths(IWorld world, RectF _envelop, int _subtype, int _index_x, int _index_y) {

		super(world, _envelop, _subtype, _index_x, _index_y);
	}


	protected boolean getFlag1() {

		return true;
	}


	protected Bitmap scaleBitmapToRectangleForDrawing(Bitmap org) {

		return BitmapUtils.createScaledBitmap(org,
				(int) getEnvelop_ForDraw().width(),
				(int) getEnvelop_ForDraw().height()
		);
	}


	@Override
	public int getBackgroundColour() {

		return Application_Base.getInstance().getColoursCfg().getColour_Square_White();
	}
}
