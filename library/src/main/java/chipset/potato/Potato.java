package chipset.potato;

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

    public static Potato potate() {
        return new Potato();
    }

    public Utils Utils() {
        return new Utils();
    }

    public Notifications Notifications() {
        return new Notifications();
    }

    public Preferences Preferences() {
        return new Preferences();
    }

    public Intents Intents() {
        return new Intents();
    }


}
