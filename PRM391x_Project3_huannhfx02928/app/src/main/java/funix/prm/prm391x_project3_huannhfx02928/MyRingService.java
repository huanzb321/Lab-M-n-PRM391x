package funix.prm.prm391x_project3_huannhfx02928;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MyRingService extends Service { //để thực hiện ON/OFF alarm

    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI); // Nhạc chuông
        mediaPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start(); // bật nhạc
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop(); // tắt nhạc
        super.onDestroy();
    }
}
