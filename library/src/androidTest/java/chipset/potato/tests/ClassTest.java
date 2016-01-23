package chipset.potato.tests;

import android.test.AndroidTestCase;

import chipset.potato.Potato;

/**
 * Developer: chipset
 * Package : chipset.potato
 * Project : Potato-Library
 * Date : 20/6/15
 */

public class ClassTest extends AndroidTestCase {

    private Potato potato;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        potato = Potato.potate(getContext());
    }

    public void testForPotatoInit() {
        assertNotNull(potato);
    }

    public void testForUtils() {
        assertNotNull(potato.Utils());
    }

    public void testFoPreferences() {
        assertNotNull(potato.Preferences());
    }

    public void testForIntents() {
        assertNotNull(potato.Intents());
    }

    public void testForNotifications() {
        assertNotNull(potato.Notifications());
    }
}
