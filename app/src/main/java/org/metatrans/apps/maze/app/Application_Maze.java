package org.metatrans.apps.maze.app;


import org.metatrans.apps.maze.achievements.AchievementsManager_MOS;
import org.metatrans.apps.maze.cfg.world.ConfigurationUtils_Level;
import org.metatrans.apps.maze.events.EventsManager_MOS;
import org.metatrans.apps.maze.lib.BuildConfig;
import org.metatrans.apps.maze.main.Activity_Result;
import org.metatrans.apps.maze.model.UserSettings;
import org.metatrans.apps.maze.model.WorldGenerator_Labyrints;
import org.metatrans.apps.maze.model.World_Labyrints;
import org.metatrans.commons.achievements.IAchievementsManager;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.app.Application_Base_Ads;
import org.metatrans.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatrans.commons.cfg.menu.ConfigurationUtils_Base_MenuMain;
import org.metatrans.commons.engagement.ILeaderboardsProvider;
import org.metatrans.commons.engagement.leaderboards.LeaderboardsProvider_Base;
import org.metatrans.commons.events.api.IEventsManager;
import org.metatrans.commons.graphics2d.app.Application_2D_Base;
import org.metatrans.commons.graphics2d.model.GameData;
import org.metatrans.commons.graphics2d.model.IWorld;
import org.metatrans.commons.model.UserSettings_Base;
import org.metatrans.commons.ui.utils.DebugUtils;


public abstract class Application_Maze extends Application_2D_Base {

	
	private static final String[] KEYWORDS = new String[] {"org.metatrans.apps.maze", "labyrinths", "squirrel", "escape"};
	
	
	@Override
	public void onCreate() {

		ConfigurationUtils_Level.createInstance();

		super.onCreate();
		//Called when the application is starting, before any other application objects have been created.
		
		System.out.println("Application_EC: onCreate called " + System.currentTimeMillis());
		
		ConfigurationUtils_Colours.class.getName();
		
		ConfigurationUtils_Base_MenuMain.createInstance();

		//Handle incompatible changes in the model classes
		/*try {

			GameData game_data = (GameData) StorageUtils.readStorage(this, GameData_Base.FILE_NAME_GAME_DATA);

			if (game_data != null && game_data.model_version == GameData.MODEL_VERSION_1) {

				StorageUtils.clearStore(this, GameData_Base.FILE_NAME_GAME_DATA);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}*/
	}


	public World_Labyrints getWorld() {
		return (World_Labyrints) ((GameData) getInstance().getGameData()).world;
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

		return new EventsManager_MOS(getExecutor(), getAchievementsManager());
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
