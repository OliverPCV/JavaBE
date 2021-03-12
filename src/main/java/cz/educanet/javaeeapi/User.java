package cz.educanet.javaeeapi;


import javax.persistence.Entity;

@Entity
public class User {

    public String username, password;
    public int id;

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getId() { return id; }

    public String setUser(String username) { return this.username = username; }
    public String setHeslo(String password){ return this.username = password;}
    public int setId(int id) { return this.id = id; }

    public void setUsername(String jmeno) {
        this.username = username;
    }
}
