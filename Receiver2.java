package cn.edu.zjnu.cs.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       //throw new UnsupportedOperationException("Not yet implemented");

        Toast.makeText(context, "Receiver 2 \n"+intent.getAction()+"\n" + intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
        abortBroadcast(); //to block this broadcast intent from others
    }
}
