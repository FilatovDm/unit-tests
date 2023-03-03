package seminars.third.tdd;

public class UserRepository {

    public boolean addUser(User user, String login, String pass) {
        if (user.auth(login, pass)) {
            return true;
        }
        return false;
    }
}
