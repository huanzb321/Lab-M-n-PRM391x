package funix.prm.prm391x_project1_huannhxf02928;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public String userName = ""; // Bien gan ten cua nguoi dung nhap
    private RadioButton rg1Rb3; // Nut RadioButton
    private RadioButton rg5Rg2;
    private RadioButton rg9Rg2;
    private CheckBox cb3Answer1; // O Checkbox
    private CheckBox cb3Answer2;
    private CheckBox cb3Answer3;
    private CheckBox cb3Answer4;
    private CheckBox cb7Answer1;
    private CheckBox cb7Answer2;
    private CheckBox cb7Answer3;
    private CheckBox cb7Answer4;
    private EditText ed2; // Nhap EditText
    private EditText ed4;
    private EditText ed6;
    private EditText ed8;
    private EditText ed10;
    private Button buttonSubmit;
    public int counter = 60; // So giay nguoi dung hoan thanh bai quiz
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Hien thi man hinh chinh

        EditText name = (EditText)findViewById(R.id.name);

        Button btnMove = findViewById(R.id.button1); // Nut Button
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = name.getText().toString();
                setContentView(R.layout.start_acivity); // Hien thi man hinh quiz

                TextView yourName = (TextView)findViewById(R.id.yourName);
                yourName.setText(userName);

                quizSubmit();
            }
        });
    }

    private void quizSubmit() { // Phuong thuc hien thi quiz

        final TextView counttime = findViewById(R.id.counttime);
        new CountDownTimer(60000,1000) {
            @Override
            public void onTick (long millisUntilFinished) {  // chuong trinh trong trong thoi gian dem nguoc
                counttime.setText("Time: " + counter);
                counter--;
            }
            @Override
            public void onFinish() { // chuong trinh chay khi thoi gian het
                checkTheResult();
                setContentView(R.layout.end_activity);
            }
        }.start();

        buttonSubmit = (Button)findViewById(R.id.buttonSubmit); // Nhan dien layout nut submit
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkTheResult();
                setContentView(R.layout.end_activity);
            }
        });
    }
    private void checkTheResult() { // phuong thuc kiem tra ket qua cua nguoi dung
        int count = 0; // Dem so cau hoi nguoi dung lam dung
        rg1Rb3 = (RadioButton)findViewById(R.id.rg1_rb3); // Nhan dien layout
        Boolean quiz_1 = rg1Rb3.isChecked(); // Check dap an nguoi dung chon
        if(quiz_1) { // Kiem tra nguoi dung nhap dung hay sai
            count +=1;
        }
        rg5Rg2 = (RadioButton)findViewById(R.id.rg5_rb2);
        Boolean quiz_5 = rg5Rg2.isChecked(); // Check dap an nguoi dung chon
        if (quiz_5) { // Kiem tra nguoi dung nhap dung hay sai
            count += 1;
        }
        rg9Rg2 = (RadioButton)findViewById(R.id.rg9_rb2);
        Boolean quiz_9 = rg9Rg2.isChecked(); // Check dap an nguoi dung chon
        if (quiz_9) {// Kiem tra nguoi dung nhap dung hay sai
            count += 1;
        }

        cb3Answer1 = (CheckBox)findViewById(R.id.Cb_quiz3_1);// Nhan dien layout
        cb3Answer2 = (CheckBox)findViewById(R.id.Cb_quiz3_2);
        cb3Answer3 = (CheckBox)findViewById(R.id.Cb_quiz3_3);
        cb3Answer4 = (CheckBox)findViewById(R.id.Cb_quiz3_4);
        Boolean quiz_3_1 = cb3Answer1.isChecked();// Check dap an nguoi dung chon
        Boolean quiz_3_2 = cb3Answer2.isChecked();
        Boolean quiz_3_3 = cb3Answer3.isChecked();
        Boolean quiz_3_4 = cb3Answer4.isChecked();
        if (quiz_3_1 == true && quiz_3_2 == false && quiz_3_3 == true && quiz_3_4 == false) {
            count += 1;
        }
        cb7Answer1 = (CheckBox)findViewById(R.id.Cb_quiz7_1);// Nhan dien layout
        cb7Answer2 = (CheckBox)findViewById(R.id.Cb_quiz7_2);
        cb7Answer3 = (CheckBox)findViewById(R.id.Cb_quiz7_3);
        cb7Answer4 = (CheckBox)findViewById(R.id.Cb_quiz7_4);
        Boolean quiz_7_1 = cb7Answer1.isChecked();// Check dap an nguoi dung chon
        Boolean quiz_7_2 = cb7Answer2.isChecked();
        Boolean quiz_7_3 = cb7Answer3.isChecked();
        Boolean quiz_7_4 = cb7Answer4.isChecked();
        if (quiz_7_1 == false && quiz_7_2 == false && quiz_7_3 == true && quiz_7_4 == true) {
            count +=1;
        }

        ed2 = (EditText)findViewById(R.id.editText_quiz2);
        if(ed2.getText().toString().equalsIgnoreCase("Vulcanizing")) {
            count += 1;
        }
        ed4 = (EditText)findViewById(R.id.editText_quiz4);
        if(ed4.getText().toString().equalsIgnoreCase("Gravity")) {
            count += 1;
        }
        ed6 = (EditText)findViewById(R.id.editText_quiz6);
        if(ed6.getText().toString().equalsIgnoreCase("Clouds")
                || ed6.getText().toString().equalsIgnoreCase("Cloud")) {
            count += 1;
        }
        ed8 = (EditText)findViewById(R.id.editText_quiz8);
        if(ed8.getText().toString().equalsIgnoreCase("Wrist")) {
            count += 1;
        }
        ed10 = (EditText)findViewById(R.id.editText_quiz10);
        if(ed10.getText().toString().equalsIgnoreCase("Smelting")) {
            count += 1;
        }

        if (count == 10) { // Kiem tra ket qua nguoi dung lam dung va thong bao len man hinh
            Toast.makeText(MainActivity.this,"Perfect! You scored " + count + " out of 10",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this,"Try again. You scored " + count + " out of 10",Toast.LENGTH_LONG).show();
        }
    }
}