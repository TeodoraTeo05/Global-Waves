package app;

import app.audio.Collections.Album;
import app.audio.Collections.Playlist;
import app.audio.Collections.Podcast;
import app.audio.Files.Episode;
import app.audio.Files.Song;
import app.audio.personals.Event;
import app.audio.personals.Merch;
import app.audio.personals.ArtistEntry;
import app.audio.personals.HostEntry;
import app.user.Artist;
import app.user.Host;
import app.user.User;
import fileio.input.EpisodeInput;
import fileio.input.PodcastInput;
import fileio.input.SongInput;
import fileio.input.UserInput;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Admin.
 */
public final class Admin {
    @Getter
    private static List<User> users = new ArrayList<>();
    @Getter
    private static List<ArtistEntry> artistsLibrary = new ArrayList<>();
    @Getter
    private static List<HostEntry> hostsLibrary = new ArrayList<>();
    // pt hosts
    private static List<Song> songs = new ArrayList<>();
    private static List<Podcast> podcasts = new ArrayList<>();
    @Getter
    private static List<Album> albums = new ArrayList<>();
    @Getter
    private static ArrayList<Event> events = new ArrayList<>();
    @Getter
    private static ArrayList<Merch> merch = new ArrayList<>();
    private static int timestamp = 0;
    private static final int LIMIT = 5;

    private Admin() {
    }

    /**
     * Sets users.
     *
     * @param userInputList the user input list
     */
    public static void setUsers(final List<UserInput> userInputList) {
        users = new ArrayList<>();
        for (UserInput userInput : userInputList) {
            users.add(new User(userInput.getUsername(), userInput.getAge(), userInput.getCity()));
        }
    }
    /**
     * Sets songs.
     *
     * @param songInputList the song input list
     */
    public static void setSongs(final List<SongInput> songInputList) {
        songs = new ArrayList<>();
        for (SongInput songInput : songInputList) {
            songs.add(new Song(songInput.getName(), songInput.getDuration(), songInput.getAlbum(),
                    songInput.getTags(), songInput.getLyrics(), songInput.getGenre(),
                    songInput.getReleaseYear(), songInput.getArtist()));
        }
    }


    /**
     * Sets podcasts.
     *
     * @param podcastInputList the podcast input list
     */
    public static void setPodcasts(final List<PodcastInput> podcastInputList) {
        podcasts = new ArrayList<>();
        for (PodcastInput podcastInput : podcastInputList) {
            List<Episode> episodes = new ArrayList<>();
            for (EpisodeInput episodeInput : podcastInput.getEpisodes()) {

                episodes.add(new Episode(episodeInput.getName(),
                                         episodeInput.getDuration(),
                                         episodeInput.getDescription()));
            }
            podcasts.add(new Podcast(podcastInput.getName(), podcastInput.getOwner(), episodes));
        }
    }

    /**
     * Gets songs.
     *
     * @return the songs
     */
    public static List<Song> getSongs() {
        return new ArrayList<>(songs);
    }

    /**
     * Gets podcasts.
     *
     * @return the podcasts
     */
    public static List<Podcast> getPodcasts() {
        return new ArrayList<>(podcasts);
    }
    /**
     * Gets playlists.
     *
     * @return the playlists
     */
    public static List<Playlist> getPlaylists() {
        List<Playlist> playlists = new ArrayList<>();
        for (User user : users) {
            playlists.addAll(user.getPlaylists());
        }
        return playlists;
    }

