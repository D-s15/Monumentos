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


}
