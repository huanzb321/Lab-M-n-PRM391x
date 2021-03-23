package funix.prm.prm391x_project3_huannhfx02928;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Objects;

public class Clock extends AppCompatActivity {
    TimePicker timePicker;
    Button btnAdd;
    LiteDatabase db;
    Alarm alarm;

    boolean adding = true;
    public Clock() {
        super(R.layout.activity_clock);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        timePicker = findViewById(R.id.clock);
        btnAdd = findViewById(R.id.save_button);
        db = new LiteDatabase(this);
        db.open();

        Bundle extras = getIntent().getExtras();
        adding = extras.getBoolean(MainActivity.KEY_ADDING);

        if (adding) {
            alarm = new Alarm();
        } else {
            int id = extras.getInt(MainActivity.KEY_ID);
            alarm = db.get(id);
            //Toast.makeText(getApplicationContext(),id+"AAA",Toast.LENGTH_SHORT).show();

            timePicker.setHour(alarm.getHours());
            timePicker.setMinute(alarm.getMinutes());
        }
    }

    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }

    public void addAlarm(View v) {
        alarm.setHours(timePicker.getHour());
        alarm.setMinutes(timePicker.getMinute());

        if(adding)
            db.add(alarm);
        else {
            alarm.setEnabled(true);
            db.update(alarm);
        }

        /* if (v.getId() == R.id.save_button) {
             db.add(alarm);
         } else {
             alarm.setEnabled(true);
             db.update(alarm);
         }*/
        setResult(RESULT_OK);
        finish();
    }
}
