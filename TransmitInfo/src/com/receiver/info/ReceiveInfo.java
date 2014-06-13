package com.receiver.info;

import java.util.Set;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.example.transmitinfo.NumberInfo;
import com.send.info.SendMessage;

public class ReceiveInfo extends BroadcastReceiver {

	private Bundle bundle;
	
	private SendMessage send_message;
	private String content;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		Log.i("test", "广播执行");
		
		bundle = intent.getExtras();
		if (bundle != null)
		{
			Object []  object = (Object [])bundle.get("pdus");
			Log.i("test", ""+object.length);
			
			for (Object ob:object)
			{
				Log.i("test", ob.toString());
			}
			content = "";
			SmsMessage [] messages = new SmsMessage[object.length];
			for (int i = 0; i < object.length; i++)
			{
				messages[i] = SmsMessage.createFromPdu((byte []) object[i]);
				
				content += "手机号："+messages[i].getOriginatingAddress()+"\n";
				content += "内容："+messages[i].getDisplayMessageBody();
				
			}
			
			if (NumberInfo.getPhoneNumber(context).equals(""))
			{
				Toast.makeText(context, "请您设置手机号码！", Toast.LENGTH_LONG).show(); 
			}
			else
			{
				Log.i("test",NumberInfo.getPhoneNumber(context));
				send_message = new SendMessage(context, NumberInfo.getPhoneNumber(context), content);
				send_message.sendMessage();
			}
			
		}
		
		
		
	
		
	}
	
	

	
}
