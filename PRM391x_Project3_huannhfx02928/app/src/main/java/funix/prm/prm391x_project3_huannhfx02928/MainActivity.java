package funix.prm.prm391x_project3_huannhfx02928;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    static final int CODE_REQUEST_EDIT = 1;
    static final String KEY_ADDING = "adding";
    static final String KEY_NUM = "num";
    static final String KEY_ID = "id";

    final ArrayList<Alarm> alarmsList;
    final HashSet<Alarm> isRinging;

    TextView tvRing;
    ListView listAlarm;
    ClockAdapter adapter;
    LiteDatabase dbHelper;
    Context appContext;
    AlarmManager alarmManager;

    public MainActivity() {
        super(R.layout.activity_main);
        alarmsList = new ArrayList<>();
        isRinging = new HashSet<>();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAlarm = findViewById(R.id.listAlarm);
        adapter = new ClockAdapter(this, R.layout.row_alarm, alarmsList);
        listAlarm.setAdapter(adapter);

        dbHelper = new LiteDatabase(this);
        dbHelper.open();
        appContext = getApplicationContext();
        alarmManager = (AlarmManager) appContext.getSystemService(ALARM_SERVICE);

        isRinging(getIntent());
        loadOrRefreshAll();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        isRinging(intent);
    }

    /**
     * Được gọi mỗi khi MainActivity khởi động hoặc nhận được Intent mới
     * Nếu Intent chứa ID trong Extra,
     *  từ ID xác định BaoThuc đang đổ chuông và đưa vào Set
     * Khi Set nhận phần tử thứ nhất, bật Service phát nhạc chuông
     */
    private void isRinging(Intent intent) {
        int id = intent.getIntExtra(KEY_ID, -1);
        if (id != -1) {
            Alarm alarm =  dbHelper.get(id);
            isRinging.add(alarm);
            if (isRinging.size() == 1) {
                startService(new Intent(this, RingSound.class));
                tvRing.setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * Được gọi khi MainActivity khởi động hoặc mỗi khi database có sự thay đổi
     * Cập nhật List, ListView (thông qua adapter), trạng thái Receiver và đăng ký AlarmManager
     */
    public void loadOrRefreshAll() {
        dbHelper.loadOrRefresh(alarmsList);
        adapter.notifyDataSetChanged();
        checkReceiver();
        setAlarms();
    }

    /**
     * Bật/Tắt MyAlarmReceiver,
     *  đảm bảo không nhận BOOT_COMPLETED khi không có báo thức nào được bật
     */
    private void checkReceiver() {
        ComponentName myReceiver = new ComponentName(appContext, BroadCast.class);
        PackageManager packageManager = appContext.getPackageManager();
        int oldState = packageManager.getComponentEnabledSetting(myReceiver),
                newState = oldState,
                enabled = PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                disabled = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
        if (dbHelper.anyEnabled()) {
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
        Intent intent = new Intent(appContext, BroadCast.class);
        PendingIntent pendingIntent;
        Calendar calendar = Calendar.getInstance();
        int currentMinuteOfDay = calendar.get(Calendar.HOUR_OF_DAY) * 60
                + calendar.get(Calendar.MINUTE);

        for (Alarm alarm: alarmsList) {
            intent.setAction("" + alarm.getId());
            intent.putExtra(KEY_ID, alarm.getId());
            pendingIntent = PendingIntent.getBroadcast(appContext, 0, intent, 0);
            if (alarm.isEnabled()) {
                calendar.set(Calendar.HOUR_OF_DAY, alarm.getHours());
                calendar.set(Calendar.MINUTE, alarm.getMinutes());
                calendar.set(Calendar.SECOND, 0);
                if (alarm.getHours() * 60 + alarm.getMinutes()
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

    public void onAddClick(View v) {
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
        Intent intent = new Intent(this, Clock.class);
        intent.putExtra(KEY_ADDING, adding);
        if (adding) {
            intent.putExtra(KEY_NUM, (alarmsList.size() + 1));
        } else {
            intent.putExtra(KEY_ID, position );
        }
        startService(new Intent(this, RingSound.class));
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

        Alarm alarm = alarmsList.get(position-1);
        //System.out.println(alarm.getHours());
        dbHelper.delete(alarm);
        loadOrRefreshAll();
    }

    /**
     * Called when delete or turn of alarm
     * @param alarm Alarm object
     */
    private void offSound(Alarm alarm) {
        if (isRinging.remove(alarm)
                && isRinging.isEmpty()) {
            stopService(new Intent(this, RingSound.class));
            tvRing.setVisibility(View.GONE);
        }
    }

    /**
     * Được gọi khi bật / tắt một báo thức
     * Cập nhật trạng thái mới của báo thức trong database
     * @param position locate of alarm
     * @param isChecked new state
     */
    public void onToggleItem(int position, boolean isChecked) {
        Alarm alarm = alarmsList.get(position);
        if (!isChecked) offSound(alarm);
        alarm.setEnabled(isChecked);
        dbHelper.update(alarm);
        loadOrRefreshAll();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        stopService(new Intent(this, RingSound.class));
        super.onDestroy();
    }
}