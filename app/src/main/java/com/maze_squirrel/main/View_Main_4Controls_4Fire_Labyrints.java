package com.maze_squirrel.main;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import org.metatrans.commons.graphics2d.main.Activity_Main_Base2D;
import org.metatrans.commons.graphics2d.ui.View_Main_4Controls_4Fire;
import org.metatrans.commons.ui.TextArea;
import org.metatrans.commons.ui.utils.BitmapUtils;
import org.metatrans.commons.ui.utils.ScreenUtils;

import com.maze_squirrel.lib.R;
import com.maze_squirrel.app.Application_Maze;
import com.maze_squirrel.menu.Activity_Menu_Main;
import com.maze_squirrel.model.World_Labyrints;


public class View_Main_4Controls_4Fire_Labyrints extends View_Main_4Controls_4Fire {
	
	
	private Bitmap control_player;
	private Bitmap control_shot;
	
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
		
		control_player = BitmapUtils.fromResource(activity, R.drawable.ic_control_squirrel);
		control_shot = BitmapUtils.fromResource(activity, 	R.drawable.ic_control_acorn);
		
		default_paint = new Paint();
		
		int cell_size = (int) getWorld().getCellSize();
		
		int height = (int) ((8.0f * cell_size) / 10f);
		int start_y = (int) ((1.0f * cell_size) / 10f);
		
		int width = (int) (1.7f * height);
		int width_icon = height;
		int interval_x = cell_size / 3;
		
		float extend_factor_bullets = 1.1f;
		float extend_factor_steps 	= 1.35f;
		
		int[] screen_size = ScreenUtils.getScreenSize((Activity) getContext());
		int screen_width = Math.max(screen_size[0], screen_size[1]);
		int start_x = (int) ((screen_width - 5 * interval_x - 4 * width - extend_factor_bullets * width - extend_factor_steps * width) / 2f);
		
		int border_icon = start_y;
		
		
		rect_level			= new RectF(start_x, 										start_y, start_x + width, 															start_y + height);
		rect_level_icon		= new RectF(start_x + border_icon, 							start_y + border_icon, start_x + width_icon - border_icon, 							start_y + height - border_icon);
		rect_level_text		= new RectF(rect_level_icon.right, 							start_y, rect_level.right, 															start_y + height);
		
		rect_lives 			= new RectF(rect_level.right + interval_x, 					start_y, rect_level.right + interval_x + width, 									start_y + height);
		rect_lives_icon 	= new RectF(rect_level.right + interval_x + border_icon, 	start_y + border_icon, rect_level.right + interval_x + width_icon - border_icon, 	start_y + height - border_icon);
		rect_lives_text		= new RectF(rect_lives_icon.right, 							start_y, rect_lives.right, 															start_y + height);
		
		rect_key 			= new RectF(rect_lives.right + interval_x, 					start_y, rect_lives.right + interval_x + width, 									start_y + height);
		rect_key_icon 		= new RectF(rect_lives.right + interval_x + border_icon, 	start_y + border_icon, rect_lives.right + interval_x + width_icon - border_icon, 	start_y + height - border_icon);
		rect_key_text 		= new RectF(rect_key_icon.right,							start_y, rect_key.right,						 									start_y + height);
		
		rect_stars 			= new RectF(rect_key.right + interval_x, 					start_y, rect_key.right + interval_x + width, 										start_y + height);
		rect_stars_icon 	= new RectF(rect_key.right + interval_x + border_icon, 		start_y + border_icon, rect_key.right + interval_x + width_icon - border_icon, 		start_y + height - border_icon);
		rect_stars_text 	= new RectF(rect_stars_icon.right, 							start_y, rect_stars.right,					 										start_y + height);
		
		rect_bullets 		= new RectF(rect_stars.right + interval_x, 					start_y, rect_stars.right + interval_x + extend_factor_bullets * width,				start_y + height);
		rect_bullets_icon 	= new RectF(rect_stars.right + interval_x + border_icon,	start_y + border_icon, rect_stars.right + interval_x + width_icon - border_icon, 	start_y + height - border_icon);
		rect_bullets_text 	= new RectF(rect_bullets_icon.right, 						start_y, rect_bullets.right,											 			start_y + height);
		
