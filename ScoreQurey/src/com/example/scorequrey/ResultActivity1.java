package com.example.scorequrey;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultActivity1 extends ActionBarActivity {

	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private TextView tv4;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_activity1);
		String a[] = MainActivity.list.split(",");
//		String a[] = {"aaa","bbb","ccc","ddd"};
//		System.out.println(a);

		tv1 = (TextView) findViewById(R.id.textView6);
		tv2 = (TextView) findViewById(R.id.textView7);
		tv3 = (TextView) findViewById(R.id.textView8);
		tv4 = (TextView) findViewById(R.id.textView9);
		if(MainActivity.list != null) {
		tv1.setText(String.format("%s",a[0]));
		tv2.setText(String.format("%s",a[1]));
		tv3.setText(String.format("%s",a[2]));
		tv4.setText(String.format("%s",a[3])); 
		}
	} 
}
