package app.example.com.togglebuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.view.Menu;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tg1, tg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tg1= (ToggleButton)findViewById(R.id.toggleButton);
        tg2= (ToggleButton)findViewById(R.id.toggleButton2);

        Button b1 = (Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("You have clicked first TG Button : ").append(tg1.getText());
                result.append("\nYou have clicked Second TG Button :").append(tg2.getText());
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}