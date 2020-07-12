package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MonumentReferenceDao {

@Query("SELECT * FROM MonumentReference")
    List<MonumentReference> getAll();

@Query("SELECT * FROM Monument INNER JOIN MonumentReference ON Monument.id=MonumentReference.MonumentId WHERE MonumentReference.MonumentId=:monumentId")
    List<Monument> getMonumentById(long monumentId);

@Query("SELECT * FROM InterestPoint INNER JOIN MonumentReference ON InterestPoint.id=MonumentReference.interestPointId WHERE MonumentReference.MonumentId=:interestPointId")
    List<InterestPoint> getInterestPointById(long interestPointId);

}
