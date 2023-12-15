package app.audio.Collections;

import app.audio.Files.AudioFile;
import app.audio.Files.Song;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
@Getter
public final class Album extends AudioCollection {
    private ArrayList<Song> songs;
    private Integer releaseYear;
    private String description;
    private Integer likes;

    public Album(final String name, final String owner, final ArrayList<Song> songs,
                 final Integer releaseYear, final String description, final Integer likes) {
        super(name, owner);
        this.songs = songs;
        this.releaseYear = releaseYear;
        this.description = description;
        this.likes = likes;
    }

    @Override
    public int getNumberOfTracks() {
        return songs.size();
    }

    @Override
    public AudioFile getTrackByIndex(final int index) {
        return songs.get(index);
    }
    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(final ArrayList<Song> songs) {
        this.songs = songs;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(final Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
