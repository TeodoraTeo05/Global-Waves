package app.user;

import app.Admin;
import app.audio.Collections.Album;
import app.audio.Collections.AlbumOutput;
import app.audio.Files.Song;
import app.personals.Event;
import app.personals.Merch;
import app.searchBar.SearchBar;
import fileio.input.SongInput;
import lombok.Getter;

import java.util.ArrayList;

public final class Artist extends User {
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
    public Artist(final String username, final int age, final String city) {
        super(username, age, city);
        setType("artist");
        searchBar = new SearchBar(username);
    }

    private static Admin admin = Admin.getInstance();
    /**
     * add an album
     * @param name        the name
     * @param releaseYear the release year
     * @param description the description
     * @param songs       the songs
     * @return the string
     */
    @Override
    public String addAlbum(final String name, final int releaseYear,
                           final String description, final ArrayList<SongInput> songs) {

        for (Album album : admin.getAlbums()) {
            if (album.getOwner().equals(getUsername())) {
                if (album.getName().equals(name)) {
                    return getUsername() + " has another album with the same name.";
                }
            }
        }

        ArrayList<Song> albumSongs = new ArrayList<>();
        int totalLikes = 0;
        for (SongInput songInput : songs) {
            Song song = new Song(songInput.getName(), songInput.getDuration(), name,
                    songInput.getTags(), songInput.getLyrics(), songInput.getGenre(),
                    releaseYear, getUsername());

            totalLikes += song.getLikes();

            albumSongs.add(song);

        }
        for (int i = 0; i < albumSongs.size(); ++i) {
            for (int j = i + 1; j < albumSongs.size(); ++j) {
                if (albumSongs.get(i).getName().equals(albumSongs.get(j).getName())) {
                    return getUsername() + " has the same song at least twice in this album.";
                }
            }
        }

        Album album = new Album(name, getUsername(), albumSongs, releaseYear,
                description, totalLikes);
        admin.addAlbum(album);
        return getUsername() + " has added new album successfully.";

    }

    /**
     * Show albums array list.
     *
     * @return the array list
     */
    @Override
    public ArrayList<AlbumOutput> showAlbums() {
        ArrayList<AlbumOutput> albums = new ArrayList<>();
        for (Album album : admin.getAlbums()) {
            if (album.getOwner().equals(this.getUsername())) {
                albums.add(new AlbumOutput(album));
            }
        }
        return albums;
    }

    /**
     * Add event string.
     * @param name the name
     * @param description the description
     * @param date the date
     * @return
     */

    @Override
    public String addEvent(final String name, final String description, final String date) {
        if (!Event.isValidDate(date)) {
            return "Event for " + getUsername() + " does not have a valid date.";
        }
        ArrayList<Event> events = admin.getEvents();
        for (Event event : events) {
            if (event.getName().equals(name)) {
                return getUsername() + " has another event with the same name.";
            }
        }
        events.add(new Event(getUsername(), name, description, date));
        return getUsername() + " has added new event successfully.";

    }

    /**
     * Add merch string.
     * @param name the name
     * @param description the description
     * @param price the price
     * @return
     */
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
