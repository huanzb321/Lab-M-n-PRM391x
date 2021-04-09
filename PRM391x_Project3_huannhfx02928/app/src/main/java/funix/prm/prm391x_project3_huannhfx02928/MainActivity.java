package funix.prm.prm391x_project3_huannhfx02928;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    static final int CODE_REQUEST_EDIT = 1;
    static final String KEY_ADDING = "adding";
    static final String KEY_NUM = "num";
    static final String KEY_ID = "id";

    // List chứa các đối tượng BaoThuc được nạp từ database
    final ArrayList<BaoThuc> baoThucList;
    // Set chứa các đối tượng BaoThuc đang đổ chuông
    final HashSet<BaoThuc> dangDoChuong;

    TextView tvRing;
    ListView lv;
    BaoThucAdapter adapter;
    BaoThucDatabase baoThucDatabase;
    Context appContext;
    AlarmManager alarmManager;

    public MainActivity() { // Constructor
        super(R.layout.activity_main);
        baoThucList = new ArrayList<>();
        dangDoChuong = new HashSet<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Layout hiển thị đầu tiên

        tvRing = findViewById(R.id.tv_ring);
        lv = findViewById(R.id.listview);
        adapter = new BaoThucAdapter(this, R.layout.item_bao_thuc, baoThucList); // khởi tạo đối tượng
        lv.setAdapter(adapter);

        baoThucDatabase = new BaoThucDatabase(this);
        baoThucDatabase.open();
        appContext = getApplicationContext();
        alarmManager = (AlarmManager) appContext.getSystemService(ALARM_SERVICE);

        doChuong(getIntent());
        loadOrRefreshAll();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        doChuong(intent);
    }

    /**
     * Được gọi mỗi khi MainActivity khởi động hoặc nhận được Intent mới
     * Nếu Intent chứa ID trong Extra,
     *  từ ID xác định BaoThuc đang đổ chuông và đưa vào Set
     * Khi Set nhận phần tử thứ nhất, bật Service phát nhạc chuông
     */
    private void doChuong(Intent intent) {
        int id = intent.getIntExtra(KEY_ID, -1);
        if (id != -1) {
            BaoThuc baoThuc =  baoThucDatabase.get(id);
            dangDoChuong.add(baoThuc);
            if (dangDoChuong.size() == 1) {
                startService(new Intent(this, MyRingService.class));
                tvRing.setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * Được gọi khi MainActivity khởi động hoặc mỗi khi database có sự thay đổi
     * Cập nhật List, ListView (thông qua adapter), trạng thái Receiver và đăng ký AlarmManager
     */
    private void loadOrRefreshAll() {
        baoThucDatabase.loadOrRefresh(baoThucList);
        adapter.notifyDataSetChanged();
        checkReceiver();
        setAlarms();
    }

    /**
     * Bật/Tắt MyAlarmReceiver,
     *  đảm bảo không nhận BOOT_COMPLETED khi không có báo thức nào được bật
     */
    private void checkReceiver() {
        ComponentName myReceiver = new ComponentName(appContext, MyAlarmReceiver.class);
        PackageManager packageManager = appContext.getPackageManager();
        int oldState = packageManager.getComponentEnabledSetting(myReceiver),
                newState = oldState,
                enabled = PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                disabled = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
        if (baoThucDatabase.anyEnabled()) {
            if (oldState != enabled) {
                newState = enabled;
            }
        } else if (oldState != disabled) {
            newState = disabled;
        }
        if (newState != oldState) {
            packageManager.setComponentEnabledSetting(
                    myReceiver,
                    newState,
                    PackageManager.DONT_KILL_APP);
        }
    }

    /**
     * Cập nhật (đặt / hủy) các PendingIntent đăng ký với AlarmManager
     * Mỗi BaoThuc tương ứng với một Intent,
     *  phân biệt bằng cách dùng ID của BaoThuc đặt cho Action của Intent
     */
    private void setAlarms() {
        Intent intent = new Intent(appContext, MyAlarmReceiver.class);
        PendingIntent pendingIntent;
        Calendar calendar = Calendar.getInstance();
        int currentMinuteOfDay = calendar.get(Calendar.HOUR_OF_DAY) * 60
                + calendar.get(Calendar.MINUTE);

        for (BaoThuc baoThuc: baoThucList) {
            intent.setAction("" + baoThuc.getId());
            intent.putExtra(KEY_ID, baoThuc.getId());
            pendingIntent = PendingIntent.getBroadcast(appContext, 0, intent, 0);
            if (baoThuc.isEnabled()) {
                calendar.set(Calendar.HOUR_OF_DAY, baoThuc.getHour());
                calendar.set(Calendar.MINUTE, baoThuc.getMinute());
                calendar.set(Calendar.SECOND, 0);
                if (baoThuc.getHour() * 60 + baoThuc.getMinute()
                        <= currentMinuteOfDay) {
                    calendar.add(Calendar.DATE, 1);
                }
                alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis(),
                        pendingIntent);
            } else {
                alarmManager.cancel(pendingIntent);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // Hiển thị tên trang và Icon add
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onAddClick(MenuItem item) { // phương thức chạy khi nhấn vào Icon add
        onAddOrEditClick(-1);
    }

    /**
     * Được gọi khi nhấn Add hoặc Edit một báo thức
     * Khởi động EditAlarmActivity để thêm hoặc sửa báo thức, yêu cầu trả về kết quả
     * @param position Nếu nhấn Edit thì position >= 0, là vị trí của báo thức,
     *                 Nếu nhấn Add thì position = -1
     */
    public void onAddOrEditClick(int position) {
        boolean adding = (position == -1);
        Intent intent = new Intent(this, EditAlarmActivity.class);
        intent.putExtra(KEY_ADDING, adding);
        if (adding) {
            intent.putExtra(KEY_NUM, (baoThucList.size() + 1));
        } else {
            intent.putExtra(KEY_ID, baoThucList.get(position).getId());
        }
        startActivityForResult(intent, CODE_REQUEST_EDIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE_REQUEST_EDIT
                && resultCode == RESULT_OK) {
            loadOrRefreshAll();
        }
    }

    /**
     * Được gọi khi nhấn Delete một báo thức
     * Hủy đăng ký báo thức đó với AlarmManager và xóa khỏi database
     * @param position là vị trí của báo thức
     */
    public void onDeleteClick(int position) {
        BaoThuc baoThuc = baoThucList.get(position);
        tatChuong(baoThuc);
        Intent intent = new Intent(appContext, MyAlarmReceiver.class);
        intent.setAction("" + baoThuc.getId());
        PendingIntent pendingIntent =
                PendingIntent.getBroadcast(appContext, 0, intent, 0);
        alarmManager.cancel(pendingIntent);
        baoThucDatabase.delete(baoThuc);
        loadOrRefreshAll();
    }

    /**
     * Được gọi khi xóa hoặc tắt một BaoThuc
     * Thử loại bỏ BaoThuc khỏi HashSet dangdoChuong
     * Nếu là BaoThuc cuối cùng còn lại trong Set thì tắt Service nhạc chuông
     */
    private void tatChuong(BaoThuc baoThuc) {
        if (dangDoChuong.remove(baoThuc)
                && dangDoChuong.isEmpty()) {
            stopService(new Intent(this, MyRingService.class));
            tvRing.setVisibility(View.GONE);
        }
    }

    /**
     * Được gọi khi bật / tắt một báo thức
     * Cập nhật trạng thái mới của báo thức trong database
     * @param position vị trí của báo thức
     * @param isChecked trạng thái mới
     */
    public void onToggleItem(int position, boolean isChecked) {
        BaoThuc baoThuc = baoThucList.get(position);
        if (!isChecked) tatChuong(baoThuc);
        baoThuc.setEnabled(isChecked);
        baoThucDatabase.update(baoThuc);
        loadOrRefreshAll();
    }

    @Override
    protected void onDestroy() {
        baoThucDatabase.close();
        stopService(new Intent(this, MyRingService.class));
        super.onDestroy();
    }
}