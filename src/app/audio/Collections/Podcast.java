package app.audio.Collections;

import app.audio.Files.AudioFile;
import app.audio.Files.Episode;
import java.util.List;

public final class Podcast extends AudioCollection {
    private final List<Episode> episodes;


    public Podcast(final String name, final String owner, final List<Episode> episodes) {
        super(name, owner);
        this.episodes = episodes;
    }
    public String getOwner() {
        return super.getOwner();
    }

    public boolean isDuplicate(final String name) {
        for (Episode episode : episodes) {
            if (episode.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public int getNumberOfTracks() {
        return episodes.size();
    }

    @Override
    public AudioFile getTrackByIndex(final int index) {
        return episodes.get(index);
    }
}
