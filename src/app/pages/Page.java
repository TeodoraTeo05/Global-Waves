package app.pages;

import app.user.User;

public abstract class Page {
    protected User user;

    public Page(final User user) {
        this.user = user;
    }
    public abstract String currentPage();
}
