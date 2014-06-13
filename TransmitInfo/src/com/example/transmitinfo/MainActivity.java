package com.example.transmitinfo;

import android.app.Activity;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.receiver.info.ReceiveCall;
import com.receiver.info.ReceiveInfo;

public class MainActivity extends Activity {


	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
     
        
    }

    
  /*  public void callService(View v)
    {
    	switch (v.getId())
    	{
    	
    	case R.id.start_call:
    		this.registerReceiver(receiver_call, new IntentFilter("android.intent.action.PHONE_STATE"));
    		Log.i("test", "call registered!");
    		break;
    	case R.id.stop_call:
    		this.unregisterReceiver(receiver_call);
    		Log.i("test", "call unregistered!");
    		break;
    	default:
    		Log.i("test", "this is noting");
    		break;
    		
    	}
    }
    */
    
    public void saveNumber(View view)
    {
    	
    	EditText number = (EditText)findViewById(R.id.phone_number);
    	SharedPreferences shared_preferences = this.getSharedPreferences("number", Activity.MODE_PRIVATE);
    
    	Editor editor = shared_preferences.edit();
    	
    	editor.putString("phone_number", number.getText().toString().trim());
    	editor.commit();
    	
		
		Toast.makeText(this, "Set successful", Toast.LENGTH_LONG).show();
    	
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
