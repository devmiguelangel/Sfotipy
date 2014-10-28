package com.mgm.sfotipy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mgm.sfotipy.R;
import com.mgm.sfotipy.models.Songs;

import java.util.ArrayList;

/**
 * Created by miguel on 25/10/2014.
 */
public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {
    private ArrayList<Songs> songs;
    private int itemLayout;

    public SongsAdapter(ArrayList<Songs> songs, int itemLayout) {
        this.songs = songs;
        this.itemLayout = itemLayout;
    }

    @Override
    public SongsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SongsAdapter.ViewHolder viewHolder, int i) {
        Songs song = songs.get(i);

        viewHolder.nombreSong.setText(song.getSongName());
        viewHolder.artistaSong.setText(song.getSongArtist());
        viewHolder.stars.setRating(song.getSongStars());

        viewHolder.itemView.setTag(song);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreSong, artistaSong;
        public RatingBar stars;

        public ViewHolder(View itemView) {
            super(itemView);

            nombreSong = (TextView) itemView.findViewById(R.id.nombre_song);
            artistaSong = (TextView) itemView.findViewById(R.id.artist_song);
            stars = (RatingBar) itemView.findViewById(R.id.stars_song);
        }
    }
}