		rect_steps 			= new RectF(rect_bullets.right + interval_x, 				start_y, rect_bullets.right + interval_x + extend_factor_steps * width,				start_y + height);
		rect_steps_icon		= new RectF(rect_bullets.right + interval_x + border_icon,	start_y + border_icon, rect_bullets.right + interval_x + width_icon - border_icon, 	start_y + height - border_icon);
		rect_steps_text		= new RectF(rect_steps_icon.right,						 	start_y, rect_steps.right,															start_y + height);
		
		textarea_level 		= new TextArea(rect_level_text, 	"00 ", 		Color.GREEN);
		textarea_lives 		= new TextArea(rect_lives_text, 	"x 0 ", 	Color.GREEN);
		textarea_key   		= new TextArea(rect_key_text, 		"x 0 ", 	Color.GREEN);
		textarea_stars		= new TextArea(rect_stars_text, 	"x 0 ", 	Color.GREEN);
		textarea_bullets 	= new TextArea(rect_bullets_text, 	"x 00 ", 	Color.GREEN);
		textarea_steps 		= new TextArea(rect_steps_text, 	"x 0000 ", 	Color.GREEN);
	}
	
	
	public Class getMainMenuClass() {
		return Activity_Menu_Main.class;
	}
	
	
	@Override
	protected Bitmap getBitmapControl_Player() {
		return control_player;
	}
	
	
	@Override
	protected Bitmap getBitmapControl_Shot() {
		return control_shot;
	}
	
	
	@Override
	public void onDraw(Canvas canvas) {
		
		
		super.onDraw(canvas);
		
		
		//default_paint.setColor(((Application_Maze_S)Application_Maze_S.getInstance()).getColoursCfg().getColour_Background());
		default_paint.setColor(Color.BLACK);
		
		
		canvas.drawRect(rect_level, default_paint);
		canvas.drawRect(rect_lives, default_paint);
		canvas.drawRect(rect_key, default_paint);
		canvas.drawRect(rect_stars, default_paint);
		canvas.drawRect(rect_bullets, default_paint);
		canvas.drawRect(rect_steps, default_paint);
		
		
		int level = ((Application_Maze)Application_Maze.getInstance()).getUserSettings().modeID;
		canvas.drawBitmap(World_Labyrints.getBitmap_level(), null, rect_level_icon, default_paint);
		textarea_level.setColour_Text(Color.GREEN);
		textarea_level.setText("" + level + " ");
		textarea_level.draw(canvas);
		
		
		int lives = ((Application_Maze)Application_Maze.getInstance()).getGameData().count_lives;
		canvas.drawBitmap(World_Labyrints.getBitmap_player_l(), null, rect_lives_icon, default_paint);
		textarea_lives.setColour_Text(lives == 0 ? Color.RED : Color.GREEN);
		textarea_lives.setText("x " + lives + " ");
		textarea_lives.draw(canvas);
		
		
		boolean hasKey = ((Application_Maze)Application_Maze.getInstance()).getGameData().world.getPlayerEntity().hasKey();
		canvas.drawBitmap(World_Labyrints.getBitmap_key(), null, rect_key_icon, default_paint);
		textarea_key.setColour_Text(hasKey ? Color.GREEN : Color.RED);
		textarea_key.setText("x " + (hasKey ? "1" : "0") + " ");
		textarea_key.draw(canvas);
		
		
		int stars = ((Application_Maze)Application_Maze.getInstance()).getGameData().count_stars;
		canvas.drawBitmap(World_Labyrints.getBitmap_star(), null, rect_stars_icon, default_paint);
		textarea_stars.setColour_Text(stars == 0 ? Color.GRAY : Color.GREEN);
		textarea_stars.setText("x " + stars + " ");
		textarea_stars.draw(canvas);
		
		
		int bullets = ((Application_Maze)Application_Maze.getInstance()).getGameData().count_bullets;
		canvas.drawBitmap(World_Labyrints.getBitmap_acorn(), null, rect_bullets_icon, default_paint);
		textarea_bullets.setColour_Text(bullets == 0 ? Color.RED : Color.GREEN);
		textarea_bullets.setText("x " + bullets + " ");
		textarea_bullets.draw(canvas);
		
		
		int steps = ((Application_Maze)Application_Maze.getInstance()).getGameData().total_count_steps + ((Application_Maze) Application_Maze.getInstance()).getGameData().count_steps;
		canvas.drawBitmap(World_Labyrints.getBitmap_paw(), null, rect_steps_icon, default_paint);
		textarea_steps.setColour_Text(Color.GREEN);
		textarea_steps.setText("x " + steps + " ");
		textarea_steps.draw(canvas);
	}
}
