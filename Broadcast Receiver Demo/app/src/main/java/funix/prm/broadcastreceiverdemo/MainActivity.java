package funix.prm.broadcastreceiverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    /** Được gọi khi hoạt động được tạo lần đầu tiên */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // phát một ý định tùy chỉnh .

    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("android.intent.action.REBOOT"); sendBroadcast(intent);
    }
}