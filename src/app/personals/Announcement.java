package app.personals;

import lombok.Getter;

public final class Announcement {
    @Getter
    private String owner;
    @Getter
    private String name;
    @Getter
    private String description;

    public Announcement(final String owner, final String name, final String description) {
        this.owner = owner;
        this.name = name;
        this.description = description;
    }
}
