package com.sjq_education.sampsipapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	protected View view;

	public void onDestroyView() {
		super.onDestroyView();
		if (view != null) {
			ViewGroup parent = (ViewGroup) view.getParent();
			if (parent != null) {
				parent.removeView(view);
			}
		}
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (view != null) {
			return view;
		}
		view = onInitView(inflater, container, savedInstanceState);
		return view;
	}

	protected abstract View onInitView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState);


}
