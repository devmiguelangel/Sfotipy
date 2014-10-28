package com.mgm.sfotipy.models;

/**
 * Created by miguel on 25/10/2014.
 */
public class Songs {

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public int getSongStars() {
        return songStars;
    }

    public void setSongStars(int songStars) {
        this.songStars = songStars;
    }

    String songName;
    String songArtist;
    int songStars;
}
