package app.pages;

import app.audio.Collections.Playlist;
import app.audio.Files.Song;
import app.pages.Page;
import app.user.User;

import java.util.ArrayList;

public class HomePage extends Page {
    public HomePage(User user) {
        super(user);

    }

    @Override
    public String currentPage() {

        ArrayList<Song> songs= new ArrayList<>(user.getLikedSongs());

        songs.sort((o1, o2) -> o2.getLikes() - o1.getLikes());

        ArrayList<String> songs1 = new ArrayList<>();
        for (int i = 0; i < Math.min(5, songs.size()); i++) {
            Song song = songs.get(i);
            songs1.add(song.getName());

        }

        ArrayList<Playlist> playlists = user.getPlaylists();

        for (int i = 0; i < playlists.size() - 1; i++) {
            for (int j = 0; j < playlists.size() - i - 1; j++) {
                if (playlists.get(j).getTotalLikes() < playlists.get(j + 1).getTotalLikes()) {
                    Playlist temp = playlists.get(j);
                    playlists.set(j, playlists.get(j + 1));
                    playlists.set(j + 1, temp);
                }
            }
        }

        ArrayList<String> topPlaylists = new ArrayList<>();
        for (int i = 0; i < Math.min(5, playlists.size()); i++) {
            Playlist playlist = playlists.get(i);
            topPlaylists.add(playlist.getName());
        }

        return "Liked songs:\n\t" + songs1 + "\n\n" + "Followed playlists:\n\t" + playlists;
    }
}
