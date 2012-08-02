package eu.zemanel.android.pypi.test;

import android.test.ActivityInstrumentationTestCase2;
import eu.zemanel.android.pypi.*;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<UpdatedReleasesActivity> {

    public HelloAndroidActivityTest() {
        super("eu.zemanel.android.pypi", UpdatedReleasesActivity.class);
    }

    public void testActivity() {
        UpdatedReleasesActivity activity = getActivity();
        assertNotNull(activity);
    }
}

