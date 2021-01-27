package app.example.com.radiobuttondemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg1;
    RadioButton rb1;
    Button b1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerRadioButton();
    }

    private void addListenerRadioButton() {
        rg1 = (RadioGroup) findViewById(R.id.radioGroup);
        b1 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb1=(RadioButton)findViewById(R.id.radioButton2);
                Boolean r = rb1.isChecked();
                Toast.makeText(MainActivity.this, r.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}