package com.example.android_roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    private BluetoothReceiver bluetoothReceiver;
    private ArrayList<Contact> contacts;
    private ContactRVAdapter adapter;
    private RecyclerView rvCourses;
    ContactRepository res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        bluetoothReceiver = new BluetoothReceiver();
        // getting data
        res = new ContactRepository(getApplication());
        contacts = new ArrayList<Contact>();
        List<Contact> data = res.getAll();
        for (int i = 0; i < data.size(); i++) {
            String name = data.get(i).getEmpName();
            String email = data.get(i).getEmpEmail();
            String address = data.get(i).getEmpAddress();
            String note = data.get(i).getNotes();
            contacts.add(new Contact(name, email, address, note));
        }
        //Passing array list to our adapter class
        adapter = new ContactRVAdapter(contacts,
                ViewActivity.this);
        //Creating recycler view
        rvCourses = findViewById(R.id.rvEmps);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewActivity.this, RecyclerView.VERTICAL,
                false);
        rvCourses.setLayoutManager(linearLayoutManager);
        rvCourses.setAdapter(adapter);
        //Setting our adapter to recycler view
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(bluetoothReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(bluetoothReceiver);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_add_new) {
            // Handle the "Add new" menu item click here
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}