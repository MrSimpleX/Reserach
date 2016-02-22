package com.cnaidai.buttonevent;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * @author JokerX
 * @version V1.0
 * @Package com.cnaidai.buttonevent
 * @Description: 研究事件封发机制
 * @date 2016/2/18 11:26
 */
public class MyButton extends Button{

	public MyButton(Context context) {
		super(context);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return super.onTouchEvent(event);
	}

	@Override
	protected boolean dispatchHoverEvent(MotionEvent event) {
		return super.dispatchHoverEvent(event);
	}
}
