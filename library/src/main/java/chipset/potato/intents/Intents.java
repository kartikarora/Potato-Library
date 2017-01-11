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

package chipset.potato.intents;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.RequiresPermission;

/**
 * Developer: chipset
 * Package : chipset.potato.intents
 * Project : Potato-Library
 * Date : 14/1/15
 */
public class Intents {
    private Context mContext;

    public Intents(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * Method to start email intent
     *
     * @param to      Recipient email address for the email
     * @param subject Subject of the email
     * @param body    Content of the email
     */
    public void emailIntent(String to, String subject, String body) {
        StringBuilder builder = new StringBuilder("mailto:" + Uri.encode(to));
        if (subject != null) {
            builder.append("?subject=").append(subject);
            if (body != null) {
                builder.append("&body=").append(body);
            }
        }
        String uri = builder.toString();
        mContext.startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse(uri))
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Method to start browser intent
     *
     * @param url Url of the website
     */
    public void browserIntent(String url) {
        if (!url.startsWith("https://") && !url.startsWith("http://")) {
            url = "http://" + url;
        }
        mContext.startActivity(new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse(url))
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Method to start call intent
     *
     * @param phoneNumber Contact number of the phone call recipient
     */
    @RequiresPermission(Manifest.permission.CALL_PHONE)
    public void callIntent(String phoneNumber) {
        mContext.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + phoneNumber))
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Method to start sms intent with default sms application.
     *
     * @param phoneNumber Contact number of the phone call recipient
     * @param message     Body of the sms to be sent
     */
    @RequiresPermission(Manifest.permission.SEND_SMS)
    public void smsIntent(String phoneNumber, String message) {
        mContext.startActivity(new Intent(Intent.ACTION_SENDTO)
                .setData(Uri.parse("sms:"))
                .putExtra("sms_body", message)
                .putExtra("address", phoneNumber)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
