package funix.prm.lab;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;

    private String mCountryList[] = {"Normal","Yellow","Green","Red"};

    private int mFlags[] = {R.drawable.ic_launcher, R.drawable.android_logo_yellow,
            R.drawable.android_logo_green, R.drawable.android_logo_red};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), mCountryList, mFlags);
        mListView.setAdapter(customAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplication(), mCountryList[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}