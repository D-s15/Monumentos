package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface InterestPointDao {

    @Query("SELECT * FROM InterestPoint")
    List<Monument> getAll();

    @Insert
    void insertAll(InterestPoint interestPoint);

    @Delete
    void delete(InterestPoint interestPoint);
}
