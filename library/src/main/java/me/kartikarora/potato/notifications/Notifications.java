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

package me.kartikarora.potato.notifications;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.io.File;

/**
 * Developer: chipset
 * Package : me.kartikarora.potato.notifications
 * Project : Potato-Library
 * Date : 14/1/15
 */
public class Notifications {

    private Context mContext;
    private static final String DEFAULT_CHANNEL_ID = "default";

    public Notifications(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * Method to preserve backwards compatibilty for notifications.
     */
    public void showNotificationDefaultSound(String title, String subtitle, int icon,
                                             Intent resultIntent) {
        showNotificationDefaultSound(title, subtitle, icon, DEFAULT_CHANNEL_ID, resultIntent);
    }

    /**
     * Method to preserve backwards compatibilty for notifications.
     */
    public void showNotificationNoSound(String title, String subtitle,
                                        int icon, Intent resultIntent) {
        showNotificationNoSound(title, subtitle, icon, DEFAULT_CHANNEL_ID, resultIntent);
    }

    /**
     * Method to show notification (no actions, default notification tune)
     *
     * @param title        String for the notification title
     * @param subtitle     String for the notification subtitle
     * @param icon         Image for the notification icon
     * @param channelId    Channel ID for Android O notification channels
     * @param resultIntent Intent to start when notification is tapped
     */
    public void showNotificationDefaultSound(String title, String subtitle, int icon,
                                             String channelId, Intent resultIntent) {

        Uri soundUri = RingtoneManager
                .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        showNotificationCustomSound(title, subtitle, icon, soundUri, channelId, resultIntent);
    }

    /**
     * Method to show notification (no actions) without sound
     *
     * @param title        String for the notification title
     * @param subtitle     String for the notification subtitle
     * @param icon         Image for the notification icon
     * @param channelId    Channel ID for Android O notification channels
     * @param resultIntent Intent to start when notification is tapped
     */
    public void showNotificationNoSound(String title, String subtitle, int icon,
                                        String channelId, Intent resultIntent) {

        PendingIntent pendingResultIntent = PendingIntent.getActivity(mContext,
                0, resultIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification mBuilder = new NotificationCompat.Builder(mContext, channelId)
                .setContentTitle(title).setContentText(subtitle)
                .setSmallIcon(icon).setContentIntent(pendingResultIntent)
                .setAutoCancel(true).build();
        NotificationManagerCompat mNotifyMgr = NotificationManagerCompat.from(mContext);
        mNotifyMgr.cancelAll();
        mNotifyMgr.notify(0, mBuilder);
    }

    /**
     * Method to show notification (no actions) without sound
     *
     * @param title        String for the notification title
     * @param subtitle     String for the notification subtitle
     * @param icon         Image for the notification icon
     * @param soundUri     Uri for sound file
     * @param channelId    Channel ID for Android O notification channels
     * @param resultIntent Intent to start when notification is tapped
     */
    public void showNotificationCustomSound(String title, String subtitle, int icon, Uri soundUri,
                                            String channelId, Intent resultIntent) {

        PendingIntent pendingResultIntent = PendingIntent.getActivity(mContext,
                0, resultIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification mBuilder = new NotificationCompat.Builder(mContext, channelId)
                .setContentTitle(title).setContentText(subtitle)
                .setSmallIcon(icon).setContentIntent(pendingResultIntent)
                .setSound(soundUri).setAutoCancel(true)
                .build();
        NotificationManagerCompat mNotifyMgr = NotificationManagerCompat.from(mContext);
        mNotifyMgr.cancelAll();
        mNotifyMgr.notify(0, mBuilder);
    }

    /**
     * Method to show notification (no actions) without sound
     *
     * @param title        String for the notification title
     * @param subtitle     String for the notification subtitle
     * @param icon         Image for the notification icon
     * @param path         String path for sound file
     * @param channelId    Channel ID for Android O notification channels
     * @param resultIntent Intent to start when notification is tapped
     */
    public void showNotificationCustomSound(String title, String subtitle, int icon, String path,
                                            String channelId, Intent resultIntent) {

        Uri soundUri = Uri.parse(path);
        showNotificationCustomSound(title, subtitle, icon, soundUri, channelId, resultIntent);
    }

    /**
     * Method to show notification (no actions) without sound
     *
     * @param title        String for the notification title
     * @param subtitle     String for the notification subtitle
     * @param icon         Image for the notification icon
     * @param file         File object for sound file
     * @param channelId    Channel ID for Android O notification channels
     * @param resultIntent Intent to start when notification is tapped
     */
    public void showNotificationCustomSound(String title, String subtitle, int icon, File file,
                                            String channelId, Intent resultIntent) {

        Uri soundUri = Uri.fromFile(file);
        showNotificationCustomSound(title, subtitle, icon, soundUri, channelId, resultIntent);
    }
}
