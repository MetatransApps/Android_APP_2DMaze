package org.metatrans.apps.maze.model.entities;


import java.util.List;

import org.metatrans.apps.maze.lib.R;
import org.metatrans.apps.maze.model.BitmapCache_Maze;
import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Challenger;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Ground;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;

import android.graphics.Bitmap;
import android.graphics.RectF;


public class Entity2D_Challenger_Labyrinth extends Entity2D_Challenger {
	
	
	private static final long serialVersionUID = 5416967203188382917L;


	private BitmapTransformationConfig transform_config;


	public Entity2D_Challenger_Labyrinth(World _world, RectF _evelop,
			List<Entity2D_Ground> _blockerEntities, List<? extends IEntity2D> _killerEntities) {

		super(_world, _evelop, _blockerEntities, _killerEntities, 1, 0);
		
		setSpeed((Math.random() < 0.5 ? 1f : -1f) *_world.getMaxSpeed_CHALLENGER(), (Math.random() < 0.5 ? 1f : -1f) * _world.getMaxSpeed_CHALLENGER());
	}


	@Override
	public Bitmap getBitmap() {

		return (getDx() >= 0) ? ((World_Labyrints) getWorld()).getBitmap_challenger_r() : ((World_Labyrints) getWorld()).getBitmap_challenger_l();
	}


	@Override
	public BitmapTransformationConfig getTransform_config() {

		if (transform_config == null) {

			transform_config = new BitmapTransformationConfig(0.605f, 1.30f);
		}

		return transform_config;
	}


	@Override
	protected void killed(Entity2D_Moving killer) {

		super.killed(killer);

		Application_Base.getInstance().getSFXManager().playSound(R.raw.sfx_challenger_fed);
	}
}
