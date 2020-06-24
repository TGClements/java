package udemy_exercises.songs;

import java.util.*;

public class Album {

  Scanner s, sc;
  String albumName;
  ArrayList<Song> songList = new ArrayList<Song>();

  public Album(String name) {
    this.albumName = name;
    s = new Scanner(System.in);
    sc = new Scanner(System.in);
  }

  public void addSong() {
    System.out.print("Enter song name: ");
    String songName = s.nextLine();
    System.out.print("Enter song duration: ");
    double duration = sc.nextDouble();

    int songIndex = getSong(songName);

    if (songIndex == -1) {
      songList.add(new Song(songName, duration));
    } else {
      System.out.println("Song already exists! Please try again.");
    }
  }

  int getSong(String name) {

    for (int i = 0; i < songList.size(); i++) {
      if (songList.get(i).title.equals(name)) {
        return i;
      }
    }

    return -1;
  }
}