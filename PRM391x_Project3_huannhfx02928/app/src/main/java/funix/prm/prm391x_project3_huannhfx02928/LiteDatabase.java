package funix.prm.prm391x_project3_huannhfx02928;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class LiteDatabase extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String DB_NAME = "ALARM.db";
    public static final String TABLE_NAME = "ALARM";
    public static final String ALARM_ID = "_id";
    public static final String ALARM_NAME = "_name";
    public static final String ALARM_HOURS = "_hour";
    public static final String ALARM_MINUTES = "_minute";
    public static final String ALARM_ENABLED = "_enabled";

    private SQLiteDatabase db;

    public  Context c;

    public LiteDatabase(Context context) {
        super(context, DB_NAME, null, VERSION);
        c = context;
    }

    public void open() {
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                + ALARM_ID + " INTEGER PRIMARY KEY,"
                + ALARM_NAME + " TEXT,"
                + ALARM_HOURS + " INTEGER,"
                + ALARM_MINUTES + " INTEGER,"
                + ALARM_ENABLED + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void add(Alarm alarm) {
        db.insert(TABLE_NAME, null, alarm.contentValues());
    }

    public void loadOrRefresh(ArrayList<Alarm> alarms ) {
        alarms.clear();
        Cursor cursor = db.query(
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
            int hour = cursor.getInt(cursor.getColumnIndex(ALARM_HOURS));
            int minute = cursor.getInt(cursor.getColumnIndex(ALARM_MINUTES));
            boolean enabled = (cursor.getInt(cursor.getColumnIndex(ALARM_ENABLED))
                    == 1);
            alarms.add(new Alarm(id, name, hour, minute, enabled));


        }
        cursor.close();
    }

    public Alarm get(int id) {
        Alarm alarm;



        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{ALARM_ID,ALARM_NAME,ALARM_HOURS,ALARM_MINUTES,ALARM_ENABLED},
                ALARM_ID + "= " + (id+1),
                null,
                null,
                null,
                null);
        //Toast.makeText(c.getApplicationContext(),  cursor.getCount() + "", Toast.LENGTH_SHORT).show();
        //Toast.makeText(c.getApplicationContext(),  id+"_", Toast.LENGTH_SHORT).show();

        if (cursor.moveToFirst()) {
            int id1 = cursor.getInt(cursor.getColumnIndex(ALARM_ID));
            String name = cursor.getString(cursor.getColumnIndex(ALARM_NAME));
            int hour = cursor.getInt(cursor.getColumnIndex(ALARM_HOURS));
            int minute = cursor.getInt(cursor.getColumnIndex(ALARM_MINUTES));
            boolean enabled = (cursor.getInt(cursor.getColumnIndex(ALARM_ENABLED))
                    == 1);
            alarm = new Alarm(id, name, hour, minute, enabled);
            //Toast.makeText(c.getApplicationContext(),  id1+"_"+id+"_"+ hour, Toast.LENGTH_SHORT).show();
        } else {
            alarm = new Alarm();

        }
        cursor.close();
        return alarm;
    }

    public boolean anyEnabled() {
        boolean result = false;
        Cursor cursor = db.query(
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

    public void update(Alarm alarms) {
        db.update(
                TABLE_NAME,
                alarms.contentValues(),
                (ALARM_ID + " = ?"),
                new String[]{String.valueOf(alarms.getId())});
    }

    public void delete(Alarm alarms) {
        db.delete(TABLE_NAME, ALARM_ID + "=" + alarms.getId(),null);
    }
}
