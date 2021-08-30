package com.maze_squirrel.main;


import org.metatransapps.commons.ads.api.IAdsConfiguration;
import org.metatransapps.commons.graphics2d.main.Activity_Result_Base2D;
import org.metatransapps.commons.graphics2d.model.GameData;
import org.metatransapps.commons.main.View_Result;

import com.maze_squirrel.lib.R;
import com.maze_squirrel.app.Application_Maze;
import com.maze_squirrel.model.UserSettings;


public class Activity_Result extends Activity_Result_Base2D {
	
	
	@Override
	public View_Result createView() {
		
		GameData gameGata = ((Application_Maze)getApplication()).getGameData();
		UserSettings settings = (UserSettings) ((Application_Maze)getApplication()).getUserSettings();

		View_Result view = new View_Result(this,
				gameGata.total_count_steps >= settings.best_scores, //new record
				false, //show mode
				null,//"All Levels", //mode name
				new String[] {getString(R.string.steps)},//, "l2", "l3"},
				new String[] {"" + gameGata.total_count_steps},//, "dy2", "dy3"},
				new String[] {"" + settings.best_scores}//, "db2", "db3"}
				);
		
		return view;
	}
	
	
	@Override
	protected String getBannerName() {
		return IAdsConfiguration.AD_ID_BANNER3;
	}
}
