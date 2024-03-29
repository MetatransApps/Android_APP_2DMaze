package org.metatrans.apps.maze.menu;


import java.util.ArrayList;
import java.util.List;

import org.metatrans.apps.maze.cfg.world.ConfigurationUtils_Level;
import org.metatrans.apps.maze.lib.R;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.menu.Config_MenuMain_Base;
import org.metatrans.commons.cfg.menu.Config_MenuMain_Melody;
import org.metatrans.commons.cfg.menu.IConfigurationMenu_Main;
import org.metatrans.commons.cfg.sound.Config_MenuMain_Sound;
import org.metatrans.commons.graphics2d.menu.Activity_Menu_Joystick;
import org.metatrans.commons.graphics2d.menu.ConfigurationUtils_Joysticks;
import org.metatrans.commons.graphics2d.model.UserSettings;
import org.metatrans.commons.menu.Activity_Menu_Main_Base;

import android.app.Activity;
import android.content.Intent;


public class Activity_Menu_Main extends Activity_Menu_Main_Base {


	public static int CFG_MENU_LEVELS			 		= 15;
	public static int CFG_MENU_JOYSTICK			 		= 16;
	public static int CFG_MENU_RESULT			 		= 17;
	public static int CFG_MENU_ACHIEVEMENTS		 		= 18;
	public static int CFG_MENU_STOP_ADS		 			= 29;

	@Override
	protected int getBackgroundImageID() {
		return 0;
	}


	@Override
	protected List<IConfigurationMenu_Main> getEntries() {


		List<IConfigurationMenu_Main> result = new ArrayList<IConfigurationMenu_Main>();

		result.add(new Config_MenuMain_Base() {
			
			@Override
			public int getName() {
				return R.string.levels;
			}
			
			@Override
			public int getIconResID() {
				return R.drawable.ic_level;
			}
			
			@Override
			public int getID() {
				return CFG_MENU_LEVELS;
			}
			
			@Override
			public String getDescription_String() {
				return ConfigurationUtils_Level.getInstance().getConfigByID(Application_Base.getInstance().getUserSettings().modeID).getName_String();
			}
			
			@Override
			public Runnable getAction() {
				
				return new Runnable() {
					
					@Override
					public void run() {
						Activity currentActivity = Application_Base.getInstance().getCurrentActivity();
						if (currentActivity != null) {
							
							currentActivity.finish();
							
							Intent i = new Intent(currentActivity, Activity_Menu_Levels.class);
							currentActivity.startActivity(i);
						}
					}
				};
			}
		});


		result.add(new Config_MenuMain_Base() {

			@Override
			public int getName() {
				return R.string.menu_joystick;
			}

			@Override
			public int getIconResID() {
				return R.drawable.joystick_transparent;
			}

			@Override
			public int getID() {
				return CFG_MENU_JOYSTICK;
			}

			@Override
			public String getDescription_String() {
				return ConfigurationUtils_Joysticks.getConfigByID(((UserSettings)((Application_Base) getApplication()).getUserSettings()).movejoystick_side).getName_String();
			}

			@Override
			public Runnable getAction() {

				return new Runnable() {

					@Override
					public void run() {
						Activity currentActivity = Application_Base.getInstance().getCurrentActivity();

						if (currentActivity != null) {

							currentActivity.finish();

							Intent i = new Intent(currentActivity, Activity_Menu_Joystick.class);
							currentActivity.startActivity(i);
						}
					}
				};
			}
		});


		if (getRewardedVideoName() != null) {
			result.add(new Config_MenuMain_Base() {

				@Override
				public int getName() {
					return R.string.new_stopads_title;
				}

				@Override
				public int getIconResID() {
					return R.drawable.ic_action_tv;
				}

				@Override
				public int getID() {
					return CFG_MENU_STOP_ADS;
				}

				@Override
				public String getDescription_String() {
					return getString(R.string.new_stopads_desc);
				}

				@Override
				public Runnable getAction() {

					return new Runnable() {

						@Override
						public void run() {

							Activity_Menu_Main.this.openRewardedVideo();
						}
					};
				}
			});
		}


		result.add(new Config_MenuMain_Sound());


		if (Application_Base.getInstance().supportMelodies()) {

			result.add(new Config_MenuMain_Melody());
		}


		result.add(new Config_MenuMain_Base() {

			@Override
			public int getName() {
				return R.string.scores;
			}

			@Override
			public int getIconResID() {
				return R.drawable.ic_123;
			}

			@Override
			public int getID() {
				return CFG_MENU_RESULT;
			}

			@Override
			public String getDescription_String() {
				return "";
			}

			@Override
			public Runnable getAction() {

				return new Runnable() {

					@Override
					public void run() {

						int modeID = Application_Base.getInstance().getUserSettings().modeID;

						Application_Base.getInstance().getEngagementProvider().getLeaderboardsProvider().openLeaderboard_LocalOnly(modeID);

						Application_Base.getInstance().getEngagementProvider().getLeaderboardsProvider().openLeaderboard(modeID);
					}
				};
			}
		});


		result.add(new Config_MenuMain_Base() {

			@Override
			public int getName() {
				return R.string.achievements;
			}

			@Override
			public int getIconResID() {
				return org.metatrans.commons.R.drawable.ic_cup;
			}

			@Override
			public int getID() {
				return CFG_MENU_ACHIEVEMENTS;
			}

			@Override
			public String getDescription_String() {
				return "";
			}

			@Override
			public Runnable getAction() {

				return new Runnable() {

					@Override
					public void run() {

						Application_Base.getInstance().getEngagementProvider().getAchievementsProvider().openAchievements();
					}
				};
			}
		});


		List<IConfigurationMenu_Main> entries = super.getEntries();


		result.addAll(entries);


		return result;
	}
}
