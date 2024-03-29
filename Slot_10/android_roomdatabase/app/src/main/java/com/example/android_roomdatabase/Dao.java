package com.example.android_roomdatabase;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// adding annotation to our Dao class
@androidx.room.Dao
public interface Dao {
    // below method is use to add data to database.
    @Insert
    void insert(Contact model);

    // below method is use to update the data in our database.
    @Update
    void update(Contact model);

    // below line is use to delete a specific course in our database.
    @Delete
    void delete(Contact model);

    // on below line we are making query to delete all courses from our database.
    @Query("DELETE FROM contact")
    void deleteAllContacts();

    // below line is to read all the courses from our database.
    // in this we are ordering our courses in ascending order with our course name.
    @Query("SELECT * FROM contact ORDER BY empName ASC")
    List<Contact> getAllContacts();
}