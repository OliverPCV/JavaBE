package cz.educanet.javaeeapi;

public class User {
    public String username, password;
    public int id;

    public User(){

    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getId() { return id; }

    public String setUsername(String username) { return this.username = username; }
    public String setPassword(String password){ return this.password = password;}
    public int setId(int id) { return this.id = id; }
}

