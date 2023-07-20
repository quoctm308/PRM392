package com.example.android_roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private BluetoothReceiver bluetoothReceiver;
    private EditText edtEmpName, edtEmpEmail, edtEmpAddress, edtNotes;
    private Button btnAddEmp, btnReadEmp;
    ContactRepository res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initializing all our variables
        edtEmpName = findViewById(R.id.edtName);
        edtEmpEmail = findViewById(R.id.edtEmail);
        edtEmpAddress = findViewById(R.id.edtAddress);
        edtNotes = findViewById(R.id.edtNote);
        btnAddEmp = findViewById(R.id.btnAddEmp);
        bluetoothReceiver = new BluetoothReceiver();
        res = new ContactRepository(getApplication());
        btnAddEmp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addEmp();
            }
        });
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
            showToast("Add new clicked!");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addEmp() {
        //Getting data from all edit text fields
        Contact contact = new Contact(edtEmpName.getText().toString(), edtEmpEmail.getText().toString(),
                edtEmpAddress.getText().toString(), edtNotes.getText().toString());
        //Adding a new course to sqlite data and pass all our values to it.
        res.insert(contact);
        //After adding the data we are displaying a toast message
        Toast.makeText(MainActivity.this, "Contact has been added.", Toast.LENGTH_SHORT).show();
        edtEmpName.setText("");
        edtEmpEmail.setText("");
        edtEmpAddress.setText("");
        edtNotes.setText("");

        // After adding the data, navigate to the ViewActivity
        startActivity(new Intent(this, ViewActivity.class));
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
