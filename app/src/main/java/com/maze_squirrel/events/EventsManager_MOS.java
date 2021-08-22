package com.maze_squirrel.events;


import java.util.concurrent.ExecutorService;

import android.app.Activity;
import android.content.Context;

import com.apps.mobile.android.commons.achievements.IAchievementsManager;
import com.apps.mobile.android.commons.analytics.IAnalytics;
import com.apps.mobile.android.commons.app.Application_Base;
import com.apps.mobile.android.commons.cfg.achievements.IConfigurationAchievements;
import com.apps.mobile.android.commons.events.EventsManager_Base;
import com.apps.mobile.android.commons.events.api.IEvent_Base;
import com.apps.mobile.android.commons.graphics2d.model.GameData;
import com.apps.mobile.android.commons.graphics2d.model.UserSettings;
import com.apps.mobile.android.commons.model.GameData_Base;
import com.apps.mobile.android.commons.model.UserSettings_Base;
import com.maze_squirrel.achievements.AchievementsManager_MOS;


public class EventsManager_MOS extends EventsManager_Base {
	
	
	private IAchievementsManager achievementsManager;
	
	
	public EventsManager_MOS(ExecutorService _executor, IAnalytics _analytics, IAchievementsManager _achievementsManager) {
		
		super(_executor, _analytics);
		
		achievementsManager = _achievementsManager;
	}
	
	
	@Override
	public void handleGameEvents_OnFinish(Activity activity, GameData_Base data1, UserSettings_Base settings1, int gameStatus) {
		
		System.out.println("EventsManager_MOS/handleGameEvents_OnFinish: " + "called");
		
		if (data1.isCountedAsCompleted()) {
			System.out.println("EventsManager_MOS/handleGameEvents_OnFinish: " + "game is already counted");
			return;			
		}
		
		
		super.handleGameEvents_OnFinish(activity, data1, settings1, gameStatus);
		
		
		GameData data = (GameData) data1;
		UserSettings settings = (UserSettings) settings1;
		
		int steps = data.total_count_steps;
		if (steps > settings.best_scores) {
			
			settings.best_scores = steps;
			
			Application_Base.getInstance().storeUserSettings();
		}
		
		
		if (steps >= 100000) {
			register(activity, create(IEvent_Base.WIN_GAME, IEvent_MOS.WIN_GAME_STARS_100000, "WIN_GAME", "STARS_100000"));
		} 
		
		if (steps >= 75000) {
			register(activity, create(IEvent_Base.WIN_GAME, IEvent_MOS.WIN_GAME_STARS_75000, "WIN_GAME", "STARS_75000"));
		} 
		
		if (steps >= 50000) {
			register(activity, create(IEvent_Base.WIN_GAME, IEvent_MOS.WIN_GAME_STARS_50000, "WIN_GAME", "STARS_50000"));
		}
		
		if (steps >= 25000) {
			register(activity, create(IEvent_Base.WIN_GAME, IEvent_MOS.WIN_GAME_STARS_25000, "WIN_GAME", "STARS_25000"));
		}
		
		
		if (steps >= 10000) {
			register(activity, create(IEvent_Base.WIN_GAME, IEvent_MOS.WIN_GAME_STARS_10000, "WIN_GAME", "STARS_10000"));
		}
		
		if (steps >= 7500) {
			register(activity, create(IEvent_Base.WIN_GAME, IEvent_MOS.WIN_GAME_STARS_7500, "WIN_GAME", "STARS_7500"));
		}
		
		if (steps >= 5000) {
			register(activity, create(IEvent_Base.WIN_GAME, IEvent_MOS.WIN_GAME_STARS_5000, "WIN_GAME", "STARS_5000"));
		}
		
		if (steps >= 2500) {
			register(activity, create(IEvent_Base.WIN_GAME, IEvent_MOS.WIN_GAME_STARS_2500, "WIN_GAME", "STARS_2500"));
		}
		
		
		if (steps >= 1000) {
			register(activity, create(IEvent_Base.WIN_GAME, IEvent_MOS.WIN_GAME_STARS_1000, "WIN_GAME", "STARS_1000"));
		}
		
		if (steps >= 750) {
			register(activity, create(IEvent_Base.WIN_GAME, IEvent_MOS.WIN_GAME_STARS_750, "WIN_GAME", "STARS_750"));
		}
		
		if (steps >= 500) {
			register(activity, create(IEvent_Base.WIN_GAME, IEvent_MOS.WIN_GAME_STARS_500, "WIN_GAME", "STARS_500"));
		}
		
		if (steps >= 250) {
			register(activity, create(IEvent_Base.WIN_GAME, IEvent_MOS.WIN_GAME_STARS_250, "WIN_GAME", "STARS_250"));
		}
	}
	
	
	@Override
	protected void handleAchievements(Context context, IEvent_Base event) {
		
		
		super.handleAchievements(context, event);
		
		
		if (event.getID() == IEvent_Base.MARKETING && event.getSubID() == IEvent_Base.MARKETING_INVITE_FRIENDS_CLICKED) {
			
			achievementsManager.inc(context, IConfigurationAchievements.CFG_ACHIEVEMENT_INVITE_3_FRIENDS);
			
		} else if (event.getID() == IEvent_Base.MENU_OPERATION) {
			
			if (event.getSubID() == IEvent_Base.MENU_OPERATION_CHANGE_COLOURS) {
				achievementsManager.inc(context, IConfigurationAchievements.CFG_ACHIEVEMENT_CHANGE_COLOURS);
				
			}
			
		} else if (event.getID() == IEvent_Base.LOADING && event.getSubID() == IEvent_Base.LOADING_STOPPED_PIECES) {
			
			achievementsManager.inc(context, IConfigurationAchievements.CFG_ACHIEVEMENT_STOP_PIECES);
			
		} else if (event.getID() == IEvent_Base.WIN_GAME) {
			
			if (event.getSubID() == IEvent_MOS.WIN_GAME_STARS_250) {
				achievementsManager.inc(context, AchievementsManager_MOS.IDS_MAKE_STARS_250);	
			} else if (event.getSubID() == IEvent_MOS.WIN_GAME_STARS_500) {
				achievementsManager.inc(context, AchievementsManager_MOS.IDS_MAKE_STARS_500);
			} else if (event.getSubID() == IEvent_MOS.WIN_GAME_STARS_750) {
				achievementsManager.inc(context, AchievementsManager_MOS.IDS_MAKE_STARS_750);
			} else if (event.getSubID() == IEvent_MOS.WIN_GAME_STARS_1000) {
				achievementsManager.inc(context, AchievementsManager_MOS.IDS_MAKE_STARS_1000);
								
			} else if (event.getSubID() == IEvent_MOS.WIN_GAME_STARS_2500) {
				achievementsManager.inc(context, AchievementsManager_MOS.IDS_MAKE_STARS_2500);	
			} else if (event.getSubID() == IEvent_MOS.WIN_GAME_STARS_5000) {
				achievementsManager.inc(context, AchievementsManager_MOS.IDS_MAKE_STARS_5000);
			} else if (event.getSubID() == IEvent_MOS.WIN_GAME_STARS_7500) {
				achievementsManager.inc(context, AchievementsManager_MOS.IDS_MAKE_STARS_7500);
			} else if (event.getSubID() == IEvent_MOS.WIN_GAME_STARS_10000) {
				achievementsManager.inc(context, AchievementsManager_MOS.IDS_MAKE_STARS_10000);

			} else if (event.getSubID() == IEvent_MOS.WIN_GAME_STARS_25000) {
				achievementsManager.inc(context, AchievementsManager_MOS.IDS_MAKE_STARS_25000);	
			} else if (event.getSubID() == IEvent_MOS.WIN_GAME_STARS_50000) {
				achievementsManager.inc(context, AchievementsManager_MOS.IDS_MAKE_STARS_50000);
			} else if (event.getSubID() == IEvent_MOS.WIN_GAME_STARS_75000) {
				achievementsManager.inc(context, AchievementsManager_MOS.IDS_MAKE_STARS_75000);
			} else if (event.getSubID() == IEvent_MOS.WIN_GAME_STARS_100000) {
				achievementsManager.inc(context, AchievementsManager_MOS.IDS_MAKE_STARS_100000);
			} else {
				//Do nothing
			}
			
		} else {
			
		}
	}
	
	
	@Override
	public void init(final Application_Base app_context) {
		
		
		super.init(app_context);
		
		
		//Notifications processor
		executor.submit(new Runnable() {
			
			@Override
			public void run() {
				
				//While TRUE Cycle is inside the method checkNotifications
				achievementsManager.checkNotifications(app_context);
			}
		});
	}
}