    /**
     * Gets user.
     *
     * @param username the username
     * @return the user
     */
    public static User getUser(final String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Update timestamp.
     *
     * @param newTimestamp the new timestamp
     */
    public static void updateTimestamp(final int newTimestamp) {
        int elapsed = newTimestamp - timestamp;
        timestamp = newTimestamp;
        if (elapsed == 0) {
            return;
        }

        for (User user : users) {
            user.simulateTime(elapsed);
        }
    }

    /**
     * Gets top 5 songs.
     *
     * @return the top 5 songs
     */
    public static List<String> getTop5Songs() {
        List<Song> sortedSongs = new ArrayList<>(songs);
        sortedSongs.sort(Comparator.comparingInt(Song::getLikes).reversed());
        List<String> topSongs = new ArrayList<>();
        int count = 0;
        for (Song song : sortedSongs) {
            if (count >= LIMIT) {
                break;
            }
            topSongs.add(song.getName());
            count++;
        }
        return topSongs;
    }

    /**
     * Gets top 5 playlists.
     *
     * @return the top 5 playlists
     */
    public static List<String> getTop5Playlists() {
        List<Playlist> sortedPlaylists = new ArrayList<>(getPlaylists());
        sortedPlaylists.sort(Comparator.comparingInt(Playlist::getFollowers)
                .reversed()
                .thenComparing(Playlist::getTimestamp, Comparator.naturalOrder()));
        List<String> topPlaylists = new ArrayList<>();
        int count = 0;
        for (Playlist playlist : sortedPlaylists) {
            if (count >= LIMIT) {
                break;
            }
            topPlaylists.add(playlist.getName());
            count++;
        }
        return topPlaylists;
    }

    /**
     * gets the online users
     * @return the online users
     */
    public static List<String> getOnlineUsers() {
        List<String> onlineUsers = new ArrayList<>();
        for (User user : users) {
            if (user.isOnline() && user.getType() == "user") {
                onlineUsers.add(user.getUsername());
            }
        }
        return onlineUsers;
    }

    /**
     * Add user string.
     * @param type the type
     * @param username the username
     * @param age the age
     * @param city the city
     * @return the string with the message
     */
    public static String addUser(final String type, final String username, final Integer age,
                                 final String city) {

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return "The username " + username + " is already taken.";
            }
        }

        if (type.equals("host")) {
            users.add(new Host(username, age, city));
            hostsLibrary.add(new HostEntry(username, age, city));
        }
        if (type.equals("artist")) {
            users.add(new Artist(username, age, city));
            artistsLibrary.add(new ArtistEntry(username, age, city));
        }
        if (type.equals("user")) {
            users.add(new User(username, age, city));
        }

        return "The username " + username + " has been added successfully.";
    }

    /**
     * Add album.
     * @param album
     */
    public static void addAlbum(final Album album) {
        albums.add(album);
        songs.addAll(album.getSongs());

    }

    /**
     * Add event.
     * @param owner
     * @param name
     * @param description
     * @param date
     */
    public static void addEvent(final String owner, final String name,
                                final String description, final String date) {
        events.add(new Event(owner, name, description, date));
    }

    /**
     * Add merch.
     * @param merch
     */
    public static void addMerch(final Merch merch) {
        Admin.merch.add(merch);
    }
    /**
     * Gets All users.
     *
     * @return String with all users
     */
    public static String getAllUsers() {
        List<User> normalUsers = new ArrayList<>();
        List<User> artists = new ArrayList<>();
        List<User> hosts = new ArrayList<>();

        for (User user : users) {
            String type = user.getType();
            if (type.equals("user")) {
                normalUsers.add(user);
            } else if (type.equals("artist")) {
                artists.add(user);
            } else if (type.equals("host")) {
                hosts.add(user);
            }
        }

        List<User> sortedUsers = new ArrayList<>();
        sortedUsers.addAll(normalUsers);
        sortedUsers.addAll(artists);
        sortedUsers.addAll(hosts);


        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (User user : sortedUsers) {
            builder.append(user.getUsername()).append(" ");
        }
        return builder.toString();
    }

    public static List<String> getTop5Albums() {
        List<Album> allAlbums = new ArrayList<>(getAlbums());

        allAlbums.sort((album1, album2) -> {
            int likeComparison = Integer.compare(album2.getLikes(), album1.getLikes());
            if (likeComparison == 0) {
                return album1.getName().compareToIgnoreCase(album2.getName());
            }
            return likeComparison;
        });

        List<String> topAlbums = new ArrayList<>();
        for (int i = 0; i < Math.min(LIMIT, allAlbums.size()); i++) {
            topAlbums.add(allAlbums.get(i).getName());
        }

        return topAlbums;

    }

    /**
     * Reset.
     */
    public static void reset() {
        users = new ArrayList<>();
        songs = new ArrayList<>();
        podcasts = new ArrayList<>();
        albums = new ArrayList<>();
        events = new ArrayList<>();
        merch = new ArrayList<>();
        artistsLibrary = new ArrayList<>();
        hostsLibrary = new ArrayList<>();
        timestamp = 0;
    }


}
