package com.rls.twizz_000.timystry;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.Date;

/**
 * Created by twizz_000 on 3/16/2016.
 */
public class TimystryDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TimystryDB.db";
    public static final String TABLE_ASG = "asg";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ASGNAME = "_asgName";
    public static final String COLUMN_CLASSNAME = "_className";
    public static final String COLUMN_DUEDATE = "_dueDate";
    public static final String COLUMN_HOURS = "_hours";
    public static final String COLUMN_PRIORITY = "_priority";

    public TimystryDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ASG_TABLE = "CREATE TABLE " +
                TABLE_ASG + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_ASGNAME
                + " TEXT, " + COLUMN_CLASSNAME + " TEXT, " + COLUMN_DUEDATE + " DATE, " + COLUMN_HOURS + " INTEGER, " + COLUMN_PRIORITY + " INTEGER " + ")";
        db.execSQL(CREATE_ASG_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ASG);
        onCreate(db);
    }

    public void addAssignment(Asg asg) {

        SQLiteDatabase db = this.getWritableDatabase();

       ContentValues values = new ContentValues();
        values.put(COLUMN_ASGNAME, asg.getAsgName());
        values.put(COLUMN_CLASSNAME, asg.getClassName());
        values.put(COLUMN_DUEDATE, String.valueOf(asg.getDueDate()));//May need to review this later not sure of data type
        values.put(COLUMN_HOURS, asg.getHours());
        values.put(COLUMN_PRIORITY, asg.getPriority());



        db.insert(TABLE_ASG, null, values);
        db.close();
    }


      /**public Asg showAssignments()
      {
        String query = "Select * FROM _TABLE_ASG";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Asg assignment = new Asg();

          if(cursor.moveToFirst())
          {
              cursor.moveToFirst();
              assignment.setID(Integer.parseInt((cursor.getString(0))));
              assignment.setAsgName(cursor.getString(1));
              assignment.setClassName(cursor.getString(2));
              //assignment.setDueDate(cursor.getString(3));
              assignment.setHours(Integer.parseInt(cursor.getString(4)));
              assignment.setPriority(Integer.parseInt(cursor.getString(5)));

          }

      db.close();

          return assignment;
      }**/


}
