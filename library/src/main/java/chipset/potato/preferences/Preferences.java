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

    private Context mContext;

    public Preferences(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * Methods to SharedPreferences data
     * @param preferenceName Name of the preference
     * @param val Value to be stored in the preference
     */
    //Boolean
    public void putSharedPreference(String preferenceName,
                                    boolean val) {
        SharedPreferences pref = mContext
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putBoolean(preferenceName, val);
        editor.commit();
    }

    // String
    public void putSharedPreference(String preferenceName,
                                    String val) {
        SharedPreferences pref = mContext
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putString(preferenceName, val);
        editor.commit();
    }

    // Integer
    public void putSharedPreference(String preferenceName,
                                    int val) {
        SharedPreferences pref = mContext
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putInt(preferenceName, val);
        editor.commit();
    }

    // Long
    public void putSharedPreference(String preferenceName,
                                    long val) {
        SharedPreferences pref = mContext
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putLong(preferenceName, val);
        editor.commit();
    }

    // Float
    public void putSharedPreference(String preferenceName,
                                    float val) {
        SharedPreferences pref = mContext
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.putFloat(preferenceName, val);
        editor.commit();
    }

    /**
     * Method to get SharedPreferences data
     * @param preferenceName Name of the preference
     */
    // Boolean
    public boolean getSharedPreferenceBoolean(String preferenceName) {
        SharedPreferences pref = mContext
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode

        return pref.getBoolean(preferenceName, true);

    }

    // Integer
    public int getSharedPreferenceInteger(String preferenceName) {
        SharedPreferences pref = mContext
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode

        return pref.getInt(preferenceName, 0);

    }

    // String
    public String getSharedPreferenceString(String preferenceName) {
        SharedPreferences pref = mContext
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode

        return pref.getString(preferenceName, "null");

    }

    // Long
    public long getSharedPreferenceLong(String preferenceName) {
        SharedPreferences pref = mContext
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode

        return pref.getLong(preferenceName, 0);

    }

    // Float
    public float getSharedPreferenceFloat(String preferenceName) {
        SharedPreferences pref = mContext
                .getSharedPreferences(preferenceName, 0); // 0 - for private
        // mode

        return pref.getFloat(preferenceName, 0);

    }
}
