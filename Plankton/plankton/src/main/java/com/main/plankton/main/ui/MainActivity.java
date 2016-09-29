package com.main.plankton.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.main.plankton.R;
import com.main.plankton.rxjava.ui.TestRxJavaActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


	private Button mBtnRxJava;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mBtnRxJava = (Button)findViewById(R.id.btn_rx_java);
		mBtnRxJava.setOnClickListener(this);


	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		    case R.id.btn_rx_java:

			    startActivity(new Intent(this, TestRxJavaActivity.class));

		        break;

		    default:

		        break;

		}

	}

}
