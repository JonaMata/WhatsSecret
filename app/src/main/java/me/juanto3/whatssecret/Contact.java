package me.juanto3.whatssecret;

/**
 * Created by jonat on 24/02/2018.
 */

public class Contact {
    int _id;
    String _name;
    String _hash;
    int _last;

    public Contact() {

    }

    public Contact(int id, String name, String hash, int last) {
        this._id = id;
        this._name = name;
        this._hash = hash;
        this._last = last;
    }

    public Contact(String name, String hash, int last) {
        this._name = name;
        this._hash = hash;
        this._last = last;
    }

    public int getID(){
        return this._id;
    }

    public void setID(int id) {
        this._id = id;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getHash() {
        return this._hash;
    }

    public void setHash(String hash) {
        this._hash = hash;
    }

    public int getLast() { return this._last;}

    public void setLast(int last) {this._last = last;}

}
