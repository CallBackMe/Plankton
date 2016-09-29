package com.main.plankton.rxjava.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.main.plankton.R;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by ocean.z on 16/9/28.
 */

public class TestRxJavaActivity extends Activity{

	private static final String TAG = "TestRxJavaActivity";

	private ImageView mIvRxJavaShow;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rx_java);

		mIvRxJavaShow = (ImageView)findViewById(R.id.iv_rx_java_show);

		//printAllNames();

		showImage();

	}

	private void showImage() {

		final int image = R.mipmap.ic_launcher;

//		Observable.create(new Observable.OnSubscribe<Drawable>() {
//
//			@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//			@Override
//			public void call(Subscriber<? super Drawable> subscriber) {
//
//				Drawable mDrawable = getTheme().getDrawable(image);
//				subscriber.onNext(mDrawable);
//				subscriber.onCompleted();
//
//			}
//
//		}).subscribe(new Observer<Drawable>() {
//			@Override
//			public void onCompleted() {
//
//			}
//
//			@Override
//			public void onError(Throwable e) {
//
//				Toast.makeText(TestRxJavaActivity.this,"Rx Java  Error !",Toast.LENGTH_SHORT).show();
//
//			}
//
//			@Override
//			public void onNext(Drawable drawable) {
//
//				mIvRxJavaShow.setImageDrawable(drawable);
//				Toast.makeText(TestRxJavaActivity.this,"Rx Java  Image !",Toast.LENGTH_SHORT).show();
//
//			}
//		});

		Observable.create(new Observable.OnSubscribe<Drawable>() {

			@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
			@Override
			public void call(Subscriber<? super Drawable> subscriber) {

				Drawable mDrawable = getTheme().getDrawable(image);
				subscriber.onNext(mDrawable);
				subscriber.onCompleted();

			}

		}).subscribe(new Subscriber<Drawable>() {

			@Override
			public void onStart() {
				super.onStart();
			}

			@Override
			public void onCompleted() {

				Toast.makeText(TestRxJavaActivity.this,"Rx Java  Complete !",Toast.LENGTH_SHORT).show();

			}

			@Override
			public void onError(Throwable e) {

				Toast.makeText(TestRxJavaActivity.this,"Rx Java  Error !",Toast.LENGTH_SHORT).show();

			}

			@Override
			public void onNext(Drawable drawable) {

				mIvRxJavaShow.setImageDrawable(drawable);
				Toast.makeText(TestRxJavaActivity.this,"Rx Java  Image !",Toast.LENGTH_SHORT).show();

			}
		});


	}

	private void printAllNames() {

		String[] names = new String[]{"1","12","13","14","15","16","17","18","19","10","111","112","113"};

		Observable.from(names).subscribe(new Action1<String>() {
			@Override
			public void call(String s) {

				Log.e(TAG,"  s = " + s);

			}
		});

	}
}
