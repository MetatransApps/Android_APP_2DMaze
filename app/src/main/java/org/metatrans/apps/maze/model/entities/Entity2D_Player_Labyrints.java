package org.metatrans.apps.maze.model.entities;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.metatrans.apps.maze.app.Application_Maze;
import org.metatrans.apps.maze.lib.R;
import org.metatrans.apps.maze.main.Activity_Result;
import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.app.Application_2D_Base;
import org.metatrans.commons.graphics2d.model.GameData;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Collectible;
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

	private BitmapTransformationConfig transform_config;


	public Entity2D_Player_Labyrints(World_Labyrints _world, RectF _evelop, List<? extends IEntity2D> _killerEntities) {
		
		super(_world, _evelop, _world.getGroundEntities_SolidOnly(), _killerEntities, 1, 0);
		
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
	public BitmapTransformationConfig getTransform_config() {

		if (transform_config == null) {

			transform_config = new BitmapTransformationConfig(0.605f, 1.30f);
		}

		return transform_config;
	}

	
	@Override
	public void nextMoment(float takts) {


		int count_collected_before = getCollectedEntities().size();


		super.nextMoment(takts);


		int count_collected_after = getCollectedEntities().size();


		if (count_collected_after > count_collected_before) {

			for (int i = count_collected_before; i < count_collected_after; i++) {

				Entity2D_Collectible item = getCollectedEntities().get(i);

				if (item.getSubType() == IEntity2D.SUBTYPE_COLLECTIBLE_KEY) {

					Application_Base.getInstance().getSFXManager().playSound(R.raw.sfx_catching_key_1);

				} else if (item.getSubType() == IEntity2D.SUBTYPE_COLLECTIBLE_STAR) {

					Application_Base.getInstance().getSFXManager().playSound(R.raw.sfx_catching_key_2);

				} else if (item.getSubType() == IEntity2D.SUBTYPE_COLLECTIBLE_BULLET) {

					Application_Base.getInstance().getSFXManager().playSound(R.raw.sfx_catching_food);
				}
			}
		}


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

							visit_direction = Entity2D_Terrain_Empty_Labyrinths.DIRECTION_RIGHT;

						} else /*if (dx < 0)*/ {

							visit_direction = Entity2D_Terrain_Empty_Labyrinths.DIRECTION_UP;

						} /*else {

							//Do nothing
						}*/

					} else if (dx < dy) {

						if (dy > 0) {

							visit_direction = Entity2D_Terrain_Empty_Labyrinths.DIRECTION_DOWN;

						} else /*if (dy < 0)*/ {

							visit_direction = Entity2D_Terrain_Empty_Labyrinths.DIRECTION_LEFT;

						} /*else {

							//Do nothing
						}*/
					} else {

						//Do nothing
					}

					if (visit_direction != -1) {

						((Entity2D_Terrain_Empty_Labyrinths) current_ground).setDirection(visit_direction);
					}

					current_ground = cur;

					//SFX
					int[] sfx_steps = new int[] {R.raw.sfx_step_01,
							R.raw.sfx_step_02,
							R.raw.sfx_step_03,
							R.raw.sfx_step_04,
							R.raw.sfx_step_05};

					int sfx_step_index = (int) (Math.random() * sfx_steps.length);

					Application_Base.getInstance().getSFXManager().playSound(sfx_steps[sfx_step_index]);
				}
			}
		}
		
		if (levelCompletedCondition()) {

			Application_Base.getInstance().getSFXManager().playSound(R.raw.sfx_get_the_door);

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

			Application_Base.getInstance().getSFXManager().playSound(R.raw.sfx_level_completed);


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
				Entity2D_Moving bulletEntity = new Entity2D_Bullet_Labyrints(
						getWorld(),
						bulletEnvelop,
						getWorld().getGroundEntities_SolidOnly(),
						new ArrayList<>()
				);

				bulletEntity.setWorldSize(getWorld().get_WORLD_SIZE_X(), getWorld().get_WORLD_SIZE_Y());

				int max_speed = getWorld().getMaxSpeed_BULLET();
				
				if (dx > 0) {
					
					dx = max_speed;
					
				} else if (dx < 0) {
					
					dx = -max_speed;
				}
				
				bulletEntity.setSpeed(dx, 0);
				
				getWorld().addEntity(bulletEntity);

				Application_Base.getInstance().getSFXManager().playSound(R.raw.sfx_throwing_food);

			} else if (Math.abs(dx) < Math.abs(dy)) {
				
				getGameData().count_bullets--;
				
				RectF bulletEnvelop = new RectF(getEnvelop().left + border, getEnvelop().top + border, getEnvelop().right - border, getEnvelop().bottom - border);
				Entity2D_Moving bulletEntity = new Entity2D_Bullet_Labyrints(
						getWorld(),
						bulletEnvelop,
						getWorld().getGroundEntities_SolidOnly(),
						new ArrayList<>()
				);

				bulletEntity.setWorldSize(getWorld().get_WORLD_SIZE_X(), getWorld().get_WORLD_SIZE_Y());

				int max_speed = getWorld().getMaxSpeed_BULLET();
				
				if (dy > 0) {
					
					dy = max_speed;
					
				} else if (dy < 0) {
					
					dy = -max_speed;
				}
				
				bulletEntity.setSpeed(0, dy);
				
				getWorld().addEntity(bulletEntity);

				Application_Base.getInstance().getSFXManager().playSound(R.raw.sfx_throwing_food);
			}
		}
	}


	@Override
	protected void killed(Entity2D_Moving killer) {

		if (!isInBornTolerance()) {

			Application_Base.getInstance().getSFXManager().playSound(R.raw.sfx_player_catched);
		}

		super.killed(killer);
	}


	@Override
	protected void killedFinal() {
		
		super.killedFinal();

		Application_Base.getInstance().getSFXManager().playSound(R.raw.sfx_game_over);
	}
	
	
	protected GameData getGameData() {
		return (GameData) (Application_Maze.getInstance()).getGameData();
	}
}
