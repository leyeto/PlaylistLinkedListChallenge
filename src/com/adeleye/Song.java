package com.adeleye;

public class Song {
  private String name;
  private double duration;

  public Song(String name, double duration) {
    this.name = name;
    this.duration = duration;
  }

  public String getName() {
    return name;
  }

  public Song createNewSong(String name, double duration){
    return new Song(name,duration);
  }

  @Override
  public String toString() {
    return this.name + ": " + this.duration;
  }
}
