package org.metatrans.apps.maze.main;


import org.metatrans.commons.IActivityInterstitial;
import org.metatrans.commons.ads.api.IAdsConfiguration;
import org.metatrans.commons.graphics2d.main.Activity_Main_Base2D;
//import org.yoyo.synthesys.synthesizers.Synthesizer;
//import org.yoyo.synthesys.synthesizers.Synthesizer_Melody;

import android.os.Bundle;
import android.view.View;


public class Activity_Main extends Activity_Main_Base2D implements IActivityInterstitial {


	//private Synthesizer synthesizer;


	@Override
	public void onCreate(Bundle savedInstanceState) {

		System.out.println("Activity_Main_Base2D: onCreate()");

		super.onCreate(savedInstanceState);

		//synthesizer = new Synthesizer_Melody(Integer.MAX_VALUE);
	}


	@Override
	protected void onResume() {

		super.onResume();

		/*executor.execute(new Runnable() {

			@Override
			public void run() {

				try {

					synthesizer.play();

				} catch (Exception e) {

					throw new RuntimeException(e);
				}
			}
		});*/
	}


	@Override
	protected void onPause() {

		super.onPause();

		//synthesizer.markStopped();
	}


	@Override
	protected View createMainView() {

		return new View_Main_4Controls_4Fire_Labyrints(this);
	}

	
	public String getInterstitialName() {
		return IAdsConfiguration.AD_ID_INTERSTITIAL1;
	}
}
