package com.music;

import java.util.*;

public class Main {

    public static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album 1", "Chainsmokers");
        album.addSong("TNT", 4.5);
        album.addSong("CNT", 5.5);
        album.addSong("BDC", 6.5);
        albums.add(album);

        album = new Album("Album 2", "TheLocalTrain");
        album.addSong("BNT", 4.5);
        album.addSong("KNT", 5.5);
        album.addSong("VDC", 6.5);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlaylist("TNT", playList_1);
        albums.get(0).addToPlaylist("CNT", playList_1);
        albums.get(0).addToPlaylist("BDC", playList_1);
        albums.get(1).addToPlaylist("BNT", playList_1);

        play(playList_1);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("This playlist has no songs.");
            return;
        } else {
            System.out.println("Now playing: " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;

                case 1: // Play next song
                    if (!forward) {
                        if (listIterator.hasNext()) listIterator.next();
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing: " + listIterator.next().toString());
                    } else {
                        System.out.println("End of playlist.");
                        forward = false;
                    }
                    break;

                case 2: // Play previous song
                    if (forward) {
                        if (listIterator.hasPrevious()) listIterator.previous();
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing: " + listIterator.previous().toString());
                    } else {
                        System.out.println("Start of playlist.");
                        forward = true;
                    }
                    break;

                case 3: // Replay the current song
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Replaying: " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("Start of playlist.");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Replaying: " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("End of playlist.");
                        }
                    }
                    break;

                case 4: // List all songs
                    printList(playList);
                    break;

                case 5: // Print menu
                    printMenu();
                    break;

                case 6: // Delete current song
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing: " + listIterator.next().toString());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing: " + listIterator.previous().toString());
                        } else {
                            System.out.println("Playlist is now empty.");
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid action. Please select a valid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nAvailable options:\nPress:");
        System.out.println("0 - to quit\n" +
                "1 - to play the next song\n" +
                "2 - to play the previous song\n" +
                "3 - to replay the current song\n" +
                "4 - to list all songs\n" +
                "5 - to print all available options\n" +
                "6 - to delete the current song");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-----------------");
    }
}
