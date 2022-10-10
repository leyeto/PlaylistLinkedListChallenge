package com.adeleye;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

  private String albumName;
  private ArrayList<Song> songsList;
  private String albumArtist;

  public Album(String albumName, String albumArtist) {
    this.albumName = albumName;
    this.albumArtist = albumArtist;
    this.songsList = new ArrayList<>();
  }

  public boolean addSong(String songName, double songDuration) {
    if (songInAlbum(songName)) {
      System.out.println(songName + " already exists in album");
      return false;
    } else {
      this.songsList.add(new Song(songName, songDuration));
      System.out.println(songName + " added");
      return true;
    }
  }

  public int songIndex(Song songToFind) {
    return songsList.indexOf(songToFind);
  }

  public Song findSong(String songName){
    for(Song checkedSong: this.songsList){
      if(checkedSong.getName().equalsIgnoreCase(songName)){
        return checkedSong;
      }
    }
    return null;
  }


  public boolean songInAlbum(String findSong) {
    for (int i = 0; i < this.songsList.size(); i++) {
      if (this.songsList.get(i).getName().equalsIgnoreCase(findSong)) {
        return true;
      }
    }
    return false;
  }

  public String getAlbumName() {
    return this.albumName;
  }

  public ArrayList<Song> getSongsList() {
    return songsList;
  }

  public boolean addToPlaylist(String songToAdd, LinkedList<Song> playlist){
    Song songFound = findSong(songToAdd);
    if(songFound!= null){
      playlist.add(songFound);
      System.out.println(songToAdd + " added as track " + playlist.size());
      return true;
    }else{
      System.out.println(songToAdd + " not found, unable to add ");
      return false;
    }

  }

}
