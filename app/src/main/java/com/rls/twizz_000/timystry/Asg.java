package com.rls.twizz_000.timystry;

import java.util.Date;

/**
 * Created by twizz_000 on 3/16/2016.
 */
public class Asg {
    private int _id;
    private String _asgName;
    private String _className;
    private Date _dueDate; //not sure of data type
    private int _hours;
    private int _priority;

    public Asg()
    {
    }

    public Asg (int id, String asgName, String className, Date dueDate, int hours, int priority)
    {
        this._id=id;
        this._asgName=asgName;
        this._className=className;
        this._dueDate=dueDate;
        this._hours=hours;
        this._priority=priority;
    }

    public Asg(String asgName, String className, Date dueDate, int hours, int priority)
    {
        this._asgName=asgName;
        this._className=className;
        this._dueDate=dueDate;
        this._hours=hours;
        this._priority=priority;
    }
//ID
    public void setID (int id)
    {
        this._id=id;
    }

    public int getID()
    {
        return this._id;
    }

//Asg Name
    public void setAsgName(String asgName)
    {
        this._asgName=asgName;
    }

    public String getAsgName()
    {
        return this._asgName;
    }

//Class Name
    public void setClassName(String className)
    {
        this._className=className;
    }

    public String getClassName()
    {
        return this._className;
    }

//Due Date
    public void setDueDate(Date dueDate)
    {
        this._dueDate=dueDate;  //not sure of this data type
    }

    public Date getDueDate()
    {
        return this._dueDate;
    }

//Hours
    public void setHours(int hours)
    {
        this._hours=hours;
    }

    public int getHours()
    {
        return this._hours;
    }

//Priority
    public void setPriority(int priority)
    {
        this._priority=priority;
    }

    public int getPriority()
    {
        return this._priority;
    }
}