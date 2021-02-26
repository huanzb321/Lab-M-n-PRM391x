package funix.prm.prm391x_project2_huannhfx02928;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity  extends AppCompatActivity {
    private ListView mListView;

    List<Item> atmList = new ArrayList<>();

    private void addListATM(){
        atmList.add(new Item("ATM Hoàn Kiếm"));
        atmList.add(new Item("ATM Đinh Tiên Hoàng"));

    }
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setHomeFragment ();
    }

    public void setHomeFragment () {
        FragmentMenu fragment = new FragmentMenu();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
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

        //mListView = findViewById(R.id.atmListView);
        addListATM();
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.row_item, atmList);

        FragmentAtm fragment = new FragmentAtm(customAdapter);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment);
        fragmentTransaction.addToBackStack("activity_atm_layout");
        fragmentTransaction.commit();


       // mListView.setAdapter(customAdapter);
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

    public void back (View view ) {
        FragmentMenu fragment = new FragmentMenu();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment);
        fragmentTransaction.commit();
    }
}