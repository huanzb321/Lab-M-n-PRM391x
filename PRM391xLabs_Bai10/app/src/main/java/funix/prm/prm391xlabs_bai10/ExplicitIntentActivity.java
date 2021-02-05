package funix.prm.prm391xlabs_bai10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExplicitIntentActivity extends Activity {
    private EditText mFirstNum;
    private EditText mSecondNum;
    private Button mBtnAdd;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);
        mFirstNum = (EditText) findViewById(R.id.firstNum);
        mSecondNum = (EditText) findViewById(R.id.secondNum);
        mBtnAdd = (Button) findViewById(R.id.addButton);
        mBtnAdd.setOnClickListener(new AddButtonClickHandler());
    }
    public class AddButtonClickHandler implements View.OnClickListener {
        public void onClick(View view) {
            int num1  = Integer.parseInt(mFirstNum.getText().toString());
            int num2 = Integer.parseInt(mSecondNum.getText().toString());
            Intent explicitIntent = new Intent (ExplicitIntentActivity.this, ResultActivity.class);
            explicitIntent.putExtra("SUM", num1 + "+" + num2 + "=" +(num1 + num2));
            startActivity(explicitIntent);
        }
    }
}
