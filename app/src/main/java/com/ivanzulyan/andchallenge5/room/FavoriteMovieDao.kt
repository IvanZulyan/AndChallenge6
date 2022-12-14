package com.ivanzulyan.andchallenge5.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ivanzulyan.andchallenge5.model.FavoriteEntity


@Dao
interface FavoriteMovieDao {
    @Query("SELECT * FROM FavoriteEntity ORDER BY id DESC")
    fun getDataFavorite() : LiveData<List<FavoriteEntity>>

    @Insert
    fun insertFavorite(movie: FavoriteEntity)

    @Delete
    fun deleteFavorite(movie: FavoriteEntity)

    @Query("SELECT * FROM FavoriteEntity WHERE id = :id")
    fun checkMovie(id: Int) : Int
}