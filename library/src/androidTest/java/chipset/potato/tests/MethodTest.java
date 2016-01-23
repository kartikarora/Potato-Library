package chipset.potato.tests;

import android.test.AndroidTestCase;

import java.io.IOException;

import chipset.potato.Potato;
import chipset.potato.intents.Intents;
import chipset.potato.notifications.Notifications;
import chipset.potato.preferences.Preferences;
import chipset.potato.utils.Utils;

/**
 * Developer: chipset
 * Package : chipset.potato.tests
 * Project : Potato-Library
 * Date : 20/6/15
 */

public class MethodTest extends AndroidTestCase {
    private Utils utils;
    private Notifications notifications;
    private Preferences preferences;
    private Intents intents;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Potato potato = Potato.potate(getContext());
        assertNotNull(potato);
        utils = potato.Utils();
        notifications = potato.Notifications();
        preferences = potato.Preferences();
        intents = potato.Intents();
    }

    public void testForUtilMethods() throws IOException {
        assertNotNull(utils);
        assertTrue(utils.isInternetConnected());
        assertFalse(utils.isBluetoothAvailable());
        assertFalse(utils.isBluetoothOn());
        assertNotNull(utils.openDirectory("abcd"));
        assertTrue(0 <= utils.getBatteryLevel() && utils.getBatteryLevel() <= 100);

    }

    public void testForNotificationsMethods() {
        assertNotNull(notifications);
    }

    public void testForPreferencesMethods() {
        assertNotNull(preferences);
        preferences.putSharedPreference("String", "test");
        preferences.putSharedPreference("int", 0);
        preferences.putSharedPreference("boolean", false);
        preferences.putSharedPreference("long", (long) 0);
        preferences.putSharedPreference("float", 0.0f);

        assertEquals("test", preferences.getSharedPreferenceString("String"));
        assertEquals(0, preferences.getSharedPreferenceInteger("int"));
        assertFalse(preferences.getSharedPreferenceBoolean("boolean"));
        assertEquals((long) 0, preferences.getSharedPreferenceLong("long"));
        assertEquals(0.0f, preferences.getSharedPreferenceFloat("float"));
    }

    public void testForIntentsMethods() {
        assertNotNull(intents);
    }
}
