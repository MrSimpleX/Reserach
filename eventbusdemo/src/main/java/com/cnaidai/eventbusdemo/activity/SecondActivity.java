package com.cnaidai.eventbusdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.cnaidai.eventbusdemo.R;
import com.cnaidai.eventbusdemo.event.FirstEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author JokerX
 * @version V1.0
 * @Package com.cnaidai.eventbusdemo.activity
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/2/19 14:18
 */
public class SecondActivity extends AppCompatActivity {

	@Bind(R.id.tv_title)
	TextView tvTitle;
	@Bind(R.id.tv_message)
	TextView tvMessage;
	@Bind(R.id.btn_jump)
	Button btnJump;

	FirstEvent event;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		ButterKnife.bind(this);

		initData();
	}

	private void initData() {
		tvTitle.setText("第二个Activity");
		tvMessage.setText("我是第一页Activity的内容");
		btnJump.setText("跳转到第一个Activity");
		event = new FirstEvent();
		event.setMessage("我是从第二个Activity中传递过来的数据");
	}

	@OnClick(R.id.btn_jump)
	public void onClick() {
		EventBus.getDefault().post(event);
		finish();
	}
}
