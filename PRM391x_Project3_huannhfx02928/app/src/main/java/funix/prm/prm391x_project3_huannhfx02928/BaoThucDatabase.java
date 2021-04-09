package funix.prm.prm391x_project3_huannhfx02928;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BaoThucDatabase extends SQLiteOpenHelper { // Lưu giữ thông tin các giờ hẹn

    public static final int DB_VER = 1;
    public static final String DB_NAME = "BaoThuc.db";
    public static final String TABLE_NAME = "bao_thuc";
    public static final String ALARM_ID = "key_id";
    public static final String ALARM_NAME = "key_name";
    public static final String ALARM_HOUR = "key_hour";
    public static final String ALARM_MINUTE = "key_minute";
    public static final String ALARM_ENABLED = "key_enabled";

    private SQLiteDatabase mDb;

    public BaoThucDatabase(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    public void open() {
        mDb = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                + ALARM_ID + " INTEGER PRIMARY KEY,"
                + ALARM_NAME + " TEXT,"
                + ALARM_HOUR + " INTEGER,"
                + ALARM_MINUTE + " INTEGER,"
                + ALARM_ENABLED + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void add(BaoThuc baoThuc) { // thêm mốc thời gian báo thức
        mDb.insert(TABLE_NAME, null, baoThuc.toContentValues());
    }

    public void loadOrRefresh(ArrayList<BaoThuc> baoThucList ) {
        baoThucList.clear();
        Cursor cursor = mDb.query(
                TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(ALARM_ID));
            String name = cursor.getString(cursor.getColumnIndex(ALARM_NAME));
            int hour = cursor.getInt(cursor.getColumnIndex(ALARM_HOUR));
            int minute = cursor.getInt(cursor.getColumnIndex(ALARM_MINUTE));
            boolean enabled = (cursor.getInt(cursor.getColumnIndex(ALARM_ENABLED))
                    == 1);
            baoThucList.add(new BaoThuc(id, name, hour, minute, enabled));
        }
        cursor.close();
    }

    public BaoThuc get(int id) {
        BaoThuc baoThuc;
        Cursor cursor = mDb.query(
                TABLE_NAME,
                null,
                (ALARM_ID + " = ?"),
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndex(ALARM_NAME));
            int hour = cursor.getInt(cursor.getColumnIndex(ALARM_HOUR));
            int minute = cursor.getInt(cursor.getColumnIndex(ALARM_MINUTE));
            boolean enabled = (cursor.getInt(cursor.getColumnIndex(ALARM_ENABLED))
                    == 1);
            baoThuc = new BaoThuc(id, name, hour, minute, enabled);
        } else {
            baoThuc = new BaoThuc();
        }
        cursor.close();
        return baoThuc;
    }

    public boolean anyEnabled() {
        boolean result = false;
        Cursor cursor = mDb.query(
                TABLE_NAME,
                new String[]{ALARM_ENABLED},
                null,
                null,
                null,
                null,
                null);
        int col = cursor.getColumnIndex(ALARM_ENABLED);
        while (cursor.moveToNext()) {
            if (cursor.getInt(col) == 1) {
                result = true;
                break;
            }
        }
        cursor.close();
        return result;
    }

    public void update(BaoThuc baoThuc) { // cập nhật khi thay đổi thời gian
        mDb.update(
                TABLE_NAME,
                baoThuc.toContentValues(),
                (ALARM_ID + " = ?"),
                new String[]{String.valueOf(baoThuc.getId())});
    }

    public void delete(BaoThuc baoThuc) { // xóa bổ thời gian đã đặt
        mDb.delete(TABLE_NAME, (ALARM_ID + " = ?"), new String[]{String.valueOf(baoThuc.getId())});
    }
}
