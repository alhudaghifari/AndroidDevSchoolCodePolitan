package com.alhudaghifari.latihanfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfil extends Fragment {

    ImageView ivFotoProfil;

    public FragmentProfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_profil, container, false);

        ivFotoProfil = v.findViewById(R.id.ivFotoProfil);

        Glide.with(FragmentProfil.this)
                .load("https://cdn.pixabay.com/photo/2017/02/23/13/05/profile-2092113_960_720.png")
                .into(ivFotoProfil);
        return v;
    }

}
