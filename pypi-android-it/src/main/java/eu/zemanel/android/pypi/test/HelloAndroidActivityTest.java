package eu.zemanel.android.pypi.test;

import android.test.ActivityInstrumentationTestCase2;
import eu.zemanel.android.pypi.*;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    public HelloAndroidActivityTest() {
        super("eu.zemanel.android.pypi", HelloAndroidActivity.class);
    }

    public void testActivity() {
        HelloAndroidActivity activity = getActivity();
        assertNotNull(activity);
    }
}

