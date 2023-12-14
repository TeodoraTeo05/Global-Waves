package app.audio.personals;

import app.audio.LibraryEntry;

public class HostEntry extends LibraryEntry {
    private int age;
    private String city;

    public HostEntry(String name, int age, String city) {
        super(name);
        this.age = age;
        this.city = city;

    }
}
