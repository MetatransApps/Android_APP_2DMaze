package com.maze_squirrel.app;


import com.apps.mobile.android.commons.achievements.IAchievementsManager;
import com.apps.mobile.android.commons.app.Application_Base;
import com.apps.mobile.android.commons.app.Application_Base_Ads;
import com.apps.mobile.android.commons.cfg.app.IAppConfig;
import com.apps.mobile.android.commons.cfg.colours.ConfigurationUtils_Colours;
import com.apps.mobile.android.commons.cfg.menu.ConfigurationUtils_Base_MenuMain;
import com.apps.mobile.android.commons.engagement.ILeaderboardsProvider;
import com.apps.mobile.android.commons.engagement.leaderboards.LeaderboardsProvider_Base;
import com.apps.mobile.android.commons.events.api.IEventsManager;
import com.apps.mobile.android.commons.graphics2d.app.Application_2D_Base;
import com.apps.mobile.android.commons.graphics2d.model.GameData;
import com.apps.mobile.android.commons.graphics2d.model.IWorld;
import com.apps.mobile.android.commons.model.UserSettings_Base;
import com.apps.mobile.android.commons.ui.utils.DebugUtils;
import com.maze_squirrel.lib.BuildConfig;
import com.maze_squirrel.achievements.AchievementsManager_MOS;
import com.maze_squirrel.cfg.app.AppConfig_MOS;
import com.maze_squirrel.cfg.world.ConfigurationUtils_Level;
import com.maze_squirrel.events.EventsManager_MOS;
import com.maze_squirrel.main.Activity_Result;
import com.maze_squirrel.model.UserSettings;
import com.maze_squirrel.model.WorldGenerator_Labyrints;


public abstract class Application_Maze extends Application_2D_Base {
	
	
	protected IAppConfig appConfig = new AppConfig_MOS();
	
	private static final String[] KEYWORDS = new String[] {"maze", "labyrinths", "squirrel", "escape"};
	
	
	@Override
	public void onCreate() {
		
		super.onCreate();
		//Called when the application is starting, before any other application objects have been created.
		
		System.out.println("Application_EC: onCreate called " + System.currentTimeMillis());
		
		ConfigurationUtils_Colours.class.getName();
		
		ConfigurationUtils_Level.createInstance();
		
		ConfigurationUtils_Base_MenuMain.createInstance();
	}
	
	
	@Override
	public IAppConfig getAppConfig() {
		return appConfig;
	}
	
	
	public String[] getKeywords() {
		return KEYWORDS;
	}
	
	
	@Override
	protected ILeaderboardsProvider createLeaderboardsProvider() {
		return new LeaderboardsProvider_Base(this, Activity_Result.class);
	}
	
	
	@Override
	public void setNextLevel() {
		getUserSettings().modeID = ConfigurationUtils_Level.getInstance().getNextConfigID(getUserSettings().modeID);
		Application_Base.getInstance().storeUserSettings();
	}
	
	
	@Override
	public IWorld createNewWorld() {
		 return WorldGenerator_Labyrints.generate(this, ConfigurationUtils_Level.getInstance().getConfigByID(Application_Base.getInstance().getUserSettings().modeID));
	}
	
	public static Application_Maze getInstance() {
		return (Application_Maze) Application_Base_Ads.getInstance();
	}
	
	
	@Override
	protected IAchievementsManager createAchievementsManager() {
		return new AchievementsManager_MOS(this);
	}
	
	
	@Override
	protected IEventsManager createEventsManager() {
		return new EventsManager_MOS(getExecutor(), getAnalytics(), getAchievementsManager());
	}
	
	
	@Override
	public GameData createGameDataObject() {
		
		System.out.println("GAMEDATA CREATE");
		
		GameData result = new GameData();
		
		int levelID = getUserSettings().modeID;
		result.world = WorldGenerator_Labyrints.generate(this, ConfigurationUtils_Level.getInstance().getConfigByID(levelID));
		
		result.timestamp_lastborn = System.currentTimeMillis();
		
		return result;
	}
	
	
	@Override
	protected UserSettings_Base createUserSettingsObject() {
		return new UserSettings();
	}
	
	
	@Override
	public boolean isTestMode() {
		boolean productiveMode = !BuildConfig.DEBUG || !DebugUtils.isDebuggable(this);
		return !productiveMode;
	}
}
