package app.audio.personals;

import app.audio.LibraryEntry;

public final class HostEntry extends LibraryEntry {
    private int age;
    private String city;

    public HostEntry(final String name, final int age, final String city) {
        super(name);
        this.age = age;
        this.city = city;

    }
}
