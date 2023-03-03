package seminars.third.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    /**
     * 3.6. Нужно написать класс User (пользователь) с методом аутентификации по логину и паролю,
     * (В метод передаются логин и пароль, метод возвращает true, если пароль и логин совпадают, иначе - false)
     */
    @Test
    void userCreation() {
        User user = new User("Pavel", "qwerty");
        String login = "Pavel";
        String pass = "qwerty";
        assertTrue(user.auth(login, pass));

    }

    @Test
    void userCreationFalsePass() {
        User user = new User("Pavel", "qwerty");
        String login = "Pavel";
        String pass = "qwerty123";
        assertFalse(user.auth(login, pass));

    }

    @Test
    void userCreationFalseName() {
        User user = new User("Pavel", "qwerty");
        String login = "Pavel123";
        String pass = "qwerty";
        assertFalse(user.auth(login, pass));

    }

    @Test
    void userRepAdd() {
        User user = new User("Pavel", "qwerty");
        String login = "Pavel";
        String pass = "qwerty";

        UserRepository userRep = new UserRepository();
        assertTrue(userRep.addUser(user, login, pass));
    }

    @Test
    void userRepNonAddFalsePass() {
        User user = new User("Pavel", "qwerty");
        String login = "Pavel";
        String pass = "qwerty123";

        UserRepository userRep = new UserRepository();
        assertFalse(userRep.addUser(user, login, pass));
    }

    @Test
    void userRepNonAddFalseLogin() {
        User user = new User("Pavel", "qwerty");
        String login = "Pavel123";
        String pass = "qwerty";

        UserRepository userRep = new UserRepository();
        assertFalse(userRep.addUser(user, login, pass));
    }

}
