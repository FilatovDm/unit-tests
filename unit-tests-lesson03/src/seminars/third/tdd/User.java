package seminars.third.tdd;

import java.util.Objects;

public class User {
    public String name;
    public String pass;

    public User (String name, String pass){
        this.name = name;
        this.pass = pass;
    }

    public boolean auth(String login, String pass){
        return Objects.equals(login, this.name) && Objects.equals(pass, this.pass);
    }

}
