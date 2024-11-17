package com.music;

import java.util.LinkedList;
import java.util.ArrayList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public Album() {
    }

    public Song findSong(String title){
        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            songs.add(new Song(title,duration));
//            System.out.println((title + "Successfully added to the list"));
            return true;
        }
        else{
//            System.out.println("Song with name:" + title + "already exists");
            return false;
        }
    }
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> PlayList) {
        int index = trackNumber - 1;
        if (index >=0 && index < this.songs.size()) {
            PlayList.add(this.songs.get(index));
//            System.out.println("Track number " + trackNumber + " added to the playlist.");
            return true;
        }
//        System.out.println("This album does not have song with tracknumber" + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
//            System.out.println(title + " added to the playlist.");
            return true;
        }
//        System.out.println(title + " - there is no such song in the album.");
        return false;
    }
}
