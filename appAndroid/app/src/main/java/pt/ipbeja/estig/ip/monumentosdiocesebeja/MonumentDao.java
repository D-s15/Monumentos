package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MonumentDao {

    @Query("SELECT * FROM Monument")
    List<Monument> getAll();

    @Query("SELECT * FROM Monument WHERE id = :monumentId")
    Monument getById(long monumentId);

    @Insert
    void insertAll(Monument monument);

    @Delete
    void delete(Monument monument);
    
}
