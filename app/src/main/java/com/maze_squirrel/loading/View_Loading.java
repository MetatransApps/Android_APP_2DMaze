package com.maze_squirrel.loading;


import android.content.Context;
import android.graphics.Bitmap;

import org.metatrans.commons.loading.View_Loading_Base;
import org.metatrans.commons.model.UserSettings_Base;
import org.metatrans.commons.ui.utils.BitmapUtils;

import com.maze_squirrel.lib.R;


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
	protected void initPiecesBitmaps() {
		
		bitmap_commons = new Bitmap[] {
				getImageBitmap(R.drawable.ic_logo_maze),
				getImageBitmap(R.drawable.ic_logo_maze),
		};
		
		
		Bitmap[] bitmap_others = new Bitmap[30];
		
		int[] images = new int[] {
				R.drawable.ic_acorn,
				R.drawable.ic_challenger,
				//R.drawable.ic_player6,
				//R.drawable.ic_player7,
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
