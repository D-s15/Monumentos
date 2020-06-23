package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;
@Dao
public interface InterestPointDao {

    @Query("SELECT * FROM InterestPoint")
    List<InterestPoint> getAll();

    @Query("SELECT * FROM InterestPoint WHERE id = :interestPointId")
            InterestPoint getById(long interestPointId);

    @Query("SELECT * FROM InterestPoint WHERE monumentId = :monumentId")
    List<InterestPoint> getInterestPointsByMonumentId(long monumentId);
}
