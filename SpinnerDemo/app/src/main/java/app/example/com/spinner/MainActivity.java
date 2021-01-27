package app.example.com.spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayList<String>  country = new ArrayList<String>();
        country.add("India");
        country.add("USA");
        country.add("Singapore");
        country.add("Nepal");
        country.add("Paris");

        ArrayAdapter<String> countryad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,country);
        spinner.setAdapter(countryad);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        TextView tv = (TextView)findViewById(R.id.textView);
        String tv_text = tv.getText().toString();

        Toast.makeText(getApplicationContext(), tv_text + "   " +item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}