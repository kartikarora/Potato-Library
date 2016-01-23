package chipset.potato;

import android.content.Context;

import chipset.potato.intents.Intents;
import chipset.potato.notifications.Notifications;
import chipset.potato.preferences.Preferences;
import chipset.potato.utils.Utils;

/**
 * Developer: chipset
 * Package : chipset.potato
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
