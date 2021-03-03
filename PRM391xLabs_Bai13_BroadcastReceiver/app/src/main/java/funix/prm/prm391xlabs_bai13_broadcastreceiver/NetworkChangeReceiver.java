package funix.prm.prm391xlabs_bai13_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive (Context context, Intent intent) {
        Toast.makeText(context, "NetWork is turned On/Of",Toast.LENGTH_LONG).show();
    }
}
