package com.sjq_education.sampsipapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 重写 TextView
 * @author chenhongwei
 *
 */
public class MyTextView extends TextView{

	public MyTextView(Context context) {
		this(context, null);
	}
	public MyTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
	}
	
}
