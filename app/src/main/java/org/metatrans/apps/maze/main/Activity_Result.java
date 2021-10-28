package org.metatrans.apps.maze.main;


import org.metatrans.apps.maze.app.Application_Maze;
import org.metatrans.apps.maze.lib.R;
import org.metatrans.apps.maze.model.UserSettings;
import org.metatrans.commons.ads.api.IAdsConfiguration;
import org.metatrans.commons.graphics2d.main.Activity_Result_Base2D;
import org.metatrans.commons.graphics2d.model.GameData;
import org.metatrans.commons.main.View_Result;


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
