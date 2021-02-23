package funix.prm.prm391x_project2_huannhfx02928;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class HospitalActivity extends AppCompatActivity {
    private ListView mListView;

    private String atm[] = {
            "ATM Hoàn Kiếm \n17 phố Lý Thường Kiệt, Phường Phan Chu Trinh, Quận Hoàn Kiếm, Hà Nội",
            "ATM Đinh Tiên Hoàng \n7 Đinh Tiên Hoàng, Quận Hoàn Kiếm, Hà Nội",
            "ATM Hội sở \n57 Lý Thường Kiệt, Quận Hoàn Kiếm, Hà Nội",
            "ATM Nam Hà Nội \n236 Lê Thanh Nghị, Quận Hai Bà Trưng, Hà Nội",
            "ATM Hai Bà Trưng \n300-302 Trần Khát Chân, Quận Hai Bà Trưng, Hà Nội",
            "ATM Lê Ngọc Hân \n44 Lê Ngọc Hân, Quận Hai Bà Trưng, Hà Nội",
            "ATM Thăng Long \n29-131 Hoàng Quốc Việt, Quận Cầu Giấy, Hà Nội",
            "ATM Phạm Hùng \nTòa nhà FPT Phạm Hùng, Quận Cầu Giấy, Hà Nội",
            "ATM Khâm Thiên \n158 Khâm Thiên, Quận Đống Đa, Hà Nội"};

    private int mFlags[] = {R.drawable.atm_machine, R.drawable.atm_machine, R.drawable.atm_machine,
            R.drawable.atm_machine, R.drawable.atm_machine, R.drawable.atm_machine,
            R.drawable.atm_machine, R.drawable.atm_machine, R.drawable.atm_machine};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_layout);

        mListView = findViewById(R.id.hospitalListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), atm, mFlags);
        mListView.setAdapter(customAdapter);
    }
}