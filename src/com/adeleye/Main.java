package com.adeleye;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

  private static ArrayList<Album> albums = new ArrayList<>();
  public static void main(String[] args) {
    Album album = new Album("Stormbringer", "Deep Purple");
    album.addSong("Stormbringer",4.2);
    album.addSong("Shades",4.7);
    album.addSong("Violet",4.1);
    album.addSong("Bin",3.6);
    album.addSong("stormbringer",4.2);
    album.addSong("Stormbringer",4.2);

    albums.add(album);



    album = new Album("For those about to rock", "AC/DC");
    album.addSong("For those about to rock", 4.5);
    album.addSong("I put the finger on you", 3.5);
    album.addSong("Lets go", 3.3);
    album.addSong("Inject the venom", 3.33);
    album.addSong("Snowballed", 4.53);
    album.addSong("Evil walks", 3.35);
    album.addSong("C.O.D", 5.24);

    albums.add(album);

    LinkedList<Song> playList = new LinkedList<>();//Playlist created here

    albums.get(1).addToPlaylist("C.O.D",playList);

    play(playList);

  }

  private static void play(LinkedList<Song> playlist){
    Scanner scanner = new Scanner(System.in);
    boolean quit = false;
    boolean forward = true;


    ListIterator<Song> listIterator = playlist.listIterator();

    if(playlist.size() == 0){
      System.out.println("No songs in playlist");
      return;
    }else {
      System.out.println("Now playing " + listIterator.next().toString());
    }

    while(!quit){
      int action = scanner.nextInt();

      switch (action){
        case 0:
          System.out.println("Playlist complete");
          quit = true;
          break;
          case 1:
            if(!forward){
              if(listIterator.hasNext()){
                listIterator.next();
              }
              forward = true;
            }
            if(listIterator.hasNext()){
              System.out.println("Now playing " + listIterator.next().toString());
            }else {
              System.out.println("We have reached the end of the playlist");
              forward=false;
            }

          break;
          case 2:
            if(forward){
              if(listIterator.hasPrevious()){
                listIterator.previous();
              }
              forward=false;
            }
            if(listIterator.hasPrevious()){
              System.out.println("Now playing " + listIterator.previous().toString());
            }else {
              System.out.println("We are at the start of the playlist");
              forward= true;
            }

          break;
          case 3:

          break;
          case 4:
          printList(playlist);
          break;
          case 5:
//          printMenu();
          break;

      }
    }


  }

  public static void printList(LinkedList<Song> playlist){
    if(playlist.isEmpty()){
      System.out.println("Playlist is empty");
      return;
    }else {
      System.out.println("Playlist has " + playlist.size() + " tracks:");
      for (int i = 0; i < playlist.size(); i++){
        System.out.println("Track " + i + ": " + playlist.get(i).toString());
      }
    }
  }


}
