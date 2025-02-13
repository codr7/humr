package codr7.humr;

import codr7.humr.models.User;

public class Context {
    public final Database db = new Database();
    public final codr7.tyred.Context dbContext;
    private User currentUser;

    public Context(final String path, final String user, final String password) {
        dbContext = new codr7.tyred.Context(path, user, password);
    }

    public void setUser(final User user) {
        currentUser = user;
    }

    public User currentUser() {
        return currentUser;
    }
}
