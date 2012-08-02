package eu.zemanel.android.pypi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import eu.zemanel.pypi.client.PackageRelease;

/**
 *
 */
public class UpdatedReleaseArrayAdapter extends ArrayAdapter<PackageRelease> {
    private final Context context;
    private final PackageRelease[] values;

    /**
     *
     * @param context
     * @param values
     */
    public UpdatedReleaseArrayAdapter(Context context, PackageRelease[] values) {
        super(context, R.layout.updated_releases_item, values);
        this.context = context;
        this.values = values;
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.updated_releases_item, parent, false);
        TextView packageNametextView = (TextView) rowView.findViewById(R.id.package_name);
        TextView packageVersiontextView = (TextView) rowView.findViewById(R.id.package_version);
        packageNametextView.setText(values[position].getPackageName());
        packageVersiontextView.setText(values[position].getVersion());
        return rowView;
    }
}
