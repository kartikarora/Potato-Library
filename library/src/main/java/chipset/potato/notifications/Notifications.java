/*
 MIT License

 Copyright (c) 2016 Kartik Arora

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

package chipset.potato.notifications;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

/**
 * Developer: chipset
 * Package : chipset.potato.notifications
 * Project : Potato-Library
 * Date : 14/1/15
 */
public class Notifications {

    private Context mContext;

    public Notifications(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * Method to show notification(no actions, default tune)
     *
     * @param title        String for the notification title
     * @param subtitle     String for the notification subtitle
     * @param icon         Image for the notification icon
     * @param resultIntent Intent to start when notification is tapped
     */
    public void showNotificationDefaultSound(String title, String subtitle, int icon,
                                             Intent resultIntent) {

        Uri soundUri = RingtoneManager
                .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        PendingIntent pendingResultIntent = PendingIntent.getActivity(mContext,
                0, resultIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification mBuilder = new NotificationCompat.Builder(mContext)
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
     * @param resultIntent Intent to start when notification is tapped
     */
    public void showNotificationNoSound(String title, String subtitle,
                                        int icon, Intent resultIntent) {

        PendingIntent pendingResultIntent = PendingIntent.getActivity(mContext,
                0, resultIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification mBuilder = new NotificationCompat.Builder(mContext)
                .setContentTitle(title).setContentText(subtitle)
                .setSmallIcon(icon).setContentIntent(pendingResultIntent)
                .setAutoCancel(true).build();
        NotificationManagerCompat mNotifyMgr = NotificationManagerCompat.from(mContext);
        mNotifyMgr.cancelAll();
        mNotifyMgr.notify(0, mBuilder);
    }
}
