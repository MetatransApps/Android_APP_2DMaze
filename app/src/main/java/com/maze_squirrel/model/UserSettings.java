package com.maze_squirrel.model;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.apps.mobile.android.commons.cfg.colours.IConfigurationColours;
import com.maze_squirrel.cfg.world.ConfigurationUtils_Level;


public class UserSettings extends com.apps.mobile.android.commons.graphics2d.model.UserSettings {
	
	
	private static final long serialVersionUID = -612059325371084619L;
	
	
	public UserSettings() {
		
		super();
		
		uiColoursID 		= IConfigurationColours.CFG_COLOUR_GRAY;
		modeID 				= ConfigurationUtils_Level.LEVEL_ID_DEFAULT;
		
		//fixFields("constructor");
	}
	
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		
	    fixFields("writeObject");
	    
	    // default serialization 
	    oos.defaultWriteObject();
	}
	
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
	    
	    // default deserialization
	    ois.defaultReadObject();
	    
	    fixFields("readObject");
	}
	
	
	private void fixFields(String op) {
		
		if (uiColoursID == 0) {
	    	uiColoursID 		= IConfigurationColours.CFG_COLOUR_BLUE_PETROL;
	    	System.out.println("UserSettings: " + op + " - updating colour id");
	    }
	    
		if (modeID == 0) {
			modeID = ConfigurationUtils_Level.LEVEL_ID_DEFAULT;
		}
	}
}
