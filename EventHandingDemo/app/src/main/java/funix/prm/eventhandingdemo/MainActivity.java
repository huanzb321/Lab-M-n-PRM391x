package funix.prm.eventhandingdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"The Button is clicked ",Toast.LENGTH_LONG).show();
                btn.setText("Button Clicked ");
            }
        });
        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(),"LONG CLICK", Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    public void imageButtonClicked (View v) {
        Toast.makeText(this, "You have clicked the IMAGE BUTTON", Toast.LENGTH_SHORT).show();

    }
}