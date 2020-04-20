package sample;

import exceptions.InvalidUserFormatException;
import javafx.beans.property.SimpleStringProperty;

public class User {

    private SimpleStringProperty username,password;

    public User(String username, String password){
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        if(username.matches("\"^[a-zA-Z0-9_-]{6,15}$\"")) {
            //regex hentet fra https://mkyong.com/regular-expressions/how-to-validate-username-with-regular-expression/
            this.username.set(username);
        }else{
            throw new InvalidUserFormatException("Invalid username!\nUsername requirements:\n" +
                                                "-Characters allowed: a-z, A-Z, 0-9, _, -\n" +
                                                "-Must be at least 3 characters and cannot exceed 15 characters");
        }
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        if(password.matches("^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{6,}$")) {
            //regex hentet fra http://regexlib.com/
            this.password.set(password);
        }else{
            throw new InvalidUserFormatException("Invalid password!\nPassword must contain:\n" +
                                                "-At least one letter\n" +
                                                "-At least one number\n" +
                                                "-Be longer than six characters");
        }
    }
}
