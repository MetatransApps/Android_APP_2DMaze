package org.metatrans.apps.maze.loading;


import android.content.Context;
import android.graphics.Bitmap;

import org.metatrans.apps.maze.lib.R;
import org.metatrans.commons.loading.View_Loading_Base;
import org.metatrans.commons.model.UserSettings_Base;
import org.metatrans.commons.ui.utils.BitmapUtils;


public class View_Loading extends View_Loading_Base {
	
	
	private Bitmap[] bitmap_commons;
	//private UserSettings_Base settings;
	
	
	public View_Loading(Context context, UserSettings_Base _settings) {
		
		super(context);
		
		//settings = _settings;
		
	}
	
	
	@Override
	protected Bitmap getBitmapBackground() {
		return null;
	}
	
	
	@Override
	protected Bitmap[] getCommonBitmaps() {
		return bitmap_commons;
	}
	
	
	@Override
	public void initPiecesBitmaps() {
		
		bitmap_commons = new Bitmap[] {
				getImageBitmap(R.drawable.ic_logo_maze),
				getImageBitmap(R.drawable.ic_logo_maze),
		};
		
		
		Bitmap[] bitmap_others = new Bitmap[30];
		
		int[] images = new int[] {
				R.drawable.ic_acorn,
				R.drawable.ic_challenger_l,
				R.drawable.ic_challenger_r,
				R.drawable.ic_player7_l,
				R.drawable.ic_player7_r,
			};
		
		
		for (int i=0; i< bitmap_others.length; i++) {
			
			int imageid = images[(int) ((Math.random() * (float)100) % images.length)];
			bitmap_others[i] = BitmapUtils.fromResource(getContext(), imageid, (int) getSquareSize());
			createEntry(bitmap_others[i]);
			
		}
	}
	
	
	protected Bitmap getImageBitmap(int imageResID) {
		return BitmapUtils.fromResource(getContext(), imageResID, (int) getSquareSize());
	}
}
