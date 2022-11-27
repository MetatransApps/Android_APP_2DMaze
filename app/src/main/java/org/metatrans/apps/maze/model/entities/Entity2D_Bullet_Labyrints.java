package org.metatrans.apps.maze.model.entities;


import java.util.List;

import org.metatrans.apps.maze.lib.R;
import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Bullet;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Collectible;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;

import android.graphics.Bitmap;
import android.graphics.RectF;


public class Entity2D_Bullet_Labyrints extends Entity2D_Bullet {
	
	
	private static final long serialVersionUID = -2015301064405980601L;
	
	public Entity2D_Bullet_Labyrints(
				World _world,
				RectF _envelop,
				List<? extends IEntity2D> _blockerEntities,
				List<? extends IEntity2D> _killerEntities) {

			super(_world, _envelop, _blockerEntities, _killerEntities, R.drawable.ic_acorn_transparent, 0);
	}


	@Override
	protected boolean hasCustomEnvelopForDraw() {

		return true;
	}


	@Override
	public Bitmap getBitmap() {
		return ((World_Labyrints) getWorld()).getBitmap_acorn();
	}
	
	
	@Override
	public void nextMoment(float takts) {
		
		super.nextMoment(takts);
		
	}
	
	
	@Override
	protected void groundContact_X() {
		
		super.groundContact_X();
		
		convert2collectible();
	}
	
	
	@Override
	protected void groundContact_Y() {
		
		super.groundContact_Y();
		
		convert2collectible();
	}
	
	
	private void convert2collectible() {
		RectF acornEnvelop = new RectF(getEnvelop().left, getEnvelop().top, getEnvelop().left + getWorld().getCellSize(), getEnvelop().top + getWorld().getCellSize());
		Entity2D_Collectible acornEntity = new Entity2D_Collectible_Acorn_Labyrinths(acornEnvelop); 
		
		getWorld().addEntity(acornEntity);
	}
}
