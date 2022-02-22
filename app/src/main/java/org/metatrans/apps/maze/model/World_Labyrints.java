package org.metatrans.apps.maze.model;


import java.util.ArrayList;
import java.util.List;

import org.metatrans.apps.maze.lib.R;
import org.metatrans.apps.maze.model.entities.Entity2D_Player_Labyrints;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Bullet;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Challenger;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Special;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;
import org.metatrans.commons.ui.utils.BitmapUtils;

import android.content.Context;
import android.graphics.Bitmap;


public class World_Labyrints extends World {
	
	
	private static final long serialVersionUID = 3276469433687306613L;
	
	
	private static Bitmap bitmap_player_l;
	private static Bitmap bitmap_player_r;
	private static Bitmap bitmap_challenger;
	private static Bitmap bitmap_acorn;
	private static Bitmap bitmap_wall;
	private static Bitmap bitmap_grass;
	private static Bitmap bitmap_step_down;
	private static Bitmap bitmap_step_up;
	private static Bitmap bitmap_step_left;
	private static Bitmap bitmap_step_right;
	private static Bitmap bitmap_star;
	private static Bitmap bitmap_key;
	private static Bitmap bitmap_gate;
	private static Bitmap bitmap_level;
	private static Bitmap bitmap_paw;
	
	
	private List<IEntity2D> killersEntities_forPlayer;
	private List<IEntity2D> killersEntities_forChallengers;
	
	
	public World_Labyrints(Context _activity) {
		
		super(_activity);
		
		killersEntities_forPlayer 		= new ArrayList<IEntity2D>();
		killersEntities_forChallengers 	= new ArrayList<IEntity2D>();
	}
	
	
	private static void initBitmaps() {
		
		System.out.println("!EXPENSIVE OP: RE-INIT BITMAPS OF THE WORLD");
		
		bitmap_acorn 		= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_acorn);
		bitmap_player_l   	= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_player7_l);
		bitmap_player_r   	= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_player7_r);
		bitmap_wall 		= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_lanot_wall_4);
		bitmap_grass		= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_lanot_grass_4);
		bitmap_step_down 	= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_lanot_steps4_down);
		bitmap_step_up 		= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_lanot_steps4_up);
		bitmap_step_left 	= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_lanot_steps4_left);
		bitmap_step_right 	= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_lanot_steps4_right);
		bitmap_star 		= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_star_gold);
		bitmap_challenger 	= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_challenger);
		bitmap_key			= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_key);
		bitmap_gate 		= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_gate);
		bitmap_level		= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_level);
		bitmap_paw			= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_paw_print);
	}
	
	
	@Override
	public synchronized void addEntity(IEntity2D entity) {
		
		super.addEntity(entity);
		
		if (entity instanceof Entity2D_Challenger) {
			killersEntities_forPlayer.add(entity);
		}
		
		if (entity instanceof Entity2D_Bullet) {
			killersEntities_forChallengers.add(entity);
		}
		
		if (getSpecialEntities().size() > 1) {
			throw new IllegalStateException();
		}
	}
	
	
	@Override
	public synchronized void removeMovingEntity(Entity2D_Moving entity) {
		
		super.removeMovingEntity(entity);
		
		if (entity instanceof Entity2D_Challenger) {
			killersEntities_forPlayer.remove(entity);
		}
		
		if (entity instanceof Entity2D_Bullet) {
			killersEntities_forChallengers.remove(entity);
		}
	}
	
	
	public Entity2D_Special getExitEntity() {
		return getSpecialEntities().get(0);
	}
	
	
	@Override
	public synchronized void button1(float dx, float dy) {
		
		((Entity2D_Player_Labyrints)getPlayerEntity()).shot(dx, dy);
		
	}
	
	
	protected List<IEntity2D> getKillersEntities_forPlayer() {
		return killersEntities_forPlayer;
	}
	
	
	protected List<IEntity2D> getKillersEntities_forChallengers() {
		return killersEntities_forChallengers;
	}


	public static Bitmap getBitmap_acorn() {
		if (bitmap_acorn == null || bitmap_acorn.isRecycled()) {
			initBitmaps();
		}
		return bitmap_acorn;
	}


	public static Bitmap getBitmap_player_l() {
		if (bitmap_player_l == null || bitmap_player_l.isRecycled()) {
			initBitmaps();
		}
		return bitmap_player_l;
	}


	public static Bitmap getBitmap_player_r() {
		if (bitmap_player_r == null || bitmap_player_r.isRecycled()) {
			initBitmaps();
		}
		return bitmap_player_r;
	}


	public static Bitmap getBitmap_challenger() {
		if (bitmap_challenger == null || bitmap_challenger.isRecycled()) {
			initBitmaps();
		}
		return bitmap_challenger;
	}


	public static Bitmap getBitmap_wall() {
		if (bitmap_wall == null || bitmap_wall.isRecycled()) {
			initBitmaps();
		}
		return bitmap_wall;
	}


	public static Bitmap getBitmap_grass() {
		if (bitmap_grass == null || bitmap_grass.isRecycled()) {
			initBitmaps();
		}
		return bitmap_grass;
	}


	public static Bitmap getBitmap_step_down() {
		if (bitmap_step_down == null || bitmap_step_down.isRecycled()) {
			initBitmaps();
		}
		return bitmap_step_down;
	}


	public static Bitmap getBitmap_step_up() {
		if (bitmap_step_up == null || bitmap_step_up.isRecycled()) {
			initBitmaps();
		}
		return bitmap_step_up;
	}


	public static Bitmap getBitmap_step_left() {
		if (bitmap_step_left == null || bitmap_step_left.isRecycled()) {
			initBitmaps();
		}
		return bitmap_step_left;
	}


	public static Bitmap getBitmap_step_right() {
		if (bitmap_step_right == null || bitmap_step_right.isRecycled()) {
			initBitmaps();
		}
		return bitmap_step_right;
	}


	public static Bitmap getBitmap_star() {
		if (bitmap_star == null || bitmap_star.isRecycled()) {
			initBitmaps();
		}
		return bitmap_star;
	}


	public static Bitmap getBitmap_key() {
		if (bitmap_key == null || bitmap_key.isRecycled()) {
			initBitmaps();
		}
		return bitmap_key;
	}


	public static Bitmap getBitmap_gate() {
		if (bitmap_gate == null || bitmap_gate.isRecycled()) {
			initBitmaps();
		}
		return bitmap_gate;
	}


	public static Bitmap getBitmap_level() {
		if (bitmap_level == null || bitmap_level.isRecycled()) {
			initBitmaps();
		}
		return bitmap_level;
	}


	public static Bitmap getBitmap_paw() {
		if (bitmap_paw == null || bitmap_paw.isRecycled()) {
			initBitmaps();
		}
		return bitmap_paw;
	}
}
