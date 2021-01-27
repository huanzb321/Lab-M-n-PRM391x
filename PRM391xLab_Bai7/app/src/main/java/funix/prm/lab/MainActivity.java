package funix.prm.lab;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.os.Bundle;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mRadioGroup;
    private Button mBtnChangeImage;
    private ImageView mImageView;
    private int mResId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadioGroup = findViewById(R.id.radioGroup);
        mRadioGroup.setOnCheckedChangeListener(this);

        mImageView = findViewById(R.id.ingView);

        mBtnChangeImage = findViewById(R.id.btnChangeImage);
        mBtnChangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                switch (mResId) {
                    case 1:
                        mImageView.setImageResource(R.drawable.image1);
                        break;
                    case 2 :
                        mImageView.setImageResource(R.drawable.image2);
                        break;
                    case 3 :
                        mImageView.setImageResource(R.drawable.image1);
                        break;
                }
            }
        });

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radioButton1:
                mResId =1;
                break;
            case R.id.radioButton2:
                mResId = 2 ;
                break;
            default:
                mResId = 1;
                break;
        }
    }
}