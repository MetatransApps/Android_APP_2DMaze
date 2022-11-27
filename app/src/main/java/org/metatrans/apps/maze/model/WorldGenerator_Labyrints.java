package org.metatrans.apps.maze.model;


import java.util.ArrayList;
import java.util.List;

import org.metatrans.apps.maze.cfg.world.IConfigurationWorld;
import org.metatrans.apps.maze.logic.provider2.Maze;
import org.metatrans.apps.maze.model.entities.Entity2D_Challenger_Labyrinth;
import org.metatrans.apps.maze.model.entities.Entity2D_Collectible_Acorn_Labyrinths;
import org.metatrans.apps.maze.model.entities.Entity2D_Collectible_Key_Labyrinths;
import org.metatrans.apps.maze.model.entities.Entity2D_Collectible_Star_Labyrinths;
import org.metatrans.apps.maze.model.entities.Entity2D_Terrain_Empty_Labyrinths;
import org.metatrans.apps.maze.model.entities.Entity2D_Player_Labyrints;
import org.metatrans.apps.maze.model.entities.Entity2D_Special_Gate_Labyrints;
import org.metatrans.apps.maze.model.entities.Entity2D_Terrain_Wall_Labyrinths;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Base;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Challenger;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.ui.utils.ScreenUtils;

import android.content.Context;
import android.graphics.RectF;


public class WorldGenerator_Labyrints {


	private static int MATRIX_DELIMITER = 1;

	private static int CELLS_COUNT_PER_SCREEN = 7;

	private static float CHARACTER_FILL_PERCENT = 0.70f;


	public static int[] getCellsCount(float spaceMultiplier) {

		int[] screen_size = ScreenUtils.getScreenSize(Application_Base.getInstance());
		int main_width = (int) (spaceMultiplier * CELLS_COUNT_PER_SCREEN * (Math.max(screen_size[0], screen_size[1]) / (double)Math.min(screen_size[0], screen_size[1])));
		int main_height = (int) (spaceMultiplier * CELLS_COUNT_PER_SCREEN );

		int count_cells_x = (int) (main_width / (float) MATRIX_DELIMITER);
		int count_cells_y = (int) (main_height / (float) MATRIX_DELIMITER);
		if (count_cells_x % 2 == 0) {
			count_cells_x++;
		}
		if (count_cells_y % 2 == 0) {
			count_cells_y++;
		}

		return new int[] {count_cells_x, count_cells_y};
	}


