package cz.educanet.javaeeapi;


import javax.persistence.Entity;

@Entity
public class User {

    public String jmeno, heslo;
    public int id;

    public String getJmeno() { return jmeno; }
    public String getHeslo() { return heslo; }
    public int getID() { return id; }

    public String setUser(String jmeno) { return this.jmeno = jmeno; }
    public String setHeslo(String heslo){ return this.heslo = heslo;}
    public int setId(int id) { return this.id = id; }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getId() {
        return id;
    }
}
