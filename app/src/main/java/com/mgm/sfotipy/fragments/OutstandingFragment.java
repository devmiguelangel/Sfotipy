package com.mgm.sfotipy.fragments;



import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.mgm.sfotipy.R;
import com.mgm.sfotipy.adapters.SongsAdapter;
import com.mgm.sfotipy.models.Songs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class OutstandingFragment extends Fragment {
    ArrayList<Songs> songs = new ArrayList<Songs>();
    ArrayList<Songs> dataset;

    public OutstandingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_outstanding, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String URL = "https://script.google.com/macros/s/AKfycbxYMVeK_mfrW0vZs7z6BsrHLSuFcB8H4L7bcYaoqo4AumyXOdw/exec";

        RequestQueue queue = Volley.newRequestQueue(getActivity());

        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "Espere por favor",
                "estamos atendiendo a su solicitud");

        JsonArrayRequest request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // Log.e("mi respuest", response.toString());
                dataset = new ArrayList<Songs>();
                dataset = songData(response);
                Log.e("mi respuest", dataset.toString());
                progressDialog.cancel();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.cancel();
                Toast.makeText(getActivity(), "No se pudieron obtener lo datos", Toast.LENGTH_LONG).show();
            }
        });


        queue.add(request);

        Songs hardwell = new Songs();
        hardwell.setSongName("Apolo");
        hardwell.setSongArtist("Hardwell");
        hardwell.setSongStars(3);
        songs.add(hardwell);

        Songs armin = new Songs();
        armin.setSongName("Ping Pong");
        armin.setSongArtist("Armin van Buuren");
        armin.setSongStars(4);
        songs.add(armin);

        Songs dguetta = new Songs();
        dguetta.setSongName("Shout Me Down");
        dguetta.setSongArtist("David Guetta");
        dguetta.setSongStars(3);
        songs.add(dguetta);

        Songs mgarrix = new Songs();
        mgarrix.setSongName("Virus");
        mgarrix.setSongArtist("Martin Garrix");
        mgarrix.setSongStars(4);
        songs.add(mgarrix);

        RecyclerView recyclerView = (RecyclerView) getActivity()
                .findViewById(R.id.my_recycler_view_song);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new SongsAdapter(songs, R.layout.row_songs));
        // recyclerView.setAdapter(new SongsAdapter(dataset, R.layout.row_songs));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public ArrayList<Songs> songData (JSONArray response) {
        ArrayList<Songs> songAux = new ArrayList<Songs>();

        for (int i = 0; i < response.length(); i++) {
            Songs song = new Songs();

            try {
                JSONObject jsonObject = (JSONObject) response.get(i);
                song.setSongName(jsonObject.getString("cancion"));
                song.setSongArtist(jsonObject.getString("artista"));
                song.setSongStars(jsonObject.getInt("estrellas"));

                songAux.add(song);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return songAux;
    }
}
