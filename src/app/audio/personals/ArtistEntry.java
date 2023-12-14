package app.audio.personals;

import app.audio.LibraryEntry;
import lombok.Getter;

public class ArtistEntry extends LibraryEntry {
    @Getter
    private int age;
    @Getter
    private String city;

    public ArtistEntry(String name, int age, String city) {
        super(name);
        this.age = age;
        this.city = city;

    }
}
