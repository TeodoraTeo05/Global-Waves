package app.pages;

import app.Admin;
import app.audio.Collections.Album;
import app.audio.personals.Event;
import app.audio.personals.Merch;
import app.user.User;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class ArtistPage extends Page {
    public ArtistPage(User user) {
        super(user);
    }

    @Override
    public String currentPage() {
        StringBuilder builder = new StringBuilder();

        List<Album> albums = Admin.getAlbums();
        ArrayList<Album> artistAlbums = new ArrayList<>();
        for (Album album : albums) {
            if (this.user.getUsername().equals(album.getOwner())) {
                artistAlbums.add(album);
            }
        }
        builder.append("Albums:\n");
        for (Album artistAlbum : artistAlbums) {
            builder.append("\t").append(artistAlbum.getName()).append("\n");
        }

        ArrayList<Merch> artistMerch = new ArrayList<>();
        for (Merch merch : Admin.getMerch()) {
            if (this.user.getUsername().equals(merch.getOwner())) {
                artistMerch.add(merch);
            }
        }
        builder.append("\nMerch:\n");
        for (Merch merchItem : artistMerch) {
            // Format as needed, for example:
            builder.append("\t").append(merchItem.getName()).append(" - ").append(merchItem.getDescription()).append("\n");
        }
        ArrayList<Event> events = Admin.getEvents();
        ArrayList<Event> artistEvents = new ArrayList<>();
        for (Event event : events ) {
            if (this.user.getUsername().equals(event.getOwner())) {
                artistEvents.add(event);
            }
        }
        builder.append("\nEvents:\n");

        for (Event event : artistEvents) {
            builder.append("\t[").append(event.getName()).append(" - ").append(event.getDate()).append(":\n\t")
                    .append(event.getDescription()).append("]\n");
        }


        return builder.toString();
    }


}
