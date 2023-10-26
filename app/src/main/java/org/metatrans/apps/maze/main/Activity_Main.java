package org.metatrans.apps.maze.main;


import org.metatrans.commons.IActivityInterstitial;
import org.metatrans.commons.ads.api.IAdsConfiguration;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.main.Activity_Main_Base2D;

import android.os.Bundle;
import android.view.View;


public class Activity_Main extends Activity_Main_Base2D implements IActivityInterstitial {


	@Override
	public void onCreate(Bundle savedInstanceState) {

		System.out.println("Activity_Main_Base2D: onCreate()");

		super.onCreate(savedInstanceState);
	}


	@Override
	protected void onResume() {

		super.onResume();

		Application_Base.getInstance().getMelodiesManager().setMelody(Application_Base.getInstance().getUserSettings().melody_cfg_id);
	}


	@Override
	protected void onPause() {

		super.onPause();

		Application_Base.getInstance().getMelodiesManager().stop();
	}


	@Override
	protected View createMainView() {

		return new View_Main_4Controls_4Fire_Labyrints(this);
	}

	
	public String getInterstitialName() {
		return IAdsConfiguration.AD_ID_INTERSTITIAL1;
	}
}
