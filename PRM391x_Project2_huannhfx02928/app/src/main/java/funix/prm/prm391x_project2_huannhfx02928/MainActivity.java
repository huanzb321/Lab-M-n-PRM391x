package funix.prm.prm391x_project2_huannhfx02928;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
//    private ListView mListView;
//
//    private String atm[] = {
//            "ATM Hoàn Kiếm \n17 phố Lý Thường Kiệt, Phường Phan Chu Trinh, Quận Hoàn Kiếm, Hà Nội",
//            "ATM Đinh Tiên Hoàng \n7 Đinh Tiên Hoàng, Quận Hoàn Kiếm, Hà Nội",
//            "ATM Hội sở \n57 Lý Thường Kiệt, Quận Hoàn Kiếm, Hà Nội",
//            "ATM Nam Hà Nội \n236 Lê Thanh Nghị, Quận Hai Bà Trưng, Hà Nội",
//            "ATM Hai Bà Trưng \n300-302 Trần Khát Chân, Quận Hai Bà Trưng, Hà Nội",
//            "ATM Lê Ngọc Hân \n44 Lê Ngọc Hân, Quận Hai Bà Trưng, Hà Nội",
//            "ATM Thăng Long \n29-131 Hoàng Quốc Việt, Quận Cầu Giấy, Hà Nội",
//            "ATM Phạm Hùng \nTòa nhà FPT Phạm Hùng, Quận Cầu Giấy, Hà Nội",
//            "ATM Khâm Thiên \n158 Khâm Thiên, Quận Đống Đa, Hà Nội"};
//
//    private int mFlags[] = {R.drawable.atm_machine, R.drawable.atm_machine, R.drawable.atm_machine,
//            R.drawable.atm_machine, R.drawable.atm_machine, R.drawable.atm_machine,
//            R.drawable.atm_machine, R.drawable.atm_machine, R.drawable.atm_machine};

    @Override
    protected void onCreate(Bundle saveInstanceState) {
//        mListView = findViewById(R.id.atmListView);
//        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), atm, mFlags);
//        mListView.setAdapter(customAdapter);
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        FragmentMenu fragment = new FragmentMenu();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment);
        fragmentTransaction.commit();
    }

    public void fragmentHotelClick (View view) {
        FragmentHotel fragment = new FragmentHotel();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment);
        fragmentTransaction.commit();
    }

    public void fragmentAtmClick (View view) {
        FragmentAtm fragment = new FragmentAtm();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment);
        fragmentTransaction.commit();
    }

    public void fragmentHospitalClick (View view) {
        FragmentHospital fragment = new FragmentHospital();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment);
        fragmentTransaction.commit();
    }

    public void fragmentMetroClick (View view) {
        FragmentMetro fragment = new FragmentMetro();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment);
        fragmentTransaction.commit();
    }

}