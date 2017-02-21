package yoghurt.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import yoghurt.kh71.MusicInterface;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    MusicInterface mBinder = null;
    boolean isBound;


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinder = MusicInterface.Stub.asInterface(service);
            isBound = true;
            try{
                mBinder.play();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBinder = null;
            isBound = false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button)findViewById(R.id.stop_button);
        Button button2 = (Button)findViewById(R.id.restart_button);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("yoghurt.kh71", "yoghurt.kh71.MyService"));
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isBound){
            unbindService(serviceConnection);
            isBound = false;
        }
    }

    @Override
    public void onClick(View v) {
        if(!isBound) return;
        switch (v.getId()){
            case R.id.stop_button:
                try {
                    mBinder.stop();
                }catch (RemoteException e){
                    e.printStackTrace();
                }
                break;
            case R.id.restart_button:
                try {
                    mBinder.restart();
                }catch (RemoteException e){
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
