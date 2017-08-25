/*
 MIT License

 Copyright (c) 2017 Kartik Arora

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */

package me.kartikarora.potato.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Developer: chipset
 * Package : me.kartikarora.potato.preferences
 * Project : Potato-Library
 * Date : 14/1/15
 */
public class Preferences {

    private Context mContext;
    private SharedPreferences mPreference;

    public Preferences(Context context) {
        this.mContext = context;
        this.mPreference = context.getSharedPreferences(context.getPackageName(),0);
    }

    /**
     * Methods to SharedPreferences data
     *
     * @param preferenceName Name of the preference
     * @param val            Value to be stored in the preference
     */
    //Boolean
    public void putSharedPreference(String preferenceName,
                                    boolean val) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.clear();
        editor.putBoolean(preferenceName, val);
        editor.apply();
    }

    // String
    public void putSharedPreference(String preferenceName,
                                    String val) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.clear();
        editor.putString(preferenceName, val);
        editor.apply();
    }

    // Integer
    public void putSharedPreference(String preferenceName,
                                    int val) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.clear();
        editor.putInt(preferenceName, val);
        editor.apply();
    }

    // Long
    public void putSharedPreference(String preferenceName,
                                    long val) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.clear();
        editor.putLong(preferenceName, val);
        editor.apply();
    }

    // Float
    public void putSharedPreference(String preferenceName,
                                    float val) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.clear();
        editor.putFloat(preferenceName, val);
        editor.apply();
    }

    /**
     * Method to get SharedPreferences data
     *
     * @param preferenceName Name of the preference
     */
    // Boolean
    public boolean getSharedPreferenceBoolean(String preferenceName) {
        return mPreference.getBoolean(preferenceName, true);

    }

    // Integer
    public int getSharedPreferenceInteger(String preferenceName) {
        return mPreference.getInt(preferenceName, 0);

    }

    // String
    public String getSharedPreferenceString(String preferenceName) {
        return mPreference.getString(preferenceName, null);

    }

    // Long
    public long getSharedPreferenceLong(String preferenceName) {
        return mPreference.getLong(preferenceName, 0);

    }

    // Float
    public float getSharedPreferenceFloat(String preferenceName) {
        return mPreference.getFloat(preferenceName, 0);

    }

    /**
     * Method to remove SharedPreferences data
     *
     * @param preferenceName Name of the preference
     */
    public void removeSharedPreference(String preferenceName) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.remove(preferenceName);
        editor.apply();
    }

    /**
     * Method to check whether a preference key has been created
     *
     * @param preferenceName Name of the preference
     */
    public boolean sharedPreferenceExists(String preferenceName) {
        return mPreference.contains(preferenceName);
    }
}