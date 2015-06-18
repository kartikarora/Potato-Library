package chipset.potato.intents;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Developer: chipset
 * Package : chipset.potato.intents
 * Project : Potato-Library
 * Date : 14/1/15
 */
public class Intents {

    /**
     * Method to start email intent
     *
     * @param context Context of the activity from where the intent is called
     * @param to      Recipient email address for the email
     * @param subject Subject of the email
     * @param body    Content of the email
     */
    public void emailIntent(Context context, String to, String subject, String body) {
        StringBuilder builder = new StringBuilder("mailto:" + Uri.encode(to));
        if (subject != null) {
            builder.append("?subject=").append(subject);
            if (body != null) {
                builder.append("&body=").append(body);
            }
        }
        String uri = builder.toString();
        context.startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse(uri))
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Method to start browser intent
     *
     * @param context Context of the activity from where the intent is called
     * @param url     Url of the website
     */
    public void browserIntent(Context context, String url) {
        if (!url.startsWith("https://") && !url.startsWith("http://")) {
            url = "http://" + url;
        }
        context.startActivity(new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse(url))
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Method to start call intent
     *
     * @param context     Context of the activity from where the intent is called
     * @param phoneNumber Contact number of the phone call recipient
     */
    public void callIntent(Context context, String phoneNumber) {
        context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + phoneNumber))
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Method to start sms intent with default sms application.
     *
     * @param context     Context of the activity from where the intent is called
     * @param phoneNumber Contact number of the phone call recipient
     * @param message     Body of the sms to be sent
     */
    public void smsIntent(Context context, String phoneNumber, String message) {
        context.startActivity(new Intent(Intent.ACTION_SENDTO)
                .setData(Uri.parse("sms:"))
                .putExtra("sms_body", message)
                .putExtra("address", phoneNumber)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
