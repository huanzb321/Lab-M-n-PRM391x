package funix.prm.prm391x_project3_huannhfx02928;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class EditAlarmActivity extends AppCompatActivity { // Thực hiện các chức năng ở layout edit_alarm
    TimePicker timePicker;
    EditText edtxTenBT;
    Button btnAdd;
    Button btnSave;
    BaoThucDatabase baoThucDatabase;
    BaoThuc baoThuc;

    public EditAlarmActivity() {
        super(R.layout.activity_edit_alarm);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        timePicker = findViewById(R.id.time_picker);
        edtxTenBT = findViewById(R.id.edtx_ten_bao_thuc);
        btnAdd = findViewById(R.id.btn_add);
        btnSave = findViewById(R.id.btn_save);
        baoThucDatabase = new BaoThucDatabase(this);
        baoThucDatabase.open(); // mở database

        Bundle extras = getIntent().getExtras();
        boolean adding = extras.getBoolean(MainActivity.KEY_ADDING);
        if (adding) {
            setTitle(R.string.title_add); // Thêm báo thức
            btnSave.setVisibility(View.GONE);
            int num = extras.getInt(MainActivity.KEY_NUM);
            String name = getString(R.string.new_alarm_name) + " " + num;
            edtxTenBT.setText(name);
            baoThuc = new BaoThuc();
        } else {
            setTitle(R.string.title_edit); // Sửa báo thức
            btnAdd.setVisibility(View.GONE);
            int id = extras.getInt(MainActivity.KEY_ID);
            baoThuc = baoThucDatabase.get(id);
            timePicker.setCurrentHour(baoThuc.getHour());
            timePicker.setCurrentMinute(baoThuc.getMinute());
            edtxTenBT.setText(baoThuc.getName());
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onConfirmClick(View view) {
        baoThuc.setHour(timePicker.getCurrentHour());
        baoThuc.setMinute(timePicker.getCurrentMinute());
        baoThuc.setName(edtxTenBT.getText().toString());
        if (view.getId() == R.id.btn_add) {
            baoThucDatabase.add(baoThuc); //
        } else {
            baoThuc.setEnabled(true);
            baoThucDatabase.update(baoThuc);
        }
        setResult(RESULT_OK);
        finish();
    }

    @Override
    protected void onDestroy() { // đóng database
        baoThucDatabase.close();
        super.onDestroy();
    }
}
