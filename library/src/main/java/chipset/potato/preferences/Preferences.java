package chipset.potato.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Developer: chipset
 * Package : chipset.potato.preferences
 * Project : Potato-Library
 * Date : 14/1/15
 */
public class Preferences {

    /**
     * Methods to SharedPreferences data
	 */
    //Boolean
    public void putSharedPreference(Context context, String preferenceName,
                                    boolean val) {
        SharedPreferences pref = context
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putBoolean(preferenceName, val);
        editor.commit();
    }

    // String
    public void putSharedPreference(Context context, String preferenceName,
                                    String val) {
        SharedPreferences pref = context
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putString(preferenceName, val);
        editor.commit();
    }

    // Integer
    public void putSharedPreference(Context context, String preferenceName,
                                    int val) {
        SharedPreferences pref = context
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putInt(preferenceName, val);
        editor.commit();
    }

    // Long
    public void putSharedPreference(Context context, String preferenceName,
                                    long val) {
        SharedPreferences pref = context
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putLong(preferenceName, val);
        editor.commit();
    }

    // Float
    public void putSharedPreference(Context context, String preferenceName,
                                    float val) {
        SharedPreferences pref = context
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putFloat(preferenceName, val);
        editor.commit();
    }

    /**
     * Method to get SharedPreferences data
	 */
    // Boolean
    public boolean getSharedPreferenceBoolean(Context context, String preferenceName) {
        SharedPreferences pref = context
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode

        return pref.getBoolean(preferenceName, true);

    }

    // Integer
    public int getSharedPreferenceInteger(Context context, String preferenceName) {
        SharedPreferences pref = context
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode

        return pref.getInt(preferenceName, 0);

    }

    // String
    public String getSharedPreferenceString(Context context, String preferenceName) {
        SharedPreferences pref = context
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode

        return pref.getString(preferenceName, "null");

    }

    // Long
    public long getSharedPreferenceLong(Context context, String preferenceName) {
        SharedPreferences pref = context
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode

        return pref.getLong(preferenceName, 0);

    }

    // Float
    public float getSharedPreferenceFloat(Context context, String preferenceName) {
        SharedPreferences pref = context
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode

        return pref.getFloat(preferenceName, 0);

    }
}
