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
    List<Item> hotelList = new ArrayList<>(); // mảng thuộc tính của Item
    List<Item> atmList = new ArrayList<>();
    List<Item> hospitalList = new ArrayList<>();
    List<Item> metroList = new ArrayList<>();

    private void addListHotel() { //
        for (int i = 0 ; i < hotel.length ; i++) {
            hotelList.add(new Item(hotel[i])); // add danh sách hiển thị thông tin hotel vào mảng hotelList
        }
    }
    private void addListATM() {
        for (int i = 0 ; i < atm.length ; i++) {
            atmList.add(new Item(atm[i])); // add danh sách hiển thị thông tin atm vào mảng atmList
        }
    }
    private void addListHospital() {
        for (int i = 0 ; i < hospital.length ; i++) {
            hospitalList.add(new Item(hospital[i])); // add danh sách hiển thị thông tin hospital vào mảng hospitalList
        }
    }
    private void addListMetro() {
        for (int i = 0 ; i < metro.length ; i++) {
            metroList.add(new Item(metro[i])); // add danh sách hiển thị thông tin metro vào mảng metroList
        }
    }

    private String hotel [] = { // Mảng thông tin hiển thị
            "OYO 472 Lenka \n124 Phố Thú Y, Đức Thượng, ward, Hà Nội, Việt Nam", //https://goo.gl/maps/JhBMjnrVLjAvYbFa8
            "Trường Linh \nngõ 33 Tu Hoàng, Xuân Phương, Nam Từ Liêm, Hà Nội, Việt Nam", // https://goo.gl/maps/myFtCFxbVKoTX339A
            "French-styled house \nAlley 41/199, No. 7 Đường Hồ Tùng Mậu, Hà Nội, Việt Nam", //https://goo.gl/maps/ihtgXSeckKeZGVNW9
            "Bounty Hotel \n19 Ngõ 5 Đường Lê Đức Thọ, Mai Dịch, Cầu Giấy, Hà Nội, Việt Nam", //https://goo.gl/maps/ZJW8PYjUwAdn8hd39
            "King's Hotel Mỹ Đình \nBiệt thự A14, BT1, Phố Bùi Xuân Phái, khu đô thị, Nam Từ Liêm, Hà Nội, Việt Nam", //https://goo.gl/maps/gB9gjfg15N8K5bmo7
            "T&M Luxury Hotel Hanoi \n89 Đường Lê Đức Thọ, P, Từ Liêm, Hà Nội, Việt Nam", //https://g.page/tmluxuryhotelhanoi?share
            "My Way Seafood \nSố 2 Ngõ 86 Duy Tân, Dịch Vọng Hậu, Cầu Giấy, Hà Nội 10000, Việt Nam", //https://goo.gl/maps/9DnGEsGTssM5SAPD9
            "Ping Hotel Mỹ Đình \n26-28 Mễ Trì Hạ, Mễ Trì, Từ Liêm, Hà Nội, Việt Nam" //https://goo.gl/maps/LgVzZpk2zmK81LFq6
    };

    private String atm [] = {
            "ATM Vietcombank \nQL32, Đan Phượng, Hà Nội", // https://goo.gl/maps/dRAxX6WN4jiUcgBC8
            "ATM MB Bank \n97 Phan Đình Phùng, Đan Phượng, Hà Nội", // https://goo.gl/maps/c5wdwoYfdYgrtVh67
            "ATM BIDV \nUnnamend Road, Tân Lập, Đan Phượng, Hà Nội", // https://goo.gl/maps/YpdV4uev3z7PW4BG6
            "ATM Kỹ Thương (Techcombank) \n135 Tây Sơn, TT.Phùng, Đan Phượng, Hà Nội", // https://goo.gl/maps/CSdYGpuEFSCMe1Dq8
            "ATM Vietinbank \nQL32, TT.Trạm Trôi, Hoài Đức, Hà Nội", // https://goo.gl/maps/Kwe2BpZpXuebnKF48
            "ATM HDBank \nKhu 6, Thị Trấn Phạm Trôi, Huyện Hoài Đức, TT. Trạm Trôi, Hoài Đức, Hà Nội", //https://goo.gl/maps/yRdwZxV8wgxMzGKw6
            "ATM Agribank \nĐường Không Tên, TT. Trạm Trôi, Hoài Đức, Hà Nội", // https://goo.gl/maps/W4UWPYAog8DqqJ96A
            "ATM PG Bank \nQL32, Đức Giang, Hoài Đức, Hà Nội", // https://goo.gl/maps/iwTm5iWskBMLr4uA8
            "ATM Techcombank \nPhúc Diễn, Từ Liêm, Hà Nội, Việt Nam"}; // https://goo.gl/maps/qN8jCgjopZ94zfQR9

    private String hospital [] = {
            "Bệnh viện Đa Khoa Đan Phượng \nTân Hội – Đan Phượng – Hà Nội", // https://goo.gl/maps/efDxFeosDkXKU1nN7
            "Bệnh Viện Đa Khoa Hoài Đức \nThôn Lũng Kênh - Đức Giang - Hoài Đức - Hà Nội", // https://goo.gl/maps/T35A59b73Wem3T8x5
            "Bệnh Viện E, Hà Nội \n89 – Trần Cung – Nghĩa Tân – Cầu Giấy – Hà Nội", // https://goo.gl/maps/zwTKiwDikUJWrf6EA
            "Bệnh viện Quốc Oai \nTT.Quốc Oai - Quốc Oai – Hà Nội", // https://goo.gl/maps/gtPf8dCyeqmq9oQF7
            "Bệnh Viện Vinmec \nTây Mỗ - Từ Liêm – Hà Nội", // https://goo.gl/maps/USCnwJHqaqAXEPVx7
            "Bệnh Viện K trung ương cơ sở 3 \nĐồng Quang - Quốc Oai - Hà Nội", // https://goo.gl/maps/dRXxv8s1oBtDR9A46
            "Bệnh viện Đa Khoa Chương Mĩ \n120 DDT419 - Ngọc Hà - Chương Mĩ – Hà Nội", // https://goo.gl/maps/mbfDQPA9bgbgjcQM7
            "Bệnh Viện Mắt TW cơ sở 2 \nUnnamed Road - Từ Liêm – Hà Nội", // https://goo.gl/maps/m4iws7SaJgpj3FHz5
            "Phòng Khám 108 Tam Hiệp \nBến xe - Tam Hiệp - Phúc Thọ – Hà Nội", // https://goo.gl/maps/f7ttDPEnoaLL8KQAA
            "Bệnh Viện 198 \nMai Dịch - Cầu Giấy – Hà Nội"}; // https://goo.gl/maps/xocn2fpYRfH7eNLQA

    private String metro [] = {
            "Tuyến 20A \nCầu Giấy - Phùng", "Tuyến 20B \nCầu Giấy - Sơn Tây",
            "Tuyến 70A \nBX Mỹ Đình - Trung Hà", "Tuyến 70B \nBx Mĩ Đình - Phú Cường",
            "Tuyến 29 \nBX Giáp Bát - Tân Lập", "Tuyến 57 \nNam Thăng Long - KCN Phú Nghĩa",
            "Tuyến 49 \nTrần Khánh Dư - KĐT Mỹ Đình II", "Tuyến 89 \nBX Yên Nghĩa - Bx Sơn Tây",
            "Tuyến 74 \nXuân Khanh - BX Mỹ Đình"};

    private int imageHotel [] = { // Mảng ảnh hotel
            R.drawable.hotel, R.drawable.hotel, R.drawable.hotel,
            R.drawable.hotel, R.drawable.hotel, R.drawable.hotel,
            R.drawable.hotel, R.drawable.hotel};

    private int imageAtm [] = { // Mảng ảnh atm
            R.drawable.atm_machine, R.drawable.atm_machine, R.drawable.atm_machine,
            R.drawable.atm_machine, R.drawable.atm_machine, R.drawable.atm_machine,
            R.drawable.atm_machine, R.drawable.atm_machine, R.drawable.atm_machine};

    private int imageHospital [] = { // Mảng ảnh hospital
            R.drawable.hospital, R.drawable.hospital, R.drawable.hospital,
            R.drawable.hospital, R.drawable.hospital, R.drawable.hospital,
            R.drawable.hospital, R.drawable.hospital, R.drawable.hospital,
            R.drawable.hospital, R.drawable.hospital};

    private int imageMetro [] = { // Mảng ảnh metro
            R.drawable.metro, R.drawable.metro, R.drawable.metro,
            R.drawable.metro, R.drawable.metro, R.drawable.metro,
            R.drawable.metro, R.drawable.metro, R.drawable.metro};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Layout hình hiển thị đầu tiên

        FragmentMenu fragment = new FragmentMenu(); // Khởi tại đối gượng trong FragmentMenu
        FragmentManager fragmentManager = getSupportFragmentManager(); // Quản lý fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); // Tương tác fragment thêm vào cái gì đó
        fragmentTransaction.replace(R.id.fragment_switch, fragment); // add FragmentMenu vào khung
        fragmentTransaction.commit(); // Để xác nhận
    }

    public void fragmentHotelClick (View view) { // Người dùng chọn thông tin hotel để tra cứu
        addListHotel();
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.row_item, hotelList, imageHotel);

        FragmentHotel fragment = new FragmentHotel(customAdapter);
        FragmentManager fragmentManager = getSupportFragmentManager(); // Quản lý
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment); // add FragmentHote vào khung
        fragmentTransaction.commit(); // Để xác nhận
    }

    public void fragmentAtmClick (View view) { // Người dùng chọn thông tin atm để tra cứu
        addListATM();
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.row_item, atmList, imageAtm);

        FragmentAtm fragment = new FragmentAtm(customAdapter);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment); // add FragmentMenu vào khung
        fragmentTransaction.commit(); // Để xác nhận
    }

    public void fragmentHospitalClick (View view) { //Người dùng chọn thông tin hospital để tra cứu
        addListHospital();
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.row_item, hospitalList, imageHospital);

        FragmentHospital fragment = new FragmentHospital(customAdapter);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment); // add FragmentMenu vào khung
        fragmentTransaction.commit(); // Để xác nhận
    }

    public void fragmentMetroClick (View view) { // Người dùng chọn thông tin metro để tra cứu
        addListMetro();
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.row_item, metroList, imageMetro);

        FragmentMetro fragment = new FragmentMetro(customAdapter);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment); // add FragmentMenu vào khung
        fragmentTransaction.commit(); // Để xác nhận
    }

    public void back (View view ) { // Sử dụng để khi click vào nút back thì quay lại màn hình chính
        FragmentMenu fragment = new FragmentMenu();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, fragment); // add FragmentMenu vào khung
        fragmentTransaction.commit(); // Để xác nhận
    }
}