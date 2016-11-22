package com.twac.tab_demo2;

import com.twac.tab_demo2.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements OnClickListener {
	// tab
	private LinearLayout mLinearLayout1;
	private LinearLayout mLinearLayout2;
	private LinearLayout mLinearLayout3;
	private LinearLayout mLinearLayout4;
	// img button
	private ImageButton imgButton1;
	private ImageButton imgButton2;
	private ImageButton imgButton3;
	private ImageButton imgButton4;
	// fragment
	private Fragment mTab01;
	private Fragment mTab02;
	private Fragment mTab03;
	private Fragment mTab04;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initView();
		initEvent();
		setSelect(0);
	}

	private void initEvent() {
		mLinearLayout1.setOnClickListener(this);
		mLinearLayout2.setOnClickListener(this);
		mLinearLayout3.setOnClickListener(this);
		mLinearLayout4.setOnClickListener(this);
	}

	private void initView() {
		// tab
		mLinearLayout1 = (LinearLayout) findViewById(R.id.bottom_layout_1);
		mLinearLayout2 = (LinearLayout) findViewById(R.id.bottom_layout_2);
		mLinearLayout3 = (LinearLayout) findViewById(R.id.bottom_layout_3);
		mLinearLayout4 = (LinearLayout) findViewById(R.id.bottom_layout_4);
		// img Button
		imgButton1 = (ImageButton) findViewById(R.id.img_button1);
		imgButton2 = (ImageButton) findViewById(R.id.img_button2);
		imgButton3 = (ImageButton) findViewById(R.id.img_button3);
		imgButton4 = (ImageButton) findViewById(R.id.img_button4);

	}

	private void setSelect(int i) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();

		hideFragment(transaction);

		switch (i) {

		case 0:
			if (mTab01 == null) {
				mTab01 = new WeiXinFragment();
				transaction.add(R.id.id_content, mTab01);
			} else {
				transaction.show(mTab01);
			}
			imgButton1.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		case 1:
			if (mTab02 == null) {
				mTab02 = new Friends();
				transaction.add(R.id.id_content, mTab02);
			} else {
				transaction.show(mTab02);
			}
			imgButton2.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case 2:
			if (mTab03 == null) {
				mTab03 = new Address();
				transaction.add(R.id.id_content, mTab03);
			} else {
				transaction.show(mTab03);
			}
			imgButton3.setImageResource(R.drawable.tab_address_pressed);
			break;
		case 3:
			if (mTab04 == null) {
				mTab04 = new Setting();
				transaction.add(R.id.id_content, mTab04);
			} else {
				transaction.show(mTab04);
			}
			imgButton4.setImageResource(R.drawable.tab_settings_pressed);
			break;
		default:
			break;
		}
		transaction.commit();
	}

	private void hideFragment(FragmentTransaction transaction) {
		if (mTab01 != null) {
			transaction.hide(mTab01);
		}
		if (mTab02 != null) {
			transaction.hide(mTab02);
		}
		if (mTab03 != null) {
			transaction.hide(mTab03);
		}
		if (mTab04 != null) {
			transaction.hide(mTab04);
		}

	}

	@Override
	public void onClick(View v) {

		resetImgs();
		switch (v.getId()) {
		case R.id.bottom_layout_1:
			setSelect(0);
			break;
		case R.id.bottom_layout_2:
			setSelect(1);
			break;
		case R.id.bottom_layout_3:
			setSelect(2);
			break;
		case R.id.bottom_layout_4:
			setSelect(3);
			break;
		default:
			break;
		}

	}

	private void resetImgs() {

		imgButton1.setImageResource(R.drawable.tab_weixin_normal);
		imgButton2.setImageResource(R.drawable.tab_find_frd_normal);
		imgButton3.setImageResource(R.drawable.tab_address_normal);
		imgButton4.setImageResource(R.drawable.tab_settings_normal);

	}

}
