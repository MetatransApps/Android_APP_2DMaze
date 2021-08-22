package com.maze_squirrel.cfg.world;


import com.apps.mobile.android.commons.cfg.ConfigurationUtils_Base;
import com.apps.mobile.android.commons.cfg.IConfigurationEntry;


public class ConfigurationUtils_Level extends ConfigurationUtils_Base {
	
	
	private static final String TAG_NAME = ConfigurationUtils_Level.class.getName();
	
	
	public static final int LEVEL_ID_DEFAULT = 1;
	
	
	public static ConfigurationUtils_Level getInstance() {
		return (ConfigurationUtils_Level) getInstance(TAG_NAME);
	}

	
	public static void createInstance() {
		

		float factor = 1.3f;
		
		/*IConfigurationEntry[] cfgs_levels = new IConfigurationEntry[] { 
			
			new Configuration_World(1, 0, 1),
			new Configuration_World(2, 1, 1),
			new Configuration_World(3, 2, 1),
			new Configuration_World(4, 3, 1),
			
			new Configuration_World(5, 0, (float) Math.pow(factor, 1)),
			new Configuration_World(6, (int) (1 * Math.floor(Math.pow(factor, 2))), (float) Math.pow(factor, 1)),
			new Configuration_World(7, (int) (2 * Math.floor(Math.pow(factor, 2))), (float) Math.pow(factor, 1)),
			new Configuration_World(8, (int) (3 * Math.floor(Math.pow(factor, 2))), (float) Math.pow(factor, 1)),
			
			new Configuration_World(9, 0, (float) Math.pow(factor, 2)),
			new Configuration_World(10, (int) (1 * Math.floor(Math.pow(factor, 3))), (float) Math.pow(factor, 2)),
			new Configuration_World(11, (int) (2 * Math.floor(Math.pow(factor, 3))), (float) Math.pow(factor, 2)),
			new Configuration_World(12, (int) (3 * Math.floor(Math.pow(factor, 3))), (float) Math.pow(factor, 2)),
			
			new Configuration_World(13, 0, (float) Math.pow(factor, 3)),
			new Configuration_World(14, (int) (1 * Math.floor(Math.pow(factor, 4))), (float) Math.pow(factor, 3)),
			new Configuration_World(15, (int) (2 * Math.floor(Math.pow(factor, 4))), (float) Math.pow(factor, 3)),
			new Configuration_World(16, (int) (3 * Math.floor(Math.pow(factor, 4))), (float) Math.pow(factor, 3)),
			
			new Configuration_World(17, 0, (float) Math.pow(factor, 4)),
			new Configuration_World(18, (int) (1 * Math.floor(Math.pow(factor, 5))), (float) Math.pow(factor, 4)),
			new Configuration_World(19, (int) (2 * Math.floor(Math.pow(factor, 5))), (float) Math.pow(factor, 4)),
			new Configuration_World(20, (int) (3 * Math.floor(Math.pow(factor, 5))), (float) Math.pow(factor, 4)),
			
			new Configuration_World(21, 0, (float) Math.pow(factor, 5)),
			new Configuration_World(22, (int) (1 * Math.floor(Math.pow(factor, 6))), (float) Math.pow(factor, 5)),
			new Configuration_World(23, (int) (2 * Math.floor(Math.pow(factor, 6))), (float) Math.pow(factor, 5)),
			new Configuration_World(24, (int) (3 * Math.floor(Math.pow(factor, 6))), (float) Math.pow(factor, 5)),
			
			new Configuration_World(25, 0, (float) Math.pow(factor, 6)),
			new Configuration_World(26, (int) (1 * Math.floor(Math.pow(factor, 7))), (float) Math.pow(factor, 6)),
			new Configuration_World(27, (int) (2 * Math.floor(Math.pow(factor, 7))), (float) Math.pow(factor, 6)),
			new Configuration_World(28, (int) (3 * Math.floor(Math.pow(factor, 7))), (float) Math.pow(factor, 6)),
		};*/
		
		IConfigurationEntry[] cfgs_levels = new IConfigurationEntry[4 * 12];
		
		for (int i=0; i<cfgs_levels.length - 3; i+=4) {
			
			int power = i / 4;
			float spaceMultiplier = (float) Math.pow(factor, power);
			float count_challengers = (float) Math.floor(0.5 + Math.pow(factor, power + 1));
			
			cfgs_levels[i] = new Configuration_World(i + 1, (int) (0f * count_challengers), spaceMultiplier);
			cfgs_levels[i + 1] = new Configuration_World(i + 2, (int) (1f * count_challengers), spaceMultiplier);
			cfgs_levels[i + 2] = new Configuration_World(i + 3, (int) (2f * count_challengers), spaceMultiplier);
			cfgs_levels[i + 3] = new Configuration_World(i + 4, (int) (3f * count_challengers), spaceMultiplier);
		}
		
		createInstance(TAG_NAME, new ConfigurationUtils_Level(), cfgs_levels);
	}
	
	
	public IConfigurationWorld getConfigByID(int id) {
		return (IConfigurationWorld) super.getConfigByID(id);
	}
}
