package chipset.potato.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaScannerConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Environment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

/**
 * Developer: chipset
 * Package : chipset.potato
 * Project : Potato-Library
 * Date : 14/1/15
 */
public class Utils {

    /**
     * Method to get internet connection status
     *
     * @param context Context of the current activity
     * @return true     if {@link java.lang.Boolean} internet connection is established else false
     */
    public boolean isInternetConnected(Context context) {
        boolean isConnected;
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isConnected = (activeNetwork != null)
                && (activeNetwork.isConnectedOrConnecting());
        return isConnected;
    }

    /**
     * Method to hide keyboard
     *
     * @param context Context of the current activity
     * @param view    View of the activity to get Window Token
     */

    public void hideKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Method to get Bluetooth status
     *
     * @param context Context of the current activity
     * @return {@link java.lang.Boolean} true if internet bluetooth is enabled else false
     */
    public boolean isBluetoothOn(Context context) {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Toast.makeText(context, "Bluetooth not supported", Toast.LENGTH_SHORT).show();
            return false;
        }
        return mBluetoothAdapter.isEnabled();
    }

    /**
     * Method to get battery level
     *
     * @param context Context of the current activity
     * @return {@link java.lang.Integer} with battery level
     */
    public int getBatteryLevel(Context context) {
        final int[] level = new int[1];
        context.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                level[0] = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            }
        }, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        return level[0];
    }

    /**
     * Method to open Directory in external storage
     * Directory will be created if it does not already exist
     *
     * @param folderName    containing directory name
     * @param context   Context of the current activity
     * @return {@link java.io.File} object of opened/created directory
     */
    public File openDirectory(Context context, String folderName) throws IOException {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/" + folderName);
        if (!file.exists()) {
            file.mkdirs();
        }
        MediaScannerConnection.scanFile(context, new String[]{file.getAbsolutePath()}, null, null);
        return file;
    }
}