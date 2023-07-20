package com.example.android_roomdatabase;

import android.app.Application;

import java.util.List;

public class ContactRepository {
    // below line is the create a variable
    // for dao and list for all courses.
    public static Dao dao;

    // creating a constructor for our variables
    // and passing the variables to it.
    public ContactRepository(Application application) {
        ContactDatabase database =
                ContactDatabase.getInstance(application);
        dao = database.Dao();
    }

    // creating a method to insert the data to our database.
    public void insert(Contact contact) {
        dao.insert(contact);
    }

    // creating a method to update data in database.
    public void update(Contact contact) {
        dao.update(contact);
    }

    // creating a method to delete the data in our database.
    public void delete(Contact contact) {
        dao.delete(contact);
    }

    // below is the method to delete all the courses.
    public void deleteAll() {
        dao.deleteAllContacts();
    }

    // below method is to read all the courses.
    public List<Contact> getAll() {
        return dao.getAllContacts();
    }
}
