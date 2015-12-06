package chipset.potato.intents;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.provider.MediaStore;

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

    /**
     * Method to call Calendar to add event.
     *
     * @param context     Context of the activity from where the intent is called
     * @param startTime   Start date and time for the event in milliseconds since epoch
     * @param endTime     End date and time for the event in milliseconds since epoch
     * @param title       Title of the event
     * @param allDay      Set to true for all day events, else false
     * @param description Description of the event
     *
     * Requires API level 14
     */
    public void calenderIntent(Context context, long startTime, long endTime, String title, Boolean allDay, String description) {
        context.startActivity(new Intent(Intent.ACTION_EDIT)
                .setType("vnd.android.cursor.item/event")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime)
                .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, allDay)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.DESCRIPTION,description)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Method to call Calendar to add event with location of the event.
     *
     * @param context     Context of the activity from where the intent is called
     * @param startTime   Start date and time for the event in milliseconds since epoch
     * @param endTime     End date and time for the event in milliseconds since epoch
     * @param title       Title of the event
     * @param allDay      Set to true for all day events, else false
     * @param description Description of the event
     * @param location    Location of the event
     *
     * Requires API level 14
     */
    public void calenderIntentWithLocation(Context context, long startTime, long endTime, String title, Boolean allDay, String description, String location) {
        context.startActivity(new Intent(Intent.ACTION_EDIT)
                .setType("vnd.android.cursor.item/event")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime)
                .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, allDay)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.DESCRIPTION,description)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Method to call Music Player
     *
     * @param context Context of the activity from where the intent is called
     */
    public void musicPlayerIntent(Context context){
        context.startActivity(new Intent("android.intent.category.APP_MUSIC")
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Method to call Music Player and play the file specified in fileLocation
     *
     * @param context      Context of the activity from where the intent is called
     * @param fileLocation Location of the audio file
     * Requires permission WRITE_EXTERNAL_STORAGE
     */
    public void musicPlayerIntentWithFile(Context context, Uri fileLocation){
        context.startActivity(new Intent(Intent.CATEGORY_APP_MUSIC)
                .setAction(Intent.ACTION_VIEW)
                .setDataAndType(fileLocation, "audio/*")
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Method to call Music Player
     *
     * @param context Context of the activity from where the intent is called
     * This method is deprecated as of API level 15 and is used for backward compatibility to API level 8
     * It is advisable to use musicPlayerIntent() method for API level 15 and above
     */
    @Deprecated
    public void musicIntent(Context context){
        context.startActivity(new Intent("android.intent.action.MUSIC_PLAYER")
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Method to call Music Player and play the file specified in fileLocation
     *
     * @param context      Context of the activity from where the intent is called
     * @param fileLocation Location of the audio file
     *
     * Requires permission WRITE_EXTERNAL_STORAGE
     * This method is deprecated as of API level 15 and is used for backward compatibility to API level 8
     * It is advisable to use musicPlayerIntentWithFile() method for API level 15 and above
     */
    @Deprecated
    public void musicIntentWithFile(Context context, Uri fileLocation){
        context.startActivity(new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER)
                .setAction(Intent.ACTION_VIEW)
                .setDataAndType(fileLocation,"audio/*")
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * Method to start Camera
     *
     * @param context Context of the activity from where the intent is called
     */
    public void cameraIntent(Context context){
        context.startActivity(new Intent("android.media.action.IMAGE_CAPTURE")
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
