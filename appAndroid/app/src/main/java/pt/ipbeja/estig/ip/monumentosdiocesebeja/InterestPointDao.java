package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface InterestPointDao {

    @Query("SELECT * FROM InterestPointVisited WHERE id = :id")
    InterestPointVisited getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void update(InterestPointVisited InterestPointVisited);
}
