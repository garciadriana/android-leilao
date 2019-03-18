package br.com.adriana.garcia.leilao.repository;

import android.arch.persistence.room.*;
import br.com.adriana.garcia.leilao.model.User;

@Dao
public interface UserRepository {
    @Insert
    void insert(User lance);

    @Update
    void update(User lance);

    @Delete
    void delete(User lance);

    @Query("Select * from user where email = :email and password = :password")
    User login(String email, String password);

    @Query("Select * from user where id = :userId")
    User findById(Long userId);
}
