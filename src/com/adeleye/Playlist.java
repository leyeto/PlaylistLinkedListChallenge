package com.adeleye;

import java.util.LinkedList;

public class Playlist {
  private String playlistName;
  private LinkedList<Song> playlist;

  public Playlist(String playlistName,LinkedList playlist){
    this.playlistName = playlistName;
    this.playlist = new LinkedList<>();
  }

  public boolean addSongToPlaylist(Song song){
//    songInAlbum(song);
    return false;

  }



}
