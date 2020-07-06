package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MonumentReferenceDao {

@Query("SELECT * FROM MonumentReference")
    List<MonumentReference> getAll();

@Query("SELECT * FROM MonumentReference WHERE monumentId = :monumentId")
    List<MonumentReference> getMonumentById(long monumentId);



}
