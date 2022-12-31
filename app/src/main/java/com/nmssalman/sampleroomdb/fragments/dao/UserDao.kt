package com.nmssalman.sampleroomdb.fragments.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nmssalman.sampleroomdb.fragments.dataclasses.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * from user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Update
    suspend fun updateUser(user: User)

}