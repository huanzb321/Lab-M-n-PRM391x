package funix.prm.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = (Button) findViewById(R.id.btnStartService);
        btnStart.setOnClickListener(this);

        Button btnStop = (Button) findViewById(R.id.btnBoundService);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStartService:
                startActivity(new Intent(MainActivity.this, StartServiceActivity.class));
                break;
            case R.id.btnBoundService:
                startActivity(new Intent(MainActivity.this, BoundServiceActivity.class));
                break;
        }
    }
}