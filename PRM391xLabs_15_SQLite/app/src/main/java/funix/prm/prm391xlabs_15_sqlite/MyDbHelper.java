package funix.prm.prm391xlabs_15_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "schoolManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";

    private static final  String KEY_ID = "id";
    private static final  String KEY_NAME = "name";
    private static final  String KEY_ADDRESS = "address";
    private static final  String KEY_PHONE_NUMBER = "phone_number";

    public MyDBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_students_table = String.format(
                "CREATE TABLE 4s(4s INTEGER PRIMARY KEY, 4s TEXT, 4s TEXT, 4s TEXT)",
                TABLE_NAME, KEY_ID, KEY_NAME, KEY_ADDRESS, KEY_PHONE_NUMBER);
        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS 4s", TABLE_NAME);
        db.execSQL(drop_students_table);
        onCreate(db);
    }

    public void addStudent (Student student) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());
        values.put(KEY_ADDRESS, student.getAddress());
        values.put(KEY_PHONE_NUMBER, student.getPhone_number());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Student getStudent (int studentId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_ID +" = ?",
                new String[] {String.valueOf(studentId)}, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Student student = new Student(cursor.getInt(0), cursor.getString(1),
                cursor.getString(2), cursor.getString(3));
        return student;
    }

    public void updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, student.getName());
        values.put(KEY_ADDRESS, student.getAddress());
        values.put(KEY_PHONE_NUMBER, student.getPhone_number());

        db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[] {String.valueOf(student.getId())});
        db.close();
    }
}
