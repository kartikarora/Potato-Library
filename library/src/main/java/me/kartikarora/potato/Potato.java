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

package me.kartikarora.potato;

import android.content.Context;

import me.kartikarora.potato.intents.Intents;
import me.kartikarora.potato.notifications.Notifications;
import me.kartikarora.potato.preferences.Preferences;
import me.kartikarora.potato.utils.Utils;


/**
 * Developer: chipset
 * Package : me.kartikarora.potato
 * Project : PotatoLibrary
 * Date : 22/10/14
 */
public class Potato {

    private Context mContext;

    /**
     * Empty default private constructor. Use {@link potate()} to initialize Potato library
     */
    private Potato() {
    }

    /**
     * Private constructor. Use {@link potate()} to initialize Potato library
     */
    private Potato(Context context) {
        this.mContext = context;
    }

    /**
     * Method to initialise Potato Library
     *
     * @param context Context of the application
     * @return Instance of Potato
     */
    public static Potato potate(Context context) {
        return new Potato(context);
    }

    public Utils Utils() {
        return new Utils(mContext);
    }

    public Notifications Notifications() {
        return new Notifications(mContext);
    }

    public Preferences Preferences() {
        return new Preferences(mContext);
    }

    public Intents Intents() {
        return new Intents(mContext);
    }
}
