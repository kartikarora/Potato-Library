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
    private Potato potato;
    private Utils utils;
    private Notifications notifications;
    private Preferences preferences;
    private Intents intents;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        potato = Potato.potate();
        assertNotNull(potato);
        utils = potato.Utils();
        notifications = potato.Notifications();
        preferences = potato.Preferences();
        intents = potato.Intents();
    }

    public void testForUtilMethods() throws IOException {
        assertNotNull(utils);
        assertTrue(utils.isInternetConnected(getContext()));
        assertFalse(utils.isBluetoothAvailable(getContext()));
        assertFalse(utils.isBluetoothOn(getContext()));
        assertNotNull(utils.openDirectory(getContext(), "abcd"));
        assertTrue(0 <= utils.getBatteryLevel(getContext()) && utils.getBatteryLevel(getContext()) <= 100);

    }

    public void testForNotificationsMethods() {
        assertNotNull(notifications);
    }

    public void testForPreferencesMethods() {
        assertNotNull(preferences);
        preferences.putSharedPreference(getContext(), "String", "test");
        preferences.putSharedPreference(getContext(), "int", 0);
        preferences.putSharedPreference(getContext(), "boolean", false);
        preferences.putSharedPreference(getContext(), "long", (long) 0);
        preferences.putSharedPreference(getContext(), "float", 0.0f);

        assertEquals("test", preferences.getSharedPreferenceString(getContext(), "String"));
        assertEquals(0, preferences.getSharedPreferenceInteger(getContext(), "int"));
        assertFalse(preferences.getSharedPreferenceBoolean(getContext(), "boolean"));
        assertEquals((long) 0, preferences.getSharedPreferenceLong(getContext(), "long"));
        assertEquals(0.0f, preferences.getSharedPreferenceFloat(getContext(), "float"));
    }

    public void testForIntentsMethods() {
        assertNotNull(intents);
    }
}
