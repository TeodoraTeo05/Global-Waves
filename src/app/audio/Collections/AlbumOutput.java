package app.audio.Collections;

import lombok.Getter;
import java.util.ArrayList;
@Getter
public class AlbumOutput {
    private final String name;
    private static final int LIMIT = 0;
    private final ArrayList<String> songs;

    public AlbumOutput(final Album album) {
        this.name = album.getName();
        this.songs = new ArrayList<>();
        for (int i = LIMIT; i < album.getSongs().size(); i++) {
            songs.add(album.getSongs().get(i).getName());
        }
    }
}
