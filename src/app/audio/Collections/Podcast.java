package app.audio.Collections;

import app.audio.Files.AudioFile;
import app.audio.Files.Episode;
import java.util.List;

public final class Podcast extends AudioCollection {
    private final List<Episode> episodes;

    /**
     * Instantiates a new Podcast.
     *
     * @param name     the name
     * @param owner    the owner
     * @param episodes the episodes
     */
    public Podcast(final String name, final String owner, final List<Episode> episodes) {
        super(name, owner);
        this.episodes = episodes;
    }

    /**
     * Gets owner.
     * @return the owner
     */
    public String getOwner() {
        return super.getOwner();
    }

    /**
     * Is duplicate boolean.
     * @param name the name
     * @return the boolean
     */

    public boolean isDuplicate(final String name) {
        for (Episode episode : episodes) {
            if (episode.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Gets episodes.
     * @return the episodes
     */

    public List<Episode> getEpisodes() {
        return episodes;
    }
    /**
     * Gets number of tracks.
     * @return the number of tracks
     */
    @Override
    public int getNumberOfTracks() {
        return episodes.size();
    }

    @Override
    public AudioFile getTrackByIndex(final int index) {
        return episodes.get(index);
    }
}
