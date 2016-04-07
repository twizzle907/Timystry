package com.rls.twizz_000.timystry;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewAssignment extends AppCompatActivity {

    TextView idView;
    EditText asgBox;
    EditText classBox;
    EditText dateBox;
    EditText hoursBox;
    EditText priorityBox;

    //@SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_assignment);
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
        idView = (TextView) findViewById(R.id.asgID);
        asgBox = (EditText) findViewById(R.id.asgName); //suppressed error
        classBox =(EditText) findViewById(R.id.className); //suppressed error
        dateBox = (EditText) findViewById(R.id.dueDate);
        hoursBox = (EditText) findViewById(R.id.hours);
        priorityBox = (EditText) findViewById(R.id.priority);

    }

    public void newAsg (View view) throws ParseException {
        TimystryDbHandler dbHandler = new TimystryDbHandler(this, null, null, 1);

        String dateString = dateBox.getText().toString();
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        Date date = format.parse(dateString);
        int hours = Integer.parseInt(hoursBox.getText().toString());
        int priority = Integer.parseInt(priorityBox.getText().toString());
        Asg asg = new Asg(asgBox.getText().toString(), classBox.getText().toString(), date, hours, priority);

        dbHandler.addAssignment(asg);
        asgBox.setText("");
        classBox.setText("");
        dateBox.setText("");
        hoursBox.setText("");
        priorityBox.setText("");
    }

    public void viewAll(View view)
    {
        TimystryDbHandler dbHandler = new TimystryDbHandler(this, null, null, 1);

    }

    public void openMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
