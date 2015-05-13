package com.techsummit.provedorespr;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.techsummit.provedorespr.model.Provider;

import java.util.List;

/**
 * Created by Magnar on 5/13/2015.
 */
public class ProviderAdapter extends ArrayAdapter<Provider> {


    public ProviderAdapter(Context context, int resource, List<Provider> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (v != null) {
            viewHolder = (ViewHolder) v.getTag();

        } else {
            v = View.inflate(getContext(), R.layout.view_provider, null);
            viewHolder = new ViewHolder(v);
            v.setTag(viewHolder);
        }

        Provider provider = getItem(position);
        if (provider != null) {
            viewHolder.name.setText(provider.name);
            viewHolder.specialityTextView.setText(provider.specialty);
        }

        return v;

    }

    public static class ViewHolder {

        TextView name, specialityTextView;

        public ViewHolder(View v) {

            name = (TextView) v.findViewById(R.id.nameTextView);
            specialityTextView = (TextView) v.findViewById(R.id.specialityTextView);
        }
    }

}
