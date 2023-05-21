package cn.edu.zjnu.cs.broadcastdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Receiver1 rec1;
    private Receiver2 rec2;
    private IntentFilter filter;

    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //register Receivers
        rec1= new Receiver1();
        filter= new IntentFilter("lucky money");  //a   broadcast intent
        filter.setPriority(200);
        registerReceiver(rec1, filter);

        rec2= new Receiver2();
        filter= new IntentFilter("lucky money"); //a   broadcast intent
        filter.setPriority(500);
        registerReceiver(rec2, filter);


        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(rec1);
        unregisterReceiver(rec2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1: //send unordered broadcast intent: action name="help" content= ("msg", "I'm lost in a forest");
                Intent broadIntent= new Intent();
                broadIntent.setAction("help");
                broadIntent.putExtra("msg","I'm lost in a forest");
                sendBroadcast( broadIntent);
                Log.i("MAINACTIVITY", "Help Broadcast sent");
                break;

            case R.id.button2: //send an ordered broadcast intent: action name="lucky money" content=("msg", "$1000");
                Intent broadIntent2= new Intent();
                broadIntent2.setAction("lucky money");
                broadIntent2.putExtra("msg","$1000");
                sendOrderedBroadcast(broadIntent2, null);
                Log.i("MAINACTIVITY", "Lucky money Broadcast sent");
                break;
         }
    }
}
