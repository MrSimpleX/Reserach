package com.cnaidai.eventbusdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cnaidai.eventbusdemo.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

	@Bind(R.id.btn_sure)
	Button mBtnSure;
	@Bind(R.id.tv_text)
	TextView tvText;
	@Bind(R.id.et_input)
	EditText etInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}



	@OnClick(R.id.btn_sure)
	public void onClick() {
//		Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this, FirstActivity.class);
		startActivity(intent);
	}

	@OnClick({R.id.tv_text, R.id.et_input})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.tv_text:
				break;
			case R.id.et_input:
				break;
		}
	}
}
