package org.metatrans.apps.maze.main;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import org.metatrans.apps.maze.app.Application_Maze;
import org.metatrans.apps.maze.menu.Activity_Menu_Main;
import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.app.Application_Base_Ads;
import org.metatrans.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatrans.commons.cfg.colours.IConfigurationColours;
import org.metatrans.commons.graphics2d.main.Activity_Main_Base2D;
import org.metatrans.commons.graphics2d.ui.View_Main_4Controls_4Fire;
import org.metatrans.commons.ui.TextArea;
import org.metatrans.commons.ui.utils.DrawingUtils;
import org.metatrans.commons.ui.utils.ScreenUtils;


public class View_Main_4Controls_4Fire_Labyrints extends View_Main_4Controls_4Fire {

	
	private Paint default_paint;
	
	private RectF rect_level;
	private RectF rect_level_icon;
	private RectF rect_level_text;
	
	private RectF rect_lives;
	private RectF rect_lives_icon;
	private RectF rect_lives_text;
	
	private RectF rect_key;
	private RectF rect_key_icon;
	private RectF rect_key_text;
	
	private RectF rect_stars;
	private RectF rect_stars_icon;
	private RectF rect_stars_text;
	
	private RectF rect_bullets;
	private RectF rect_bullets_icon;
	private RectF rect_bullets_text;
	
