package com.receiver.info;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.example.transmitinfo.NumberInfo;
import com.send.info.SendMessage;

public class ReceiveCall extends BroadcastReceiver {

	private TelephonyManager tm;
	private SendMessage send_call_message;
	private static String number;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		number = NumberInfo.getPhoneNumber(context);
		
		if (number.equals(""))
		{
			Toast.makeText(context, "请您设置手机号！", Toast.LENGTH_LONG).show();
			
		}
		else {
			
			tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
			
			switch (tm.getCallState()) {
			
			case TelephonyManager.CALL_STATE_RINGING:
				String incomingNumber = intent.getStringExtra("incoming_number");
				Log.i("test", "incomingNumber:"+incomingNumber);
				send_call_message = new SendMessage(context, number, "来电："+incomingNumber);
				send_call_message.sendMessage();
				Log.i("test", "send call message successful");
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				Log.i("test", "offhook");
				break;
			case TelephonyManager.CALL_STATE_IDLE:
				Log.i("test", "close");
				break;
			default:
				Log.i("test", "this is noting");
				break;
			}
			
		}
		
		
	}

	
}
