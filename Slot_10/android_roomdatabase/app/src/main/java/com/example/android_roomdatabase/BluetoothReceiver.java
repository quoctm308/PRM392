package com.example.android_roomdatabase;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BluetoothReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action != null) {
            switch (action) {
                case BluetoothAdapter.ACTION_STATE_CHANGED:
                    int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1);
                    handleBluetoothStateChanged(context, state);
                    break;

                // Add more cases for other Bluetooth-related actions if needed

                default:
                    // Handle other actions, if required
                    break;
            }
        }
    }

    private void handleBluetoothStateChanged(Context context, int state) {
        switch (state) {
            case BluetoothAdapter.STATE_OFF:
                showToast(context, "Bluetooth turned off");
                break;
            case BluetoothAdapter.STATE_TURNING_ON:
                showToast(context, "Bluetooth turning on");
                break;
            case BluetoothAdapter.STATE_ON:
                showToast(context, "Bluetooth turned on");
                break;
            case BluetoothAdapter.STATE_TURNING_OFF:
                showToast(context, "Bluetooth turning off");
                break;
            default:
                break;
        }
    }

    private void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
