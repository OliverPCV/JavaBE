package cz.educanet.javaeeapi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class UsersManager {

    private int id = 0;

    @Inject
    private LoginManager loginManager;

    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return userList;
    }

    public boolean doesUserExist(int id){
        return userList.stream()
                .filter(userStream -> id == userStream.getId())
                .findAny()
                .orElse(null) != null;
    }


    public boolean createUser(User user) {
        user.setId(userList.size());
        return userList.add(user);
    }

    public UserToken checkUser(User user) {
        Optional<User> tempUser = userList.stream()
                .filter(u -> u.getUsername().equals(user.getUsername()))
                .findFirst();
        if (tempUser.isPresent() && Objects.equals(tempUser.get().getPassword(), user.getPassword()))
            return loginManager.createToken();
        return null;
    }

    public User getUserById(int id) {
        return userList.stream()
                .filter(userListStream -> id == userListStream.getId())
                .findAny()
                .orElse(null);
    }

    public boolean deleteUserById(int id) {
        return userList.remove(id) != null;
    }

    public boolean editUser(int id, User newUser){
        /*if (doesUserExist(id)){
            User currUser = getUserById(id);
            currUser.setUsername(newUser.getUsername());
            return  true;
        } else
            return false;*/
        /*User user = getUserById(id);
        if (user.id == id){
            user.username = newUser.username;
            return true;

        } return false;*/
        for (User user: userList){
            if (user.id == id){
                user.username = newUser.username;
                user.password = newUser.password;
                return true;
            }
        } return false;
    }

}
