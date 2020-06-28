package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface VisitaDao {

@Query("SELECT * FROM Visita")
    List<Visita> getAll();

@Query("SELECT * FROM Visita WHERE id = :id")
    Visita getById(long id);


}
