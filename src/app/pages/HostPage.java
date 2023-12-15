package app.pages;

import app.user.User;

public final class HostPage extends Page {

    /**
     * @param user
     */

    public HostPage(final User user) {
        super(user);
    }

    /**
     * *method for printing the current page
     */

    @Override
    public String currentPage() {
        return null;
    }
}
