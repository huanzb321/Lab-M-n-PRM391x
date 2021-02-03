package funix.prm.prm391xlab_bai9;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button mSubtraction, mMultiplication, mDivision;

    private EditText mInputA, mInputB;

    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDivision = (Button) findViewById(R.id.division);
        mSubtraction = (Button) findViewById(R.id.subtraction);
        mMultiplication = (Button) findViewById(R.id.multiplication);
        mInputA = (EditText) findViewById(R.id.inputA);
        mInputB = (EditText) findViewById(R.id.inputB);
        mResult = (TextView) findViewById(R.id.result);

        // Listener in variable
        mMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = Double.parseDouble(
                        mInputA.getText().toString()) * Double.parseDouble(
                        mInputB.getText().toString());
                mResult.setText("Result: " + mInputA.getText().toString() + "*"
                + mInputB.getText().toString() + "=" + result);
            }
        });

        // Inline anonyous listener
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == mDivision) {
                    double result = Double.parseDouble(mInputA.getText().toString())
                            / Double.parseDouble(mInputB.getText().toString());
                    mResult.setText("Kết quả: " + mInputA.getText().toString() + "/"
                            + mInputB.getText().toString() + "=" + result);
                }
            }
        };
        mDivision.setOnClickListener(listener);
        mSubtraction.setOnClickListener(this);
    }

    // OnClick in XML
    public void addition(View v) {
        double result = Double.parseDouble(mInputA.getText().toString())
                + Double.parseDouble(mInputB.getText().toString());
        mResult.setText("Kết quả: " + mInputA.getText().toString() + "+"
                + mInputB.getText().toString() + "=" + result);
    }

    // Activity is listener
    public void onClick(View v) {
        if (v == mDivision) {
            double result = Double.parseDouble(mInputA.getText().toString())
                    - Double.parseDouble(mInputB.getText().toString());
            mResult.setText("Kết quả: " + mInputA.getText().toString() + "-"
                    + mInputB.getText().toString() + "=" + result);
        }
    }
}