package app.pages;

import app.user.User;

public final class HostPage extends Page {

    public HostPage(final User user) {
        super(user);
    }

    @Override
    public String currentPage() {
        return null;
    }
}
