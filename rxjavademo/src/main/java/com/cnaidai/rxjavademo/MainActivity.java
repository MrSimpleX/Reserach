package com.cnaidai.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

	@Bind(R.id.tv_info)
	TextView tvInfo;
	@Bind(R.id.btm_send)
	Button btmSend;

	Observable<String> strObservable;
	@Bind(R.id.btm_send_just)
	Button btmSendJust;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		showData();
	}

	private void showData() {

	}

	//订阅者 处理onNext
	Subscriber<String> strSubscriber = new Subscriber<String>() {
		@Override
		public void onCompleted() {

		}

		@Override
		public void onError(Throwable e) {
			Toast.makeText(MainActivity.this, e + "错误", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onNext(String s) {
			tvInfo.setText(s);
		}
	};

	@OnClick({R.id.btm_send, R.id.btm_send_just})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.btm_send:
				doSendByCreate();
				break;
			case R.id.btm_send_just:
				doSendByJust();
				break;
		}
	}

	private void doSendByJust() {
		Observable.just("hello RxJava").subscribe(new Action1<String>() {

			@Override
			public void call(String s) {
				tvInfo.setText(s);
			}
		});
	}

	private void doSendByCreate() {
		//时间源发出一个字符串
		strObservable = Observable.create(new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("this is my first Rx Demo");
				subscriber.onCompleted();
			}
		});
		strObservable.subscribe(strSubscriber);
	}
}