	private RectF rect_steps;
	private RectF rect_steps_icon;
	private RectF rect_steps_text;
	
	
	private TextArea textarea_level;
	private TextArea textarea_lives;
	private TextArea textarea_key;
	private TextArea textarea_stars;
	private TextArea textarea_bullets;
	private TextArea textarea_steps;
	
	
	public View_Main_4Controls_4Fire_Labyrints(Activity_Main_Base2D activity) {
		
		super(activity);

		default_paint = new Paint();
		
		int cell_size = (int) getWorld().getCellSize();
		
		int height_icon = (int) ((6.5f * cell_size) / 10f);
		int height_text = (int) ((6.5f * cell_size) / 10f);
		int start_y = (int) ((1.0f * cell_size) / 33f);
		
		int width = (int) (1.33f * height_icon);
		int width_icon = height_icon;
		int interval_x = cell_size / 3;
		
		float extend_factor_bullets = 1.1f;
		float extend_factor_steps 	= 1.35f;
		
		int[] screen_size = ScreenUtils.getScreenSize((Activity) getContext());
		int screen_width = Math.max(screen_size[0], screen_size[1]);
		int start_x = (int) ((screen_width - 5 * interval_x - 4 * width - extend_factor_bullets * width - extend_factor_steps * width) / 2f);

		start_x = (int) (start_x / 1.5f);

		int border_icon = start_y;
		int border_text = 3;
		
		rect_level			= new RectF(start_x, start_y, start_x + extend_factor_bullets * width + 8 * border_text, start_y + height_text);
		rect_level_icon		= new RectF(start_x + border_icon, 	start_y + border_icon, start_x + width_icon - border_icon,start_y + height_text - border_icon);
		rect_level_text		= new RectF(rect_level_icon.right,start_y + border_text, rect_level.right, start_y + border_text + height_icon);
		
		rect_lives 			= new RectF(rect_level.right + interval_x, start_y, rect_level.right + interval_x + width + 8 * border_text, start_y + height_text);
		rect_lives_icon 	= new RectF(rect_level.right + interval_x + border_icon, start_y + border_icon, rect_level.right + interval_x + width_icon - border_icon, start_y + height_text - border_icon);
		rect_lives_text		= new RectF(rect_lives_icon.right, start_y + border_text, rect_lives.right,start_y  + border_text + height_icon);
		
		rect_key 			= new RectF(rect_lives.right + interval_x, start_y, rect_lives.right + interval_x + width + 8 * border_text,start_y + height_text);
		rect_key_icon 		= new RectF(rect_lives.right + interval_x + border_icon,start_y + border_icon, rect_lives.right + interval_x + width_icon - border_icon, 	start_y + height_text - border_icon);
		rect_key_text 		= new RectF(rect_key_icon.right,	start_y + border_text, rect_key.right,start_y  + border_text + height_icon);
		
		rect_stars 			= new RectF(rect_key.right + interval_x, start_y, rect_key.right + interval_x + width + 8 * border_text,start_y + height_text);
		rect_stars_icon 	= new RectF(rect_key.right + interval_x + border_icon,start_y + border_icon, rect_key.right + interval_x + width_icon - border_icon, 		start_y + height_text - border_icon);
		rect_stars_text 	= new RectF(rect_stars_icon.right, start_y + border_text, rect_stars.right,start_y  + border_text + height_icon);
		
		rect_bullets 		= new RectF(rect_stars.right + interval_x, start_y, rect_stars.right + interval_x + extend_factor_bullets * width + 8 * border_text,	start_y + height_text);
		rect_bullets_icon 	= new RectF(rect_stars.right + interval_x + border_icon, start_y + border_icon, rect_stars.right + interval_x + width_icon - border_icon, start_y + height_text - border_icon);
		rect_bullets_text 	= new RectF(rect_bullets_icon.right, start_y + border_text, rect_bullets.right,start_y  + border_text + height_icon);
		
		rect_steps 			= new RectF(rect_bullets.right + interval_x, start_y, rect_bullets.right + interval_x + extend_factor_steps * width + 8 * border_text,start_y + height_text);
		rect_steps_icon		= new RectF(rect_bullets.right + interval_x + border_icon,	start_y + border_icon, rect_bullets.right + interval_x + width_icon - border_icon, start_y + height_text - border_icon);
		rect_steps_text		= new RectF(rect_steps_icon.right,start_y + border_text, rect_steps.right,	start_y  + border_text + height_icon);


		IConfigurationColours coloursCfg = ConfigurationUtils_Colours.getConfigByID(Application_Maze.getInstance().getUserSettings().uiColoursID);

		textarea_level 		= new TextArea(rect_level_text, 	true, "00", 	coloursCfg.getColour_Square_White(), Color.GREEN);
		textarea_lives 		= new TextArea(rect_lives_text, 	true, "x0", 	coloursCfg.getColour_Square_White(), Color.GREEN);
		textarea_key   		= new TextArea(rect_key_text, 		true, "x0", 	coloursCfg.getColour_Square_White(), Color.GREEN);
		textarea_stars		= new TextArea(rect_stars_text, 	true, "x0", 	coloursCfg.getColour_Square_White(), Color.GREEN);
		textarea_bullets 	= new TextArea(rect_bullets_text, 	true, "x00", 	coloursCfg.getColour_Square_White(), Color.GREEN);
		textarea_steps 		= new TextArea(rect_steps_text, 	true,"x0000",	coloursCfg.getColour_Square_White(), Color.GREEN);
	}
	
	
	public Class getMainMenuClass() {
		return Activity_Menu_Main.class;
	}
	
	
	@Override
	protected Bitmap getBitmapControl_Player() {

		World_Labyrints world = (World_Labyrints) Application_Maze.getInstance().getGameData().world;

		return world.getBitmap_player_r();
	}
	
	
	@Override
	protected Bitmap getBitmapControl_Shot() {

		World_Labyrints world = (World_Labyrints) Application_Maze.getInstance().getGameData().world;

		return world.getBitmap_acorn();
	}
	
	
	@Override
	public void onDraw(Canvas canvas) {
		
		
		super.onDraw(canvas);


		IConfigurationColours coloursCfg = ConfigurationUtils_Colours.getConfigByID(Application_Maze.getInstance().getUserSettings().uiColoursID);


		int text_background = coloursCfg.getColour_Delimiter();

		default_paint.setColor(text_background);

		DrawingUtils.drawRoundRectangle(canvas, default_paint, rect_level, 33);
		DrawingUtils.drawRoundRectangle(canvas, default_paint, rect_lives, 33);
		DrawingUtils.drawRoundRectangle(canvas, default_paint, rect_key, 33);
		DrawingUtils.drawRoundRectangle(canvas, default_paint, rect_stars, 33);
		DrawingUtils.drawRoundRectangle(canvas, default_paint, rect_bullets, 33);
		DrawingUtils.drawRoundRectangle(canvas, default_paint, rect_steps, 33);


		int text_color1 = coloursCfg.getColour_Square_ValidSelection(); //coloursCfg.getColour_Delimiter(); //Color.BLACK
		int text_color2 = coloursCfg.getColour_Square_InvalidSelection(); //Color.RED;
		int text_color3 = coloursCfg.getColour_Square_MarkingSelection(); //Color.BLUE;

		int level = Application_Maze.getInstance().getUserSettings().modeID;
		canvas.drawBitmap(Application_Maze.getInstance().getWorld().getBitmap_level(), null, rect_level_icon, default_paint);
		textarea_level.setColour_Text(text_color3);
		textarea_level.setText("" + level + "");
		textarea_level.draw(canvas);
		
		
		int lives = Application_Maze.getInstance().getGameData().count_lives;
		canvas.drawBitmap(Application_Maze.getInstance().getWorld().getBitmap_player_l(), null, rect_lives_icon, default_paint);
		textarea_lives.setColour_Text(lives == 0 ? text_color2 : text_color1);
		textarea_lives.setText("x" + lives + "");
		textarea_lives.draw(canvas);
		
		
		boolean hasKey = Application_Maze.getInstance().getGameData().world.getPlayerEntity().hasKey();
		canvas.drawBitmap(Application_Maze.getInstance().getWorld().getBitmap_key(), null, rect_key_icon, default_paint);
		textarea_key.setColour_Text(hasKey ? text_color1 : text_color2);
		textarea_key.setText("x" + (hasKey ? "1" : "0") + "");
		textarea_key.draw(canvas);
		
		
		int stars = Application_Maze.getInstance().getGameData().count_stars;
		canvas.drawBitmap(Application_Maze.getInstance().getWorld().getBitmap_star(), null, rect_stars_icon, default_paint);
		textarea_stars.setColour_Text(stars == 0 ? text_color2 : text_color1);
		textarea_stars.setText("x" + stars + "");
		textarea_stars.draw(canvas);
		
		
		int bullets = Application_Maze.getInstance().getGameData().count_bullets;
		canvas.drawBitmap(Application_Maze.getInstance().getWorld().getBitmap_acorn(), null, rect_bullets_icon, default_paint);
		textarea_bullets.setColour_Text(bullets == 0 ? text_color2 : text_color1);
		textarea_bullets.setText("x" + bullets + "");
		textarea_bullets.draw(canvas);
		
		
		int steps = Application_Maze.getInstance().getGameData().total_count_steps + Application_Maze.getInstance().getGameData().count_steps;
		canvas.drawBitmap(Application_Maze.getInstance().getWorld().getBitmap_paw(), null, rect_steps_icon, default_paint);
		textarea_steps.setColour_Text(text_color1);
		textarea_steps.setText("x" + steps + "");
		textarea_steps.draw(canvas);
	}
}
