package com.techsummit.provedorespr.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.techsummit.provedorespr.DetailActivity;
import com.techsummit.provedorespr.ProviderAdapter;
import com.techsummit.provedorespr.R;
import com.techsummit.provedorespr.model.Provider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProviderFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener {
    List<Provider> mProviders;

    ProviderAdapter mAdapter;

    ListView providerListView;

    ProgressBar progressBar;

    public ProviderFragment() {
        // Required empty public constructor
    }

    public static ProviderFragment newInstance() {
        return new ProviderFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mProviders = new ArrayList<>();
        mAdapter = new ProviderAdapter(getActivity(), R.layout.view_provider, mProviders);

        //prepare the payload in a friendly way.
        new PrepareJson().execute();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        providerListView.setAdapter(mAdapter);
        providerListView.setOnItemClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_provider, container, false);

        providerListView = (ListView) v.findViewById(R.id.providerListView);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);

        return v;

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("providers_data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //show detail
        Provider provider = mAdapter.getItem(position);
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("name", provider.name);
        intent.putExtra("address", provider.address);
        intent.putExtra("lat", provider.lat);
        intent.putExtra("lon", provider.lon);
        intent.putExtra("speciality", provider.specialty);
        intent.putExtra("county", provider.county);
        intent.putExtra("phone", provider.phone);
        intent.putExtra("state", provider.state);
        intent.putExtra("superSpeciality", provider.superSpeciality);
        startActivity(intent);
        //getActivity().overridePendingTransition();

    }

    public class PrepareJson extends AsyncTask<Void, Void, List<Provider>> {

        @Override
        protected List<Provider> doInBackground(Void... params) {

            String json = loadJSONFromAsset();
            JSONObject mainObject = null;

            List<Provider> providerList = new ArrayList<>();
            try {
                mainObject = new JSONObject(json);
                JSONArray data = mainObject.getJSONArray("data");

                for (int i = 0; i < data.length(); i++) {
                    JSONArray values = (JSONArray) data.get(i);
                    Provider provider = new Provider();
                    provider.name = values.getString(8);
                    provider.state = values.getString(14);
                    provider.county = values.getString(11);
                    provider.address = values.getString(13);
                    provider.phone = values.getString(12);
                    provider.specialty = values.getString(9);
                    provider.lat = values.getJSONArray(15).getString(1);
                    provider.lon = values.getJSONArray(15).getString(2);

                    if (values.get(10) != null) {
                        provider.superSpeciality = values.getString(10);
                    }

                    providerList.add(provider);

                }
                return providerList;

            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(List<Provider> providers) {
            super.onPostExecute(providers);
            progressBar.setVisibility(View.GONE);
            mProviders.addAll(providers);
            mAdapter.notifyDataSetChanged();
        }
    }


}
