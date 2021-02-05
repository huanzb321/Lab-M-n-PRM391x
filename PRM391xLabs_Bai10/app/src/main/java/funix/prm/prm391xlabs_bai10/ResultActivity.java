package funix.prm.prm391xlabs_bai10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        TextView result;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = (TextView) findViewById(R.id.resultView);
        Intent intent = getIntent();
        String sum = (String) intent.getSerializableExtra("SUM");
        result.setText(sum);
    }
}
