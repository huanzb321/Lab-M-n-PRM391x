package funix.prm.prm391xlabs_15_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvName = (TextView) findViewById(R.id.tvName);
        Button btnGetName = (Button) findViewById(R.id.btnGetName);
        Button btnUpdate = (Button) findViewById(R.id.btnUpdateName);
        final MyDBHelper mDB = new MyDBHelper((getApplicationContext()));

        Student student = new Student (1, "Nguyen Huu Huan",
                "Ha Noi", "0906225637");
        mDB.addStudent(student);

        btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mDB.getStudent(1).getName();
                tvName.setText(name);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = mDB.getStudent(1);
                student.setName("Nguyen Van A");
                mDB.updateStudent(student);

                String name = mDB.getStudent(1).getName();
                tvName.setText(name);
            }
        });
    }
}