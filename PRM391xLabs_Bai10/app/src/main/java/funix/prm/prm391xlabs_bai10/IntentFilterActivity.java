package funix.prm.prm391xlabs_bai10;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class IntentFilterActivity extends Activity {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filer);
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener((v) -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: (+084)906225637"));
            startActivity(intent);
        });
    }
}
