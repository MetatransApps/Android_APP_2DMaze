package com.maze_squirrel.loading;


import org.metatransapps.commons.Activity_Base;
import org.metatransapps.commons.ads.api.IAdsConfiguration;
import org.metatransapps.commons.app.Application_Base_Ads;
import org.metatransapps.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatransapps.commons.cfg.colours.IConfigurationColours;
import org.metatransapps.commons.loading.View_Loading_Base;

import com.maze_squirrel.lib.R;
import com.maze_squirrel.app.Application_Maze;
import com.maze_squirrel.main.Activity_Main;
import com.maze_squirrel.menu.Activity_Menu_Levels;


public class Activity_Loading extends org.metatransapps.commons.loading.Activity_Loading_Base_Ads {
	
	
	@Override
	protected void load() {
		
		try {
			Application_Maze.getInstance().getGameData();
		} catch(Exception e) {
			e.printStackTrace();
			Application_Maze.getInstance().recreateGameDataObject();
		}
	}
	
	
	@Override
	protected Class<? extends Activity_Base> getNextActivityClass() {
		return Activity_Main.class;
	}
	
	
	@Override
	protected Class<? extends Activity_Base> getActivityClass_Menu2() {
		return Activity_Menu_Levels.class;
	}
	
	
	@Override
	protected int getText_Menu2() {
		return R.string.levels;
	}
	
	
	@Override
	protected String getBannerName() {
		return IAdsConfiguration.AD_ID_BANNER1;
	}
	
	
	@Override
	protected String getInterstitialName() {
		return IAdsConfiguration.AD_ID_INTERSTITIAL1;
	}
	
	
	@Override
	protected View_Loading_Base getLoadingView() {
		View_Loading view = new View_Loading(this, ((Application_Base_Ads)getApplication()).getUserSettings());
		return view;
	}
	
	
	@Override
	protected IConfigurationColours getColoursCfg() {
		IConfigurationColours coloursCfg = ConfigurationUtils_Colours.getConfigByID(((Application_Base_Ads)getApplication()).getUserSettings().uiColoursID);
		return coloursCfg;
	}
}
