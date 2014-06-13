package com.example.transmitinfo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class NumberInfo {

	public static String getPhoneNumber(Context context)
	{
		SharedPreferences shared_preferences = context.getSharedPreferences("number", Activity.MODE_PRIVATE);
		String phone_number = shared_preferences.getString("phone_number", "");
	
		return phone_number;
	}
}
