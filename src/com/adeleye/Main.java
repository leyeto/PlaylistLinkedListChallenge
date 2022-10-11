package com.adeleye;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

  private static ArrayList<Album> albums = new ArrayList<>();

  public static void main(String[] args) {
    Album album = new Album("Stormbringer", "Deep Purple");
    album.addSong("Stormbringer", 4.2);
    album.addSong("Shades", 4.7);
    album.addSong("Violet", 4.1);
    album.addSong("Bin", 3.6);
    album.addSong("stormbringer", 4.2);
    album.addSong("Stormbringer", 4.2);

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

    albums.get(1).addToPlaylist("Evil walks", playList);
    albums.get(1).addToPlaylist("C.O.D", playList);
    albums.get(1).addToPlaylist("Lets go", playList);
    albums.get(1).addToPlaylist("For those about to rock", playList);
    albums.get(0).addToPlaylist("Stormbringer", playList);
    albums.get(0).addToPlaylist("Bin", playList);
    albums.get(0).addToPlaylist("Shades", playList);

    play(playList);

  }

  private static void play(LinkedList<Song> playlist) {
    Scanner scanner = new Scanner(System.in);
    boolean quit = false;
    boolean forward = true;

    ListIterator<Song> listIterator = playlist.listIterator();

    if (playlist.size() == 0) {
      System.out.println("No songs in playlist");
      return;
    } else {
      System.out.println("Now playing " + listIterator.next().toString());
    }

    while (!quit) {
      int action = scanner.nextInt();

      switch (action) {
        case 0:
          System.out.println("Playlist complete");
          quit = true;
          break;
        case 1:
          if (!forward) {
            if (listIterator.hasNext()) {
              listIterator.next();
            }
            forward = true;
          }
          if (listIterator.hasNext()) {
            System.out.println("Now playing " + listIterator.next().toString());
          } else {
            System.out.println("We have reached the end of the playlist");
//            forward = false;
          }

          break;
        case 2:
          if (forward) {
            if (listIterator.hasPrevious()) {
              listIterator.previous();
            }
            forward = false;
          }
          if (listIterator.hasPrevious()) {
            System.out.println("Now playing " + listIterator.previous().toString());
          } else {
            System.out.println("We are at the start of the playlist");
            forward = true;
          }

          break;
        case 3:
          if (forward) {
            if (listIterator.hasPrevious()) {
              System.out.println("Now replaying " + listIterator.previous().toString());
              forward = false;
            } else {
              System.out.println("This is the beginning of playlist");
            }
          } else {
            if (listIterator.hasNext()) {
              System.out.println("Now playing " + listIterator.next().toString());
              forward = true;
            } else {
              System.out.println("We have reach the end of the list");
            }
          }

          break;
        case 4:
          printList(playlist);
          break;
        case 5:
          printMenu();
          break;

        case 6:
          if(playlist.size() > 0){

            if (forward) {
              if (listIterator.hasPrevious()) {
                listIterator.previous();
                System.out.println("Next song removed");
                listIterator.remove();
              } else {
                System.out.println("This is the start of playlist");
              }
            } else {
              if (listIterator.hasNext()) {
                listIterator.remove();
                System.out.println("Next song removed");
              } else {
                System.out.println("This is the end of the list");
              }
            }

          }

          break;

      }
    }
  }

  public static void printMenu() {
    System.out.println("Available actions:\npress");
    System.out.println("0 - to quit\n" +
        "1 - to play next song\n" +
        "2 - to play previous song\n" +
        "3 - to replay current song\n" +
        "4 - list songs in playlist\n" +
        "5 - to print menu options\n" +
        "6 - to remove current song from playlist\n"
    );
  }

  public static void printList(LinkedList<Song> playlist) {
    if (playlist.isEmpty()) {
      System.out.println("Playlist is empty");
      return;
    } else {
      Iterator<Song> iterator = playlist.iterator();
      while (iterator.hasNext()) {
        System.out.println(iterator.next().toString());
      }
    }
  }
}
