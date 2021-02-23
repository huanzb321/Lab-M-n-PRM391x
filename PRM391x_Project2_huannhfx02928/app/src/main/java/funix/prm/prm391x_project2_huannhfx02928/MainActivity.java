package funix.prm.prm391x_project2_huannhfx02928;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout openHotel = (LinearLayout) findViewById(R.id.open_activity_hotel);
        openHotel.setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, HotelActivity.class);
            startActivity(intent);
        });

        LinearLayout openAtm = (LinearLayout) findViewById(R.id.open_activity_atm);
        openAtm.setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, AtmActivity.class);
            startActivity(intent);
        });

        LinearLayout openHospital = (LinearLayout) findViewById(R.id.open_activity_hospital);
        openHospital.setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, HospitalActivity.class);
            startActivity(intent);
        });

        LinearLayout openMetro = (LinearLayout) findViewById(R.id.open_activity_metro);
        openMetro.setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, MetroActivity.class);
            startActivity(intent);
        });
    }
}