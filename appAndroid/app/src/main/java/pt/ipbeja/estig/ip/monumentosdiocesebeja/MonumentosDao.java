package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MonumentosDao {

    @Query("SELECT * FROM Monumentos")
    List<Monumentos> getAll();

    @Insert
    void insertAll(Monumentos monumentos);

    @Delete
    void delete(Monumentos monumentos);
    
}
