package app.personals;

import app.audio.LibraryEntry;
import lombok.Getter;

public final class ArtistEntry extends LibraryEntry {
    @Getter
    private int age;
    @Getter
    private String city;

    public ArtistEntry(final String name, final int age, final String city) {
        super(name);
        this.age = age;
        this.city = city;

    }
}
