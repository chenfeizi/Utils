package com.sjq_education.sampsipapp;

import android.os.Bundle;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.sjq_education.sampsipapp.activity.BaseActivity;

public class MainActivity extends BaseActivity {
	PullToRefreshListView listView; 
	@Override
	protected View onInitView(Bundle savedInstanceState) {

		View view = View.inflate(this, R.layout.activity_main, null);
		
		listView = (PullToRefreshListView) view.findViewById(R.id.list);
		
		listView.setMode(Mode.BOTH);
		
		return view;
	}
}
