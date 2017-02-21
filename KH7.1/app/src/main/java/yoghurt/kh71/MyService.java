package yoghurt.kh71;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;
    public static final String ACTION="yoghurt.kh71_ACTION";
    private class RemoteService extends MusicInterface.Stub{

        @Override
        public void play() throws RemoteException {
            mediaPlayer.start();
        }

        @Override
        public void restart() throws RemoteException {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(MyService.this, R.raw.musicdemo);
            mediaPlayer.start();
        }

        @Override
        public void stop() throws RemoteException {
            mediaPlayer.pause();
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer = MediaPlayer.create(MyService.this, R.raw.musicdemo);
        }catch(IllegalStateException e){
            e.printStackTrace();
        }
    }


    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        // 服务停止时停止播放音乐并释放资源
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return  new RemoteService();
    }
}
