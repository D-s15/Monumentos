package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TourDao {

@Query("SELECT * FROM Tour")
    List<Tour> getAll();

@Query("SELECT * FROM Tour WHERE id = :id")
Tour getById(long id);

@Query("SELECT monumentName FROM Monument WHERE id = :id")
    String getMonumentNameById (long id);

@Query("SELECT monumentImage FROM Monument WHERE id = :id")
    String getMonumentImageById(long id);

@Query("SELECT * FROM Monument WHERE id = :id")
    Monument getMonumentById(long id);
}
