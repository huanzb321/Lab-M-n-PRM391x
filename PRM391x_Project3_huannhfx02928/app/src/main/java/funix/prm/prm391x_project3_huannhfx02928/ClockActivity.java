package funix.prm.prm391x_project3_huannhfx02928;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClockActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        Button btnAdd = (Button) findViewById(R.id.btnAdd_clock);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClockActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
