package funix.prm.prm391xlabs_15_sqlite;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText tvNewName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvName= findViewById(R.id.tvName);
        tvNewName = findViewById(R.id.tvNewName);
        Button btnGetName = (Button) findViewById(R.id.btnGetName);
        Button btnUpdate = (Button) findViewById(R.id.btnUpdateName);
        final MyDBHelper mDB = new MyDBHelper((getApplicationContext()));

        Student student = new Student (1, "Nguyen Huu Huan",
                "Ha Noi", "0906225637");
        mDB.addStudent(student);

        btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student sdt = mDB.getStudent(1);

                tvName.setText(sdt.getName());
                tvName.setText(sdt.getName());
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = mDB.getStudent(1);

                String newName = tvNewName.getText().toString();
                student.setName(newName);
                mDB.updateStudent(student);

                String name = mDB.getStudent(1).getName();
                tvName.setText(name);
            }
        });
    }
}