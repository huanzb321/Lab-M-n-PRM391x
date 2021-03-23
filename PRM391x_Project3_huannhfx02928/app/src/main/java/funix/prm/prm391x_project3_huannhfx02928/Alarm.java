package funix.prm.prm391x_project3_huannhfx02928;

import android.content.ContentValues;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Alarm {
    private int id;
    private String name;
    private int hours;
    private int minutes;
    private boolean enabled;

    public Alarm(int id, String name, int hours, int minutes, boolean enabled) {
        this.id = id;
        this.name = name;
        this.hours = hours;
        this.minutes = minutes;
        this.enabled = enabled;
    }

    public Alarm() {
        this(0, "", 0, 0, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alarm alarm = (Alarm) o;
        return id == alarm.id;
    }

    public ContentValues contentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(LiteDatabase.ALARM_NAME, getName());
        contentValues.put(LiteDatabase.ALARM_HOURS, getHours());
        contentValues.put(LiteDatabase.ALARM_MINUTES, getMinutes());
        contentValues.put(LiteDatabase.ALARM_ENABLED, (enabled ? 1 : 0));
        return contentValues;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return null;
    }
}
