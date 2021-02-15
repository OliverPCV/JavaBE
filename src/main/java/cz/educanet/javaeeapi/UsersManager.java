package cz.educanet.javaeeapi;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class UsersManager {
    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> dostanJmenos(){ return userList; }

    public boolean create(User user) {
        user.setId(userList.size());
        user.id++;
        return userList.add(user);
    }

    public User dostanJmenos (int id){
        return userList.stream()
                .filter(userListStream -> id == userListStream.getID())
                .findAny()
                .orElse(null);
    }

    public boolean odstranJmenos(int id){
        return  userList.remove(dostanJmenos(id));
    }
    public boolean kontrolac(int id) {
        for (int i = 0; i < 100; i++){
            if (id != userList.get(id).id) {
                return false;
            }
        }
        return true;
    }
}
