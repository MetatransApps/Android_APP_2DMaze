package org.metatrans.apps.maze.model.entities;


import java.util.List;

import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Challenger;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Ground;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;

import android.graphics.Bitmap;
import android.graphics.RectF;


public class Entity2D_Challenger_Labyrinth extends Entity2D_Challenger {
	
	
	private static final long serialVersionUID = 5416967203188382917L;
	
	
	public Entity2D_Challenger_Labyrinth(World _world, RectF _evelop,
			List<Entity2D_Ground> _blockerEntities, List<? extends IEntity2D> _killerEntities) {
		super(_world, _evelop, _blockerEntities, _killerEntities);
		
		setSpeed((Math.random() < 0.5 ? 1f : -1f) *_world.getMaxSpeed_CHALLENGER(), (Math.random() < 0.5 ? 1f : -1f) * _world.getMaxSpeed_CHALLENGER());
	}
	
	
	@Override
	public Bitmap getBitmap() {
		return ((World_Labyrints) getWorld()).getBitmap_challenger();
	}
}
