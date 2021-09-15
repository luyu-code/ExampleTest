package com.example.exampletest.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.exampletest.entity.Student;

import java.util.ArrayList;

public class StudentSQLiteDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "StudentSQLiteDBHelper";
    //声明数据库的名称
    private static final String DB_NAME = "Student.db";
    //声明表的名称
    private static final String TABLE_NAME = "student";
    //声明数据库的版本号
    private static final int DB_VERSION = 1;
    //声明数据库帮助器的实例
    private static StudentSQLiteDBHelper mHelper = null;
    //声明数据库的实例
    private SQLiteDatabase mDB = null;

    public StudentSQLiteDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public StudentSQLiteDBHelper(@Nullable Context context, int version) {
        super(context, DB_NAME, null, version);
    }

    //获取数据库帮助器的唯一实例
    public static StudentSQLiteDBHelper getInstance(Context context, int version) {
        if (version > 0 && mHelper == null) {
            mHelper = new StudentSQLiteDBHelper(context, version);
        } else if (mHelper == null) {
            mHelper = new StudentSQLiteDBHelper(context);
        }
        return mHelper;
    }

    //打开数据库的读与写连接
    public SQLiteDatabase openReadLink() {
        if (mDB == null || !mDB.isOpen()) {
            mDB=mHelper.getReadableDatabase();
        }
        return mDB;
    }

    //关闭数据的连接
    public SQLiteDatabase closeLink() {
        if (mDB.isOpen() && mDB != null) {
            mDB.close();
            mDB = null;
        }
        return mDB;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String drop_sql = " DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        db.execSQL(drop_sql);

        String create_sql = " CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name VARCHAR," + "grade VARCHAR," + "major VARCHAR," +
                "age INTEGER," + "sex VARCHAR" + ");";
        db.execSQL(create_sql);
    }

    //向表中添加一条数据
    public long insert(Student student) {
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(student);
        return insert(arrayList);
    }

    //往表中添加多条数据
    public long insert(ArrayList<Student> arrayList) {
        long result = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            Student student = arrayList.get(i);
            ContentValues cv = new ContentValues();
            cv.put("name", student.name);
            cv.put("grade", student.grade);
            cv.put("major", student.major);
            cv.put("age", student.age);
            cv.put("sex", student.sex);
            result = mDB.insert(TABLE_NAME, "", cv);
            //如果添加成功则返回行号，否则返回-1
            if (result == -1) {
                return result;
            }
        }
        return result;
    }

    //根据指定条件删除表记录
    public int delete(String condition) {
        return mDB.delete(TABLE_NAME, condition, null);
    }

    //删除表中所有记录
    public int deleteAll() {
        //执行删除记录动作，该语句返回删除记录的动作
        return mDB.delete(TABLE_NAME, "1=1", null);
    }


    public int update(Student student) {
        //执行更新记录动作，该语句返回记录更新的数目
        return update(student, "rowid=" + student.rowid);
    }

    //根据条件更新指定的表记录
    private int update(Student student, String condition) {
        ContentValues cv = new ContentValues();
        cv.put("name", student.name);
        cv.put("grade", student.grade);
        cv.put("major", student.major);
        cv.put("age", student.age);
        cv.put("sex", student.sex);
        return mDB.update(TABLE_NAME, cv, condition, null);
    }

    //根据指定条件查询记录，并返回结果数据队列
    public ArrayList<Student> query(String condition) {
        String sql = String.format("select name,grade,major,age,sex" + " from %s where %s;", TABLE_NAME, condition);
        ArrayList<Student> studentArrayList = new ArrayList<>();
        Cursor cursor = mDB.rawQuery(sql, null);
        //循环取出游标指向的指向的每条记录
        while (cursor.moveToNext()) {
            Student student = new Student();
            student.rowid = cursor.getLong(cursor.getColumnIndex("_id"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.grade = cursor.getString(cursor.getColumnIndex("grade"));
            student.major = cursor.getString(cursor.getColumnIndex("major"));
            student.age = cursor.getInt(cursor.getColumnIndex("age"));
            student.sex = cursor.getString(cursor.getColumnIndex("sex"));
            studentArrayList.add(student);
        }
        //关闭游标查询完毕
        cursor.close();
        return studentArrayList;
    }


    //升级数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
