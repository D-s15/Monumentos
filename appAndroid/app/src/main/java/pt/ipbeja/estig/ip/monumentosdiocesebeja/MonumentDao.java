package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MonumentDao {

    @Query("SELECT * FROM Monument")
    List<Monument> getAll();

    @Query("SELECT * FROM Monument WHERE id = :monumentId")
    Monument getById(long monumentId);

  //  @Query("SELECT monumentImage FROM Monument WHERE id IN(SELECT * FROM Tour WHERE )LIMIT 1")

    @Insert
    void insertAll(Monument monument);

    @Delete
    void delete(Monument monument);

    @Query("SELECT * FROM Monument WHERE monumentName LIKE '%' ||:monumentName||'%'")
    List<Monument> searchMonuments(String monumentName);

    @Update void update(Monument monument);
}
