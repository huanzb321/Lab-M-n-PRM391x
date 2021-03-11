package funix.prm.prm391xlab_bai14_contentprovider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowAll = (Button) findViewById(R.id.btnShowAllContact);
        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, ShowAllContactActivity.class);
                startActivity(intent);
            }
        });
    }
}