package com.alhudaghifari.codepolitanlite.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alhudaghifari.codepolitanlite.Artikel;
import com.alhudaghifari.codepolitanlite.ArtikelListAdapter;
import com.alhudaghifari.codepolitanlite.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorialFragment extends Fragment {

    ArrayList<Artikel> kumpulanArtikel = new ArrayList<>();
    RecyclerView recyclerView;
    ArtikelListAdapter adapter;


    public TutorialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news, container,
                false);
        for (int i = 0; i < 10; i++) {
            kumpulanArtikel.add(new Artikel(
                    "21769",
                    "python-software-foundation-terima-hibah-170000-dari-mozilla-open-source-program-5a275ad53f531",
                    "Python Software Foundation Terima Hibah $170.000 dari Mozilla Open Source Program",
                    "Lord Voldemort",
                    "https://www.gravatar.com/avatar/6a7d1f244946a619883181f5b6f0cddd?s=100",
                    "Beberapa waktu yang lalu, Python Software Foundation (PSF) menerima hibah $170.000 dari Mozilla Open Source Program. Hibah ini diberikan oleh..",
                    "06 Dec 2017",
                    "http://www.codepolitan.com/python-software-foundation-terima-hibah-170000-dari-mozilla-open-source-program-5a275ad53f531",
                    "https://static.cdn-cdpl.com/270x135/998b78e349061b4971c0a2b0e8d6be41/header-python-logo-flat-image700x350-crop-image700x350-crop-1-image(700x350-crop)-image(700x350-crop).png",
                    ""));
        }

        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new
                LinearLayoutManager(getContext()));

        adapter = new ArtikelListAdapter(kumpulanArtikel, getContext());
        recyclerView.setAdapter(adapter);

        readCodepolitanContent();

        return v;
    }


    public void readCodepolitanContent() {
        AsyncHttpClient client = new AsyncHttpClient();

        //https://759b74ce43947f5f4c91aeddc3e5bad3d.codepolitan.com/api/v2/posts/category/news
        client.get("https://759b74ce43947f5f4c91aeddc3e5bad3d.codepolitan.com/api/v2/posts/category/tutorial",
                new AsyncHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        Log.d("TutorialFragment",
                                "onStart : proses pembacaan API dimulai");
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers,
                                          byte[] responseBody) {
                        Log.d("TutorialFragment",
                                "onSuccess : pembacaan data API berhasil");
                        try {
                            String content = new String(responseBody);
                            Log.d("SUCCESS_RESP",""+content);
                            JSONObject object = new
                                    JSONObject(content);
                            JSONArray result = object.getJSONArray("result");
                            kumpulanArtikel.clear();

                            for (int i = 0;i < result.length(); i++) {
                                JSONObject objectArtikelJSON = result.getJSONObject(i);

                                String id = objectArtikelJSON.getString("id");
                                String slug = objectArtikelJSON.getString("slug");
                                String title = objectArtikelJSON.getString("title");
                                String authorName = objectArtikelJSON.getString("author_name");
                                String authorImage = objectArtikelJSON.getString("author_image");
                                String description = objectArtikelJSON.getString("description");
                                String date = objectArtikelJSON.getString("date");
                                String link = objectArtikelJSON.getString("link");
                                String thumbnail = objectArtikelJSON.getString("thumbnail");
                                String total_views = objectArtikelJSON.getString("total_views");

                                Artikel artikelBaru = new Artikel(id, slug, title, authorName,
                                        authorImage, description, date, link, thumbnail, total_views);

                                kumpulanArtikel.add(artikelBaru);

                            }

                            adapter.notifyDataSetChanged();

                        } catch (JSONException edan) {
                            edan.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.d("TutorialFragment",
                                "onFailure : pembacaan data gagal dengan kode " + statusCode);
                        Toast.makeText(getContext(), "Koneksi internet gagal",
                                Toast.LENGTH_SHORT).show();
                    }

                });
    }
}
