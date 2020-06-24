package udemy_exercises.songs;

import java.util.*;

public class Main {

    Scanner s, sc;

    ArrayList<Album> library = new ArrayList<Album>();
    ArrayList<Song> playlist = new ArrayList<Song>();

    public void playlistMenu() {

        int option = 0;
        ListIterator<Song> myiterator = playlist.listIterator();

        while (option != 99) {

            System.out.println("\nPlease enter in an option from the menu:");
            System.out.println(
                    "\t1. Next Song\n\t2. Previous Song\n\t3. Replay Current Song\n\t4. Show Playlist\n\t99. Quit");

            option = s.nextInt();

            switch (option) {

                case 1:
                    System.out.println("\n");
                    playNext(myiterator);
                    break;

                case 2:
                    System.out.println("\n");
                    playPrevious(myiterator);
                    break;

                case 3:
                    System.out.println("\n");
                    replayCurrent(myiterator);
                    break;

                case 4:
                    System.out.println("\n");
                    showPlaylist();
                    break;

                case 99:
                    break;

                default:
                    System.out.println("\n");
                    System.out.println("Please enter a valid option.");
                    System.out.println("\n");
            }
        }
    }

    void playNext(ListIterator<Song> li) {
        try {
            li.next();
            System.out.println("Now playing: " + playlist.get(li.nextIndex()).title);
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("There is no song to play next.");
        }
    }

    void playPrevious(ListIterator<Song> li) {
        try {
            li.previous();
            System.out.println("Now playing: " + playlist.get(li.previousIndex()).title);
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("There is no previous song to play.");
        }
    }

    void replayCurrent(ListIterator<Song> li) {
        System.out.println("Now playing: " + playlist.get(li.nextIndex()).title);
    }

    void showPlaylist() {
        for (Song s : playlist) {
            System.out.println(s.title + " (" + s.duration + ")");
        }
    }

    public void menu() {

        s = new Scanner(System.in);
        sc = new Scanner(System.in);
        int option = 0;

        while (option != 99) {

            System.out.println("\nPlease enter in an option from the menu:");
            System.out.println(
                    "\t1. Create New Album\n\t2. Add Song to Album\n\t3. Add Song to Playlist\n\t4. Play Playlist\n\t5. Show Library\n\t99. Quit");

            option = s.nextInt();

            switch (option) {

                case 1:
                    System.out.println("\n");
                    createAlbum();
                    break;

                case 2:
                    System.out.println("\n");
                    addSongToAlbum();
                    break;

                case 3:
                    System.out.println("\n");
                    addSongToPlaylist();
                    break;

                case 4:
                    System.out.println("\n");
                    playlistMenu();
                    break;

                case 5:
                    System.out.println("\n");
                    showLibrary();
                    break;

                case 99:
                    break;

                default:
                    System.out.println("\n");
                    System.out.println("Please enter a valid option.");
                    System.out.println("\n");
            }
        }
    }

    void createAlbum() {

        System.out.print("Enter name of Album: ");
        String albumName = sc.nextLine();

        if (getAlbum(albumName) == -1) {
            library.add(new Album(albumName));
            System.out.println("Album Created!");
        } else {
            System.out.println("Album already exists. Please create a unique album or add a song to this one instead.");
        }

    }

    void addSongToAlbum() {
        System.out.print("Enter name of Album: ");
        String albumName = sc.nextLine();

        int albumIndex = getAlbum(albumName);

        if (albumIndex == -1) {
            System.out.println("Album does not exist! Please try again.");
        } else {
            library.get(albumIndex).addSong();
        }
    }

    void addSongToPlaylist() {
        System.out.print("Enter name of Song: ");
        String songName = sc.nextLine();

        for (Album a : library) {
            for (Song s : a.songList) {
                if (s.title.equals(songName)) {
                    playlist.add(s);
                    return;
                }
            }
        }

        System.out.println("Song Not Found! Please try again.");
    }

    int getAlbum(String name) {

        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).albumName.equals(name)) {
                return i;
            }
        }

        return -1;
    }

    void showLibrary() {

        for (Album a : library) {
            System.out.println("[+] " + a.albumName);
            for (Song s : a.songList) {
                System.out.println("\t- " + s.title);
            }
        }
    }

    public static void main(String args[]) {

        Main m = new Main();
        m.menu();

    }
}

/*
**Song Player w/ Java Classes**
     - **Album class** 
       - Playlist of **Songs**.
       - addPlayist() (songs must appear in the list in the order by which they were added)
       - stop()
       - nextSong()
       - previousSong()
       - repeatSong()
       - showPlaylist()
       - removePlaylist()
     - **A song must exist in an album before it can be added to the playlist (so you can only play songs that you own.)**
*/

// Create a program that implements a playlist for songs
// Create a Song class having Title and Duration for a song.

// The program will have an Album class containing a list of songs.

// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist
// A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).

// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listiterator.remove()