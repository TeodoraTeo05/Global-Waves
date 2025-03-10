package app.pages;

import app.Admin;
import app.audio.Collections.Album;
import app.personals.Event;
import app.personals.Merch;
import app.user.User;

import java.util.ArrayList;
import java.util.List;

public final class ArtistPage extends Page {
    /**
     * @param user
     */
    public ArtistPage(final User user) {
        super(user);
    }

    /**
     * *method for printing the current page
     */

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
        if (artistAlbums.isEmpty()) {
            builder.append("\t[]\n");
        } else {
            builder.append("\t[");
            for (int i = 0; i < artistAlbums.size(); i++) {
                Album album = artistAlbums.get(i);
                builder.append(album.getName());
                if (i < artistAlbums.size() - 1) {
                    builder.append(", ");
                }
            }
            builder.append("]\n");


            ArrayList<Merch> artistMerch = new ArrayList<>();
            for (Merch merch : Admin.getMerch()) {
                if (this.user.getUsername().equals(merch.getOwner())) {
                    artistMerch.add(merch);
                }
            }
            builder.append("\nMerch:\n");
            if (artistMerch.isEmpty()) {
                builder.append("\t[]\n");
            } else {
                builder.append("\t[");
                for (int i = 0; i < artistMerch.size(); i++) {
                    Merch merch = artistMerch.get(i);
                    builder.append(merch.getName());
                    if (merch.getPrice() != null) {
                        builder.append(" - ").append(merch.getPrice());
                    }
                    if (merch.getDescription() != null) {
                        builder.append(":\n\t").append(merch.getDescription());
                    }

                    if (i < artistMerch.size() - 1) {
                        builder.append(", ");
                    }
                }
                builder.append("]\n");


            }
            ArrayList<Event> events = Admin.getEvents();
            ArrayList<Event> artistEvents = new ArrayList<>();
            for (Event event : events) {
                if (this.user.getUsername().equals(event.getOwner())) {
                    artistEvents.add(event);
                }
            }
            builder.append("\nEvents:\n");
            if (artistEvents.isEmpty()) {
                builder.append("\t[]\n");
            } else {
                builder.append("\t[");
                for (int i = 0; i < artistEvents.size(); i++) {
                    Event event = artistEvents.get(i);
                    builder.append(event.getName());
                    if (event.getDate() != null) {
                        builder.append(" - ").append(event.getDate());
                    }
                    if (event.getDescription() != null) {
                        builder.append(":\n\t").append(event.getDescription());
                    }

                    if (i < artistEvents.size() - 1) {
                        builder.append(", ");
                    }
                }
                builder.append("]");
            }
        }


            return builder.toString();
        }
}
