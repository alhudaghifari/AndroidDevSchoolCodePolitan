package com.alhudaghifari.latihanfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {


    private ArrayAdapter mAdapter;
    private ListView listViewContact;
    private ArrayList mArrayListContact;

    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_home, container, false);

        mArrayListContact = new ArrayList();

        listViewContact = v.findViewById(R.id.listViewContact);

        addData();

        mAdapter = new ArrayAdapter(FragmentHome.this.getContext(),
                android.R.layout.simple_list_item_1, mArrayListContact);
        listViewContact.setAdapter(mAdapter);
        listViewContact.setOnItemClickListener(myListClickListener);


        return v;
    }

    private void addData() {
        mArrayListContact.add("Sinta");
        mArrayListContact.add("Jojo");
        mArrayListContact.add("Papang Lalala");
        mArrayListContact.add("Gogo");
        mArrayListContact.add("Jeni");
        mArrayListContact.add("Kina");
        mArrayListContact.add("Santo");
    }


    private AdapterView.OnItemClickListener myListClickListener =
            new AdapterView.OnItemClickListener() {
        public void onItemClick (AdapterView av, View v, int arg2, long arg3)
        {
            // Get the device MAC address, the last 17 chars in the View
            String info = ((TextView) v).getText().toString();
            Log.d("FragmentHome", "text : " + info);

            Intent pindahintent = new Intent(FragmentHome.this.getContext(), ProfilKontakTeman.class);
            pindahintent.putExtra("namateman", info);
            startActivity(pindahintent);
        }
    };

}
