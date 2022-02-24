package com.example.architectureexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//Dao's must be interfaces or abstract classes we just create method and annotate it
//1 Dao per Entity generally
@Dao
public interface NoteDao {
    //annotate with corresponding database operation and Room provides the code.
    @Insert
    void insert(Note note);
    @Update
    void update(Note note);
    @Delete
    void delete(Note note);
    @Query("DELETE FROM note_table")//for all other database operations use @Query
    void deleteAllNotes();
    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();
    //You can receive objects from database in other java forms ie List
}
