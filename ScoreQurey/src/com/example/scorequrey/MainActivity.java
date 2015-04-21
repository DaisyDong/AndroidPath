package com.example.scorequrey;

import java.lang.ref.WeakReference;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import Service.UserService;
import Service.UserServiceImp;
import android.support.v7.app.ActionBarActivity;
import android.text.StaticLayout;
import android.R.integer;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private EditText txtqueryName;
	private EditText txtqueryNumber;
	private Button bntquery;
	private Button bntbuilt;
	private UserService userService = new UserServiceImp();
	private static ProgressDialog dialog;
	 
	private static final String MSG_ERROR = "��ѯ����";
	private static final String QUERY = "��ѯ�ɹ�";
	private static final int QUERY_SUCCESS = 1;
	public static String list = new String();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.txtqueryName = (EditText) this.findViewById(R.id.et1);
		this.txtqueryNumber = (EditText) this.findViewById(R.id.et2);
		this.bntquery = (Button) this.findViewById(R.id.bnt1);
		this.bntbuilt = (Button) this.findViewById(R.id.bnt2);
		
		this.bntquery.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) { 
				final String queryName = txtqueryName.getText().toString();
				final String queryNumber = txtqueryNumber.getText().toString();
			/**
			 * ��ֵ֤	 
			 */
			if(dialog == null) {
				dialog = new ProgressDialog(MainActivity.this); 
			}
 
			dialog.setTitle("��ȴ�");
			dialog.setMessage("���ڲ�ѯ������");
			dialog.setCancelable(false);
			dialog.show(); 
			 
//			list = userService.userQuery(queryName, queryNumber);   
//			System.out.println(list);
//			startActivity(new Intent(MainActivity.this,ResultActivity.class)); 
//			 
//			}
//		});
//	}
			/**
			 * ���߳�
			 */ 
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {  
					try {
						list = userService.userQuery(queryName, queryNumber);  
						handler.sendEmptyMessage(QUERY_SUCCESS);	//
					} catch (Exception e) {
						e.printStackTrace();
						Message msg = new Message();
						Bundle data = new Bundle();
						data.putSerializable("ErrorMsg",MSG_ERROR);
						msg.setData(data);
						handler.sendMessage(msg); 
						
					}
				}
			}); 
			thread.start();  
			} 
		});
		
	this.bntbuilt.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) { 
			startActivity(new Intent(MainActivity.this,BActivity.class));	//��ת���½����ݵ�activity��
		}
	}); 
	}
	private void showTip(String str) {
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}
	private class IHandler extends Handler {
		private final WeakReference<Activity> mActivity;
		
		public IHandler(MainActivity activity) {
			mActivity = new WeakReference<Activity>(activity);
		}
		public void handleMessage(Message msg) {
			if(dialog != null) {
				dialog.dismiss();
			}
			int flag = msg.what;
			switch(flag) {
			case 0:
				String erroMsgString = (String)msg.getData().getSerializable("ErrorMsg");
				((MainActivity)mActivity.get()).showTip(erroMsgString);
				break;
			case QUERY_SUCCESS:	//��ת����һ����ʾ��activity  
				Thread.interrupted();  
				startActivity(new Intent(MainActivity.this,ResultActivity1.class));
				break; 
			default:
				break;
			}
		}
	}  
	IHandler handler = new IHandler(MainActivity.this); 
	
}

