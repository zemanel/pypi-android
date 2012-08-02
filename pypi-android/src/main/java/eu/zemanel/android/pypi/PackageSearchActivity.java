package eu.zemanel.android.pypi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import eu.zemanel.pypi.client.PypiXMLRPCClient;
import eu.zemanel.pypi.client.PypiXMLRPCException;
import android.app.ListActivity;
import android.widget.ArrayAdapter;

import java.net.URL;

public class PackageSearchActivity extends ListActivity{

    private static String TAG = "pypi-android";

    private PypiXMLRPCClient client;

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "eu.zemanel.android.pypi.PackageSearchActivity.onCreate");
        setContentView(R.layout.package_search);
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        setListAdapter(adapter);
    }

}

