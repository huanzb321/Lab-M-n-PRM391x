package funix.prm.lab;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, TAG +" LifeCycle: " + "onCreare", Toast.LENGTH_LONG).show();

        Button btnMove = findViewById(R.id.btnMove);
        btnMove.setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, ContentActivity.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, TAG + " LifeCycle: " + "onStart",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, TAG + " LifeCycle: " + "onResume",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, TAG + " LifeCycle: " + "onPause",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, TAG + " LifeCycle: " + "onStop",Toast.LENGTH_LONG).show();
    }@Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, TAG + " LifeCycle: " + "onRestart",Toast.LENGTH_LONG).show();
    }
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, TAG + " LifeCycle: " + "onDestroy",Toast.LENGTH_LONG).show();
    }
}