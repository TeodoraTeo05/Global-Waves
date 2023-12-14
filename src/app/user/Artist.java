package app.user;

import app.Admin;
import app.audio.Collections.Album;
import app.audio.Collections.AlbumOutput;
import app.audio.Files.Song;
import app.audio.personals.Event;
import app.audio.personals.Merch;
import app.searchBar.SearchBar;
import fileio.input.SongInput;
import lombok.Getter;

import java.util.ArrayList;

public class Artist extends User {
    @Getter
    private boolean lastSearched;
    @Getter
    private final SearchBar searchBar;
    /**
     * Instantiates a new User.
     *
     * @param username the username
     * @param age      the age
     * @param city     the city
     */
    public Artist(String username, int age, String city) {
        super(username, age, city);
        setType("artist");
        searchBar = new SearchBar(username);
    }



    @Override
    public String addAlbum(final String name, final int releaseYear,
                           final String description, final ArrayList<SongInput> songs) {

        for (Album album : Admin.getAlbums()) {
            if (album.getOwner().equals(getUsername())) {
                if (album.getName().equals(name)) {
                    return getUsername() + " has another album with the same name.";
                }
            }
        }

        ArrayList<Song> albumSongs = new ArrayList<>();
        for (SongInput song : songs) {
            albumSongs.add(new Song(song.getName(), song.getDuration(), name,
                    song.getTags(), song.getLyrics(), song.getGenre(),
                    releaseYear, getUsername()));

        }
        for (int i = 0; i < albumSongs.size(); ++i) {
            for (int j = i + 1; j < albumSongs.size(); ++j) {
                if (albumSongs.get(i).getName().equals(albumSongs.get(j).getName())) {
                    return getUsername() + " has the same song at least twice in this album.";
                }
            }
        }
        Album album = new Album(name, getUsername(), albumSongs, releaseYear, description);
        Admin.addAlbum(album);
        return getUsername() + " has added new album successfully.";

    }
    @Override
    public ArrayList<AlbumOutput> showAlbums() {
        ArrayList<AlbumOutput> albums = new ArrayList<>();
        for (Album album : Admin.getAlbums()) {
            if (album.getOwner().equals(this.getUsername())) {
                albums.add(new AlbumOutput(album));
            }
        }
        return albums;
    }
    public String addEvent(final String name, final String description, final String date) {
        if (!Event.DateValidator.isValidDate(date)) {
            return getUsername() + " does not have a valid date.";
        }
        ArrayList<Event> events = Admin.getEvents();
        for (Event event : events) {
            if (event.getName().equals(name)) {
                return getUsername() + " has another event with the same name.";
            }
        }
        events.add(new Event(getUsername(), name, description, date));
        return getUsername() + " has added new event successfully.";

    }
    @Override
    public String addMerch(final String name, final String description, final Integer price) {
        if (price < 0) {
            return "Price for merchandise can not be negative.";
        }
        ArrayList<Merch> merchs = Admin.getMerch();
        for (Merch merch : merchs) {
            if (merch.getName().equals(name)) {
                return getUsername() + " has merchandise with the same name.";
            }
        }
        merchs.add(new Merch(getUsername(), name, description, price));
        return getUsername() + " has added new merchandise successfully.";

    }
}
