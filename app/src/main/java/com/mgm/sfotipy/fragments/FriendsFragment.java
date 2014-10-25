package com.mgm.sfotipy.fragments;



import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mgm.sfotipy.R;
import com.mgm.sfotipy.adapters.FriendsAdapter;
import com.mgm.sfotipy.models.Friends;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class FriendsFragment extends Fragment {


    public FriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friends, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Friends> friends = new ArrayList<Friends>();

        Friends miguel = new Friends();
        miguel.setNombre("Miguel Mamani");
        miguel.setTwitter("@djmiguelarango");
        miguel.setUltimaCancion("Calvin Harris - Blame");
        friends.add(miguel);

        Friends hardwell = new Friends();
        hardwell.setNombre("Hardwell");
        hardwell.setTwitter("@hardwell");
        hardwell.setUltimaCancion("Hardwell - Arcadia");
        friends.add(hardwell);

        Friends tiesto = new Friends();
        tiesto.setNombre("Tiesto");
        tiesto.setTwitter("@tiesto");
        tiesto.setUltimaCancion("Tiesto - Red Lights");
        friends.add(tiesto);

        Friends nickyromero = new Friends();
        nickyromero.setNombre("Nicky Romero");
        nickyromero.setTwitter("@nickyromero");
        nickyromero.setUltimaCancion("Nicky Romero - Let Me Feel");
        friends.add(nickyromero);

        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new FriendsAdapter(friends, R.layout.row_friends));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
