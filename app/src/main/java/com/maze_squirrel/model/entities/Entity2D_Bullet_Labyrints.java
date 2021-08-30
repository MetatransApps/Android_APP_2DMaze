package com.maze_squirrel.model.entities;


import java.util.List;

import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Bullet;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Collectible;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;

import com.maze_squirrel.model.World_Labyrints;

import android.graphics.Bitmap;
import android.graphics.RectF;


public class Entity2D_Bullet_Labyrints extends Entity2D_Bullet {
	
	
	private static final long serialVersionUID = -2015301064405980601L;
	
	
	public Entity2D_Bullet_Labyrints(World _world, RectF _evelop, List<? extends IEntity2D> _blockerEntities) {
		
		super(_world, _evelop, _blockerEntities);
		
	}
	
	
	@Override
	public Bitmap getBitmap() {
		return World_Labyrints.getBitmap_acorn();
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
		RectF acornEnvelop = new RectF(getEvelop().left, getEvelop().top, getEvelop().left + getWorld().getCellSize(), getEvelop().top + getWorld().getCellSize());
		Entity2D_Collectible acornEntity = new Entity2D_Collectible_Acorn_Labyrinths(acornEnvelop); 
		
		getWorld().addEntity(acornEntity);
	}
}
