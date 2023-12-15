package app.pages;

import app.audio.Collections.Playlist;
import app.audio.Files.Song;
import app.user.User;
import java.util.ArrayList;

public final class HomePage extends Page {
    private static final int TOP = 5;
    private static final int START = 0;
    public HomePage(final User user) {
        super(user);
    }

    @Override
    public String currentPage() {

        ArrayList<Song> songs= new ArrayList<>(user.getLikedSongs());

        songs.sort((o1, o2) -> o2.getLikes() - o1.getLikes());

        ArrayList<String> songs1 = new ArrayList<>();
        for (int i = START; i < Math.min(TOP, songs.size()); i++) {
            Song song = songs.get(i);
            songs1.add(song.getName());

        }

        ArrayList<Playlist> playlists = user.getPlaylists();

        playlists.sort((o1, o2) -> o2.getTotalLikes() - o1.getTotalLikes());


        ArrayList<String> topPlaylists = new ArrayList<>();
        for (int i = START; i < Math.min(TOP, playlists.size()); i++) {
            Playlist playlist = playlists.get(i);
            topPlaylists.add(playlist.getName());
        }

        return "Liked songs:\n\t" + songs1 + "\n\n" + "Followed playlists:\n\t" + playlists;
    }
}
