package me.juanto3.whatssecret;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by jonat on 24/02/2018.
 */

@Dao
public interface ContactDao {
    @Query("SELECT * FROM contact")
    LiveData<List<Contact>> getAll();

    @Query("SELECT * FROM contact WHERE id LIKE :id LIMIT 1")
    Contact findById(int id);

    @Insert
    void insertAll(Contact... contacts);

    @Delete
    void delete(Contact contact);
}
