package org.metatrans.apps.maze.model.entities;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.metatrans.apps.maze.app.Application_Maze;
import org.metatrans.apps.maze.main.Activity_Result;
import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.graphics2d.app.Application_2D_Base;
import org.metatrans.commons.graphics2d.model.GameData;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Ground;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Player;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Special;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;
import org.metatrans.commons.model.LevelResult_Base;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.RectF;


public class Entity2D_Player_Labyrints extends Entity2D_Player {
	
	
	private static final long serialVersionUID = 3604452932833478013L;
	
	
	private Entity2D_Special gateEntity;

	private Set<Entity2D_Ground> visited;
	
	private Entity2D_Ground current_ground;


	public Entity2D_Player_Labyrints(World_Labyrints _world, RectF _evelop, List<? extends IEntity2D> _killerEntities) {
		
		super(_world, _evelop, _world.getGroundEntities_SolidOnly(), _killerEntities);
		
		gateEntity = getWorld().getExitEntity();
		
		visited = new HashSet<Entity2D_Ground>();
	}


	@Override
	protected World_Labyrints getWorld() {
		return (World_Labyrints) super.getWorld();
	}
	
	
	protected Class<? extends Activity> getActivityResult_Class() {
		return Activity_Result.class;
	}
	
	
	@Override
	public Bitmap getBitmap() {
		return (getDx() >= 0) ? ((World_Labyrints) getWorld()).getBitmap_player_r() : ((World_Labyrints) getWorld()).getBitmap_player_l();
	}
	
	
	@Override
	public void nextMoment(float takts) {
		
		super.nextMoment(takts);
		
		List<Entity2D_Ground> groundEntities_NotSolid = getWorld().getGroundEntities_NotSolidOnly();

		for (Entity2D_Ground cur: groundEntities_NotSolid) {

			float player_center_x = getEnvelop().left + (getEnvelop().right - getEnvelop().left) / 2;
			float player_center_y = getEnvelop().top  + (getEnvelop().bottom - getEnvelop().top) / 2;

			if (cur.getEnvelop().contains(player_center_x, player_center_y)) {

				if (!visited.contains(cur)) {

					visited.add(cur);

					getGameData().count_steps++;
				}


				if (current_ground == null) {

					current_ground = cur;
				}

				if (cur != current_ground) {

					float dx = cur.getEnvelop().left - current_ground.getEnvelop().left;
					float dy = cur.getEnvelop().top - current_ground.getEnvelop().top;

					int visit_direction = -1;

					if (dx > dy) {

						if (dx > 0) {

							visit_direction = Entity2D_Ground_Empty_Labyrinths.DIRECTION_RIGHT;

						} else /*if (dx < 0)*/ {

							visit_direction = Entity2D_Ground_Empty_Labyrinths.DIRECTION_UP;

						} /*else {

							//Do nothing
						}*/

					} else if (dx < dy) {

						if (dy > 0) {

							visit_direction = Entity2D_Ground_Empty_Labyrinths.DIRECTION_DOWN;

						} else /*if (dy < 0)*/ {

							visit_direction = Entity2D_Ground_Empty_Labyrinths.DIRECTION_LEFT;

						} /*else {

							//Do nothing
						}*/
					} else {

						//Do nothing
					}

					if (visit_direction != -1) {

						((Entity2D_Ground_Empty_Labyrinths) current_ground).setDirection(visit_direction);
					}

					current_ground = cur;
				}
			}
		}
		
		if (levelCompletedCondition()) {
			
			getGameData().level_completed = true;
			
			LevelResult_Base levelResult = Application_2D_Base.getInstance().getLevelsResults().getResult(Application_2D_Base.getInstance().getUserSettings().modeID);
			if (getGameData().count_stars > levelResult.getCount_Stars()) {
				levelResult.setCount_stars(getGameData().count_stars);
				Application_2D_Base.getInstance().storeLevelsResults();
			}
			
			if (getGameData().count_stars >= 3) {
				Application_2D_Base.getInstance().setNextLevel();
			}
			getGameData().last_count_stars = getGameData().count_stars;
			getGameData().count_stars = 0;
			
			getGameData().total_count_steps += getGameData().count_steps;
			//getGameData().last_count_steps = getGameData().total_count_steps;
			getGameData().count_steps = 0;
			
			getGameData().world = Application_2D_Base.getInstance().createNewWorld();
		}
	}


	protected boolean levelCompletedCondition() {
		return hasKey() && RectF.intersects(getEnvelop(), gateEntity.getEnvelop());
	}
	
	
	public void shot(float dx, float dy) {
		
		if (getGameData().count_bullets > 0) {
			
			float border = 3;//getWorld().getCellSize() / 9;
			
			if (Math.abs(dx) > Math.abs(dy)) {
				
				getGameData().count_bullets--;
				
				//RectF bulletEnvelop = new RectF(getEvelop().left + 5, getEvelop().top + 5, getEvelop().right - 5, getEvelop().bottom - 5);
				RectF bulletEnvelop = new RectF(getEnvelop().left + border, getEnvelop().top + border, getEnvelop().right - border, getEnvelop().bottom - border);
				Entity2D_Moving bulletEntity = new Entity2D_Bullet_Labyrints(getWorld(), bulletEnvelop, getBlockerEntities());
				
				int max_speed = getWorld().getMaxSpeed_BULLET();
				
				if (dx > 0) {
					
					dx = max_speed;
					
				} else if (dx < 0) {
					
					dx = -max_speed;
				}
				
				bulletEntity.setSpeed(dx, 0);
				
				getWorld().addEntity(bulletEntity);
				
			} else if (Math.abs(dx) < Math.abs(dy)) {
				
				getGameData().count_bullets--;
				
				//RectF bulletEnvelop = new RectF(getEvelop().left + 5, getEvelop().top + 5, getEvelop().right - 5, getEvelop().bottom - 5);
				RectF bulletEnvelop = new RectF(getEnvelop().left + border, getEnvelop().top + border, getEnvelop().right - border, getEnvelop().bottom - border);
				Entity2D_Moving bulletEntity = new Entity2D_Bullet_Labyrints(getWorld(), bulletEnvelop, getBlockerEntities());
				
				int max_speed = getWorld().getMaxSpeed_BULLET();
				
				if (dy > 0) {
					
					dy = max_speed;
					
				} else if (dy < 0) {
					
					dy = -max_speed;
				}
				
				bulletEntity.setSpeed(0, dy);
				
				getWorld().addEntity(bulletEntity);
			}
		
		}
	}
	
	
	@Override
	protected void killedFinal() {
		
		super.killedFinal();
	}
	
	
	protected GameData getGameData() {
		return (GameData) (Application_Maze.getInstance()).getGameData();
	}
}
