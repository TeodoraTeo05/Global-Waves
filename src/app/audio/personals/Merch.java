package app.audio.personals;

import app.audio.LibraryEntry;
import lombok.Getter;

public class Merch {
    @Getter
    private String owner;
    @Getter
    private String name;
    @Getter
    private String description;
    @Getter
    private Integer price;

    public Merch(String owner, String name, String description, Integer price) {
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
