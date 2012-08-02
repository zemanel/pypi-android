package eu.zemanel.android.pypi;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import eu.zemanel.pypi.client.PackageRelease;
import eu.zemanel.pypi.client.PypiXMLRPCClient;
import eu.zemanel.pypi.client.PypiXMLRPCException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;


public class UpdatedReleasesActivity extends ListActivity{

    PypiXMLRPCClient client;

    private static String TAG = "pypi-android";

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.updated_releases);
        showUpdatedReleases();
    }

    /**
     *
     */
    private void showUpdatedReleases() {
        try {
            this.client = new PypiXMLRPCClient(new URL("http://pypi.python.org/pypi"));
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, -1);
            Date since = c.getTime();
            setTitle(getString(R.string.showing_since) + ": "+since.toString());
            PackageRelease[] releases  = client.updatedReleases(since);
            UpdatedReleaseArrayAdapter adapter = new UpdatedReleaseArrayAdapter(this, releases);
            setListAdapter(adapter);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (PypiXMLRPCException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                onSearchRequested();
                return true;
            default:
                return false;
        }
    }

}

