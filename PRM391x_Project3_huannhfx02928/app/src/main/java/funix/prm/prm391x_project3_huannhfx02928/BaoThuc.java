package funix.prm.prm391x_project3_huannhfx02928;

import android.content.ContentValues;

import java.util.Objects;

public class BaoThuc { // Khởi tạo thuộc tính và giá trị của đồng hồ báo thức
    private final int id;
    private String name;
    private int hour;
    private int minute;
    private boolean enabled;

    public BaoThuc(int id, String name, int hour, int minute, boolean enabled) {
        this.id = id;
        this.name = name;
        this.hour = hour;
        this.minute = minute;
        this.enabled = enabled;
    }

    public BaoThuc() {
        this(0, "", 0, 0, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaoThuc baoThuc = (BaoThuc) o;
        return id == baoThuc.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaoThucDatabase.ALARM_NAME, name);
        contentValues.put(BaoThucDatabase.ALARM_HOUR, hour);
        contentValues.put(BaoThucDatabase.ALARM_MINUTE, minute);
        contentValues.put(BaoThucDatabase.ALARM_ENABLED, (enabled ? 1 : 0));
        return contentValues;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
