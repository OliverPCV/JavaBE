package cz.educanet.javaeeapi;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class UsersManager {
    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getUser(){ return userList; }

    public boolean create(User user) {
        user.setId(userList.size());
        user.id++;
        return userList.add(user);
    }
    public boolean doesUserExist(String username){
        for (User user : userList){
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public void saveUser(User user){
        userList.add(user);
    }


    public User getUsername (int id){
        return userList.stream()
                .filter(userListStream -> id == userListStream.getId())
                .findAny()
                .orElse(null);
    }

    public boolean deleteUser(int id){
        return  userList.remove(getUsername(id));
    }

    public boolean control(int id) {
        for (int i = 0; i < 100; i++){
            if (id != userList.get(id).id) {
                return false;
            }
        }
        return true;
    }
}
