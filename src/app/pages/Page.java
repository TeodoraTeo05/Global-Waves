package app.pages;

import app.user.User;

public abstract class Page {
    protected User user;

    /**
     * @param user
     */
    public Page(final User user) {
        this.user = user;
    }

    /**
     * *method for printing the current page
     */
    public abstract String currentPage();
}
