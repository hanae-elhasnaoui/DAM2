package com.example.ejercicio23

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface SongDao {

    @Query("SELECT * FROM t_songs ORDER BY title ASC")
    fun getAllSongs(): List<Song>

    @Insert
    fun insertSong(song: Song)

    @Update
    fun updateSong(song: Song)

    @Delete
    fun deleteSong(song: Song)

}