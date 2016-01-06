package com.sjq_education.sampsipapp.activity;

import com.sjq_education.sampsipapp.R;
import com.sjq_education.sampsipapp.utils.SystemBarTintManager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public abstract class BaseActivity extends Activity {

	protected View view;

	@TargetApi(19)
	private void setTranslucentStatus(boolean on) {
		Window win = getWindow();
		WindowManager.LayoutParams winParams = win.getAttributes();
		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
		if (on) {
			winParams.flags |= bits;
		} else {
			winParams.flags &= ~bits;
		}
		win.setAttributes(winParams);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {    
	           setTranslucentStatus(true);    
	           SystemBarTintManager tintManager = new SystemBarTintManager(this);    
	           tintManager.setStatusBarTintEnabled(true);    
	           /**需注意的是， tintManager.setStatusBarTintResource(R.color.top_bg_color);
	           *这一步的颜色值（即把你的状态栏颜色与你的标题栏颜色保持一致）要写在color.xml中去，
	           *如果用Color.praseColor则会报错。
	           **/
	           tintManager.setStatusBarTintResource(R.color.top_color);//通知栏所需颜色  
	       }
		if (view != null) {
			setContentView(view);
		} else {
			view = onInitView(savedInstanceState);
			setContentView(view);
		}
	}

	protected abstract View onInitView(Bundle savedInstanceState);
}
