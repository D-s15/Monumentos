package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

@Query("SELECT * FROM User")
    List<User> getAll();

@Query("SELECT * FROM User WHERE email = :email AND password = :password")
    User getAccount(String email, String password);

@Insert
    void insert (User user);
}
