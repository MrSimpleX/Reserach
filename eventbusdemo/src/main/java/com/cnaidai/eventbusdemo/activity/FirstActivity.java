package com.cnaidai.eventbusdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cnaidai.eventbusdemo.R;
import com.cnaidai.eventbusdemo.event.FirstEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author JokerX
 * @version V1.0
 * @Package com.cnaidai.eventbusdemo.activity
 * @Description: 第一个Activity
 * @date 2016/2/19 14:02
 */
public class FirstActivity extends AppCompatActivity {

	@Bind(R.id.tv_title)
	TextView mTvTitle;
	@Bind(R.id.tv_message)
	TextView mTvMessage;
	@Bind(R.id.btn_jump)
	Button mBtnJump;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_test);
		EventBus.getDefault().register(this);
		ButterKnife.bind(this);
		initData();
	}

	private void initData() {
		mTvTitle.setText("第一个Activity");
		mTvMessage.setText("我是第一页Activity的内容");
		mBtnJump.setText("跳转到第二个Activity");
	}

	/*@Subscribe
	public void onEventMainThread(FirstEvent event) {

		String msg = "onEventMainThread收到了消息：" + event.getMessage();
		Log.d("harvic", msg);
		mTvMessage.setText(msg);
		Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
	}*/

	/*@Subscribe
	public void onEventAsync(FirstEvent eventOne) {
		Log.i("MainActivity", "onEventAsyc--->" + Thread.currentThread().getName());
		mTvMessage.setText(eventOne.getMessage());
	}*/

	/*@Subscribe
	public void onEventBackgroundThread(FirstEvent eventOne) {
		Log.i("onEventBackgroundThread", "onEventBackgroundThread--->" + Thread.currentThread().getName());
		Log.i("onEventBackgroundThread", eventOne.getMessage());
		mTvMessage.setText(eventOne.getMessage());
	}*/

	@Subscribe
	public void onEventPostThread(FirstEvent eventOne) {
		Log.i("onEventPostThread", "onEventPostThread--->" + Thread.currentThread().getName());
		Log.i("onEventPostThread", eventOne.getMessage());
		mTvMessage.setText(eventOne.getMessage());
	}

	@OnClick(R.id.btn_jump)
	public void onClick() {
		Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
		startActivity(intent);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
}
