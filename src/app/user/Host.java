package app.user;

import app.Admin;
import app.audio.Collections.Album;
import app.audio.Collections.Podcast;
import app.audio.Files.Episode;
import app.personals.Announcement;
import app.personals.Event;
import fileio.input.EpisodeInput;

import java.util.ArrayList;
import java.util.List;

public class Host extends User {

    Admin admin = Admin.getInstance();
    /**
     * Instantiates a new User.
     *
     * @param username the username
     * @param age      the age
     * @param city     the city
     */
    public Host(final String username, final int age, final String city) {
        super(username, age, city);
        setType("host");
    }

    public String addPodcast(final String name, final ArrayList<EpisodeInput> episodeInputs) {

        for (Podcast podcast : admin.getPodcasts()) {
            if (podcast.getOwner().equals(getUsername())) {
                if (podcast.getName().equals(name)) {
                    return getUsername() + " has another podcast with the same name.";
                }
            }
            if (podcast.isDuplicate(name)) {
                return getUsername() + " has the same episode in this podcast.";
            }
        }
        ArrayList<Episode> episodes = new ArrayList<>();
        for (EpisodeInput input : episodeInputs) {
            Episode episode = new Episode(input.getName(), input.getDuration(), input.getDescription());
            episodes.add(episode);
        }

        Podcast podcastAdd = new Podcast(name, getUsername(), episodes);
        admin.addPodcasts(podcastAdd);
        return getUsername() + " has added new podcast successfully.";

    }

    public String removePodcast(final String name) {
        List<Podcast> podcasts = admin.getPodcasts();
        for (int i = 0; i < podcasts.size(); i++) {
            Podcast podcast = podcasts.get(i);
            if (podcast.getOwner().equals(getUsername()) && podcast.getName().equals(name)) {
                podcasts.remove(i);
                return getUsername() + " deleted the podcast successfully.";
            }
        }
        return getUsername() + " doesn't have a podcast with the given name.";
    }

    public String addAnnouncement(final String name, final String description) {
        ArrayList<Announcement> announcements = admin.getAnnouncements();
        for (Announcement announcement : announcements) {
            if (announcement.getName().equals(name)) {
                return getUsername() + " has already added an announcement with this name.";
            }
        }
        announcements.add(new Announcement(getUsername(), name, description));
        return getUsername() + " has successfully added new announcement.";
    }

}
