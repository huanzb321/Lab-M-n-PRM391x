package funix.prm.intentfilterdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dailLauch(View v) {
        Intent lauch = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
        startActivity(lauch);
    }
}