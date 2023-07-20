package com.example.android_roomdatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact")//Setting table name

public class Contact {
    // below line is to auto increment id for each course.
    // variable for our id.
    @PrimaryKey(autoGenerate = true)
    private int empId;
    private String empName;
    private String empEmail;
    private String empAddress;
    private String notes;

    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically.

    public Contact(String empName, String empEmail, String empAddress, String notes) {
        this.empName = empName;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
        this.notes = notes;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
