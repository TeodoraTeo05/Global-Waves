package app.audio.Collections;


import lombok.Getter;
import java.util.ArrayList;
import java.util.List;


public class PodcastOutput {
    @Getter
    private String name;
    @Getter
    private List<String> episodes; // List of episode names for simplicity

    /**
     * Instantiates a new Podcast output.
     *
     * @param podcast the podcast
     */
    public PodcastOutput(final Podcast podcast) {
        this.name = podcast.getName();
        this.episodes = new ArrayList<>();
        for (int i = 0; i < podcast.getEpisodes().size(); i++) {
            episodes.add(podcast.getEpisodes().get(i).getName());
        }

    }
}
