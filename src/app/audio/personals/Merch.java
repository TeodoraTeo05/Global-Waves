package app.audio.personals;

import lombok.Getter;

public final class Merch {
    @Getter
    private String owner;
    @Getter
    private String name;
    @Getter
    private String description;
    @Getter
    private Integer price;

    public Merch(final String owner, final String name, final String description,
                 final Integer price) {
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
