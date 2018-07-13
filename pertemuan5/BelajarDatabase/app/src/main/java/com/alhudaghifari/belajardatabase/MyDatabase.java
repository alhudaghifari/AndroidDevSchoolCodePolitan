package com.alhudaghifari.belajardatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghifar on 13/07/18.
 */

public class MyDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "todo_db";
    private static final String TABLE_TODO = "todo_table";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TODO_NAME = "name";
    private static final String COLUMN_TODO_PRIORITY = "priority";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TODO_TABLE = "CREATE TABLE " +
                TABLE_TODO +
                "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY," +
                COLUMN_TODO_NAME +
                " TEXT," +
                COLUMN_TODO_PRIORITY +
                " INTEGER" + ")";
        db.execSQL(CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        onCreate(db);
    }

    public void addItem(Item item){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TODO_NAME, item.getName());
        values.put(COLUMN_TODO_PRIORITY, item.getPriority());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_TODO, null, values);
    }

    public List<Item> getAll(){
        String sql = "select * from " + TABLE_TODO;
        SQLiteDatabase db = this.getReadableDatabase();
        List<Item> items = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                int priority = cursor.getInt(2);
                items.add(new Item(id, name, priority));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return items;
    }

    public void updateItem(Item item){

        Log.d("MyDatabase", "id = " + item.getId() +
                "\n name : " + item.getName() +
                "\n priority : " + item.getPriority());


        ContentValues values = new ContentValues();
        values.put(COLUMN_TODO_NAME, item.getName());
        values.put(COLUMN_TODO_PRIORITY, item.getPriority());
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_TODO, values, COLUMN_ID + " = ?", new
        String[] { String.valueOf(item.getId())});
    }

    public void deleteItem(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TODO,
                COLUMN_ID + " = ?", new String[]
        { String.valueOf(id)});
    }
}
