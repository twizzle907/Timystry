package com.rls.twizz_000.timystry;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ShowAssignments extends AppCompatActivity {


    private Context context; //idk


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_assignments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;//idk
        //declare db instance
        TimystryDbHandler dbHandler = new TimystryDbHandler(context, null, null, 1);//idk
        //declare layout
        TableLayout tablelayout = (TableLayout) findViewById(R.id.tablelayout);//idk
        //header
        TableRow rowHeader = new TableRow(context);//idk
        //rowHeader.setBackgroundColor(Color.parseColor("#FFF"));//idk
        rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));//idk
        String[] headerText = {"ID", "ASG Name", "Class", "Due", "Hours", "Priority"};//idk
        for (String c : headerText)//idk
        {
            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            //tv.setGravity(Gravity.CENTER);
            tv.setTextSize(18);
            tv.setPadding(5, 5, 5, 5);
            tv.setText(c);
            rowHeader.addView(tv);
        }
        tablelayout.addView(rowHeader);//idk
//get data
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        db.beginTransaction();
        try {
            String query = "SELECT * FROM " + TimystryDbHandler.TABLE_ASG;
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    int ID = cursor.getInt(cursor.getColumnIndex(("_id")));
                    String ASGName = cursor.getString(cursor.getColumnIndex(("_asgName")));
                    String ClassName = cursor.getString(cursor.getColumnIndex(("_className")));
                    String dueDate = cursor.getString(cursor.getColumnIndex(("_dueDate")));
                    int hours = cursor.getInt(cursor.getColumnIndex(("_hours")));
                    String priority = cursor.getString(cursor.getColumnIndex(("_priority")));

                    //rows
                    TableRow row = new TableRow(context);
                    row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));

                    String[] colText = {ID+" " + ASGName + " " + ClassName + " " + dueDate + " " + hours + " " + priority};//String.valueOf(ID), ASGName, ClassName, String.valueOf(dueDate), String.valueOf(hours), String.valueOf(priority)};//{ID + "" + ASGName + "" + ClassName + "" + dueDate + "" + hours + "" + priority};

                    for (String text : colText) {
                        TextView tv = new TextView(this);
                        tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT));
                        tv.setGravity(Gravity.CENTER);
                        tv.setTextSize(16);
                        tv.setPadding(5, 5, 5, 5);
                        tv.setText(text);
                        row.addView(tv);
                    }
                    tablelayout.addView(row);
                }

            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            db.close();
        }
    }
}
