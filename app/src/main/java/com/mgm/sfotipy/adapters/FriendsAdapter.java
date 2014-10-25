package com.mgm.sfotipy.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mgm.sfotipy.R;
import com.mgm.sfotipy.models.Friends;

import java.util.ArrayList;

/**
 * Created by miguel on 21/10/2014.
 */
public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {
    private ArrayList<Friends> friends;
    private int itemLayout;

    public FriendsAdapter(ArrayList<Friends> friends, int itemLayout) {
        this.friends = friends;
        this.itemLayout = itemLayout;
    }

    @Override
    public FriendsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FriendsAdapter.ViewHolder viewHolder, int i) {
        Friends friend = friends.get(i);

        viewHolder.nombreFriend.setText(friend.getNombre());
        viewHolder.twitterFriend.setText(friend.getTwitter());
        viewHolder.ultimaCancion.setText(friend.getUltimaCancion());

        viewHolder.itemView.setTag(friend);
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreFriend, twitterFriend, ultimaCancion;

        public ViewHolder(View itemView) {
            super(itemView);

            nombreFriend = (TextView) itemView.findViewById(R.id.nombre_friend);
            twitterFriend = (TextView) itemView.findViewById(R.id.twitter_friend);
            ultimaCancion = (TextView) itemView.findViewById(R.id.ultimacancion_friend);
        }
    }
}
