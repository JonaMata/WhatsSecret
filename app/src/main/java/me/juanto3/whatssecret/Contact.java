package me.juanto3.whatssecret;

import android.arch.persistence.room.*;

/**
 * Created by jonat on 24/02/2018.
 */
@Entity
public class Contact {

    @PrimaryKey(autoGenerate = true)
    public int id;
    private String name;
    private String hash;
    private int last;

    public Contact(int id, String name, String hash, int last) {
        this.id = id;
        this.name = name;
        this.hash = hash;
        this.last = last;
    }

    @Ignore
    public Contact(String name, String hash, int last) {
        this.name = name;
        this.hash = hash;
        this.last = last;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getLast() { return this.last;}

    public void setLast(int last) {this.last = last;}

}