	public static World generate(Context activity, IConfigurationWorld cfg_world) {

		System.out.println("GAMEDATA GENERATION");

		int[] screen_size = ScreenUtils.getScreenSize(activity);
		int main_width = (int) (cfg_world.getSpaceMultiplier() * Math.max(screen_size[0], screen_size[1]));
		int main_height = (int) (cfg_world.getSpaceMultiplier() * Math.min(screen_size[0], screen_size[1]));

		int[] cells_count = getCellsCount(cfg_world.getSpaceMultiplier());
		int count_cells_x = cells_count[0];
		int count_cells_y = cells_count[1];


		Maze m = new Maze(count_cells_y, count_cells_x);
		m.generateMaze();
		//m1.generate();
		int[][] maze = m.getMaze();


		float size_x = main_width / (float) maze[0].length;
		float size_y = main_height / (float) maze.length;
		float cell_size = Math.min(size_x, size_y);

		World_Labyrints world = new World_Labyrints(activity, maze[0].length, maze.length);

		world.setCellSize(cell_size);


		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[r].length; c++) {

				float x = c * size_x;
				float y = r * size_y;

				RectF envelop = new RectF(x, y, (x + size_x), (y + size_y));


				if (maze[r][c] == 0) {

					//Ground
					world.addEntity(new Entity2D_Terrain_Empty_Labyrinths(world, envelop, c, r));

				} else {

					//Walls
					world.addEntity(new Entity2D_Terrain_Wall_Labyrinths(world, envelop, c, r));
				}
			}
		}


		List<Entity2D_Base> buffer_entities = new ArrayList<Entity2D_Base>();
		buffer_entities.addAll(world.getGroundEntities_NotSolidOnly());

		Entity2D_Base cell_top_left = getGroundEntity(buffer_entities, 0, 0);
		buffer_entities.remove(cell_top_left);

		Entity2D_Base cell_14x_14y = getGroundEntity(buffer_entities, (count_cells_x * size_x) / 4, (count_cells_y * size_y) / 4);
		buffer_entities.remove(cell_14x_14y);

		Entity2D_Base cell_top_right = getGroundEntity(buffer_entities, count_cells_x * size_x, 0);
		buffer_entities.remove(cell_top_right);

		Entity2D_Base cell_bottom_left = getGroundEntity(buffer_entities, 0, count_cells_y * size_y);
		buffer_entities.remove(cell_bottom_left);

		Entity2D_Base cell_bottom_right = getGroundEntity(buffer_entities, count_cells_x * size_x, count_cells_y * size_y);
		buffer_entities.remove(cell_bottom_right);

		Entity2D_Base cell_center_key = getGroundEntity(buffer_entities, (count_cells_x * size_x) / 2, (count_cells_y * size_y) / 2);
		buffer_entities.remove(cell_center_key);

		Entity2D_Base cell_center_star = getGroundEntity(buffer_entities, (count_cells_x * size_x) / 2, (count_cells_y * size_y) / 2);
		buffer_entities.remove(cell_center_star);


		world.addEntity(new Entity2D_Collectible_Key_Labyrinths(new RectF(cell_center_key.getX(), cell_center_key.getY(), cell_center_key.getX() + 0.95f * cell_size, cell_center_key.getY() + 0.95f * cell_size)));
		world.addEntity(new Entity2D_Special_Gate_Labyrints(
						new RectF(cell_bottom_right.getX() - 0.3f * cell_size,
								cell_bottom_right.getY() - 0.2f * cell_size,
								cell_bottom_right.getX() + 1.3f * cell_size,
								cell_bottom_right.getY() + 1.0f * cell_size)
				)
		);

		world.addEntity(new Entity2D_Collectible_Star_Labyrinths(new RectF(cell_top_right.getX(), cell_top_right.getY(), cell_top_right.getX() + 1f * cell_size, cell_top_right.getY() + 1f * cell_size)));
		world.addEntity(new Entity2D_Collectible_Star_Labyrinths(new RectF(cell_bottom_left.getX(), cell_bottom_left.getY(), cell_bottom_left.getX() + 1f * cell_size, cell_bottom_left.getY() + 1f * cell_size)));
		world.addEntity(new Entity2D_Collectible_Star_Labyrinths(new RectF(cell_center_star.getX(), cell_center_star.getY(), cell_center_star.getX() + 1f * cell_size, cell_center_star.getY() + 1f * cell_size)));
		world.addEntity(new Entity2D_Player_Labyrints(world, new RectF(cell_top_left.getX(), cell_top_left.getY(), cell_top_left.getX() + CHARACTER_FILL_PERCENT * cell_size, cell_top_left.getY() + CHARACTER_FILL_PERCENT * cell_size), world.getKillersEntities_forPlayer()));
		world.addEntity(new Entity2D_Collectible_Acorn_Labyrinths(new RectF(cell_14x_14y.getX(), cell_14x_14y.getY(), cell_14x_14y.getX() + 1f * cell_size, cell_14x_14y.getY() + 1f * cell_size)));


		int challengersCount = cfg_world.getCountChallengers();


		while (challengersCount > 0) {

			RectF challengerEnvelop = new RectF(cell_center_key.getX(), cell_center_key.getY(), cell_center_key.getX() + CHARACTER_FILL_PERCENT * cell_size, cell_center_key.getY() + CHARACTER_FILL_PERCENT * cell_size);
			Entity2D_Challenger challengerEntity = new Entity2D_Challenger_Labyrinth(world, challengerEnvelop, world.getGroundEntities_SolidOnly(), world.getKillersEntities_forChallengers());
			world.addEntity(challengerEntity);
			challengersCount--;
			if (challengersCount <= 0) break;

			challengerEnvelop = new RectF(cell_bottom_right.getX(), cell_bottom_right.getY(), cell_bottom_right.getX() + CHARACTER_FILL_PERCENT * cell_size, cell_bottom_right.getY() + CHARACTER_FILL_PERCENT * cell_size);
			challengerEntity = new Entity2D_Challenger_Labyrinth(world, challengerEnvelop, world.getGroundEntities_SolidOnly(), world.getKillersEntities_forChallengers());
			world.addEntity(challengerEntity);
			challengersCount--;
			if (challengersCount <= 0) break;

			challengerEnvelop = new RectF(cell_top_right.getX(), cell_top_right.getY(), cell_top_right.getX() + CHARACTER_FILL_PERCENT * cell_size, cell_top_right.getY() + CHARACTER_FILL_PERCENT * cell_size);
			challengerEntity = new Entity2D_Challenger_Labyrinth(world, challengerEnvelop, world.getGroundEntities_SolidOnly(), world.getKillersEntities_forChallengers());
			world.addEntity(challengerEntity);
			challengersCount--;
			if (challengersCount <= 0) break;

			challengerEnvelop = new RectF(cell_bottom_left.getX(), cell_bottom_left.getY(), cell_bottom_left.getX() + CHARACTER_FILL_PERCENT * cell_size, cell_bottom_left.getY() + CHARACTER_FILL_PERCENT * cell_size);
			challengerEntity = new Entity2D_Challenger_Labyrinth(world, challengerEnvelop, world.getGroundEntities_SolidOnly(), world.getKillersEntities_forChallengers());
			world.addEntity(challengerEntity);
			challengersCount--;
			if (challengersCount <= 0) break;
		}


		for (Entity2D_Moving moving: world.getMovingEntities()) {

			moving.setWorldSize(world.get_WORLD_SIZE_X(), world.get_WORLD_SIZE_Y());
		}


		return world;
	}


	private static Entity2D_Base getGroundEntity(List<Entity2D_Base> entities, float x, float y) {

		Entity2D_Base result = null;

		for (Entity2D_Base cur: entities) {

			if (result == null) {
				result = cur;
				continue;
			}

			float distance_cur = (float) Math.sqrt(Math.pow(Math.abs(x - cur.getX()), 2) + Math.pow(Math.abs(y - cur.getY()), 2));
			float distance_result = (float) Math.sqrt(Math.pow(Math.abs(x - result.getX()), 2) + Math.pow(Math.abs(y - result.getY()), 2));
			if (distance_cur < distance_result) {
				result = cur;
			}
		}

		return result;
	}}

	