package com.alhudaghifari.codepolitanlite;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ghifar on 11/07/18.
 */

public class ArtikelListAdapter extends
        RecyclerView.Adapter<ArtikelListAdapter.ArtikelViewHolder>{

    ArrayList<Artikel> data;
    Context context;


    private OnArtikelClickListener mOnArtikelClickListener;


    public ArtikelListAdapter(ArrayList<Artikel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ArtikelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_artikel, parent,
                        false);
        return new ArtikelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArtikelViewHolder holder,
                                 final int position) {
        ArtikelViewHolder artikelViewHolder =
                (ArtikelViewHolder) holder;

        final Artikel artikel = data.get(position);

        holder.tvPenulis.setText(artikel.getAuthor_name());
        holder.tvJudul.setText(artikel.getTitle());

        Picasso.with(context)
                .load(artikel.getThumbnail())
                .into(holder.ivThumbnail);

        artikelViewHolder.mViewContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("ArtikelListAdapter", "position clicked : " + position);
                        if (mOnArtikelClickListener != null) {
                            mOnArtikelClickListener.onClick(position, artikel);
                        }
                    }
                }, 250);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ArtikelViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvPenulis;
        ImageView ivThumbnail;


        public View mViewContainer;

        public ArtikelViewHolder(View itemView) {
            super(itemView);

            mViewContainer = itemView;
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvPenulis = itemView.findViewById(R.id.tvPenulis);
            ivThumbnail = itemView.findViewById(R.id.ivImageBerita);
        }
    }

    /**
     * interface ketika container di click
     */
    public interface OnArtikelClickListener {
        void onClick(int posisi, Artikel model);
    }

    /**
     * listener artikel di klik
     * @param onArtikelClickListener onartikelclicklistener
     */
    public void setOnArtikelClickListener(OnArtikelClickListener onArtikelClickListener) {
        mOnArtikelClickListener = onArtikelClickListener;
    }


}
