package com.send.info;

import android.content.Context;
import android.telephony.SmsManager;
import android.util.Log;

public class SendMessage {

	private String message;
	private String number;
	private SmsManager sms_manager;
	private Context context;
	
	public SendMessage()
	{		
	}
	
	public SendMessage(Context context, String number, String message)
	{
		this.context = context;
		this.number = number;
		this.message = message;
		sms_manager = SmsManager.getDefault();
	}
	
	public void sendMessage()
	{
		sms_manager.sendTextMessage(number, null, message, null, null);
		
		Log.i("test", "this is sendmessage");
		
	/*	Toast toast = Toast.makeText(context, "Send message successfully", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
		*/
		
		
	}
}
