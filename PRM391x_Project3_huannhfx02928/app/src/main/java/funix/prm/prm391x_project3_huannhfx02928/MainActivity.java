package funix.prm.prm391x_project3_huannhfx02928;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnClockActivity = (ImageButton) findViewById(R.id.btnOpen);
        btnClockActivity.setOnClickListener((view) -> {
            Intent i = new Intent(MainActivity.this, ClockActivity.class);
            startActivity(i);
        });
    }
}