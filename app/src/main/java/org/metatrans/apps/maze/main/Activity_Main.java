package org.metatrans.apps.maze.main;


import org.metatrans.commons.IActivityInterstitial;
import org.metatrans.commons.ads.api.IAdsConfiguration;
import org.metatrans.commons.ads.impl.flow.IAdLoadFlow;
import org.metatrans.commons.app.Application_Base_Ads;
import org.metatrans.commons.graphics2d.main.Activity_Main_Base2D;

import android.view.View;


public class Activity_Main extends Activity_Main_Base2D implements IActivityInterstitial {
	
	
	@Override
	protected View createMainView() {
		return new View_Main_4Controls_4Fire_Labyrints(this);
	}

	
	public String getInterstitialName() {
		return IAdsConfiguration.AD_ID_INTERSTITIAL1;
	}
}
