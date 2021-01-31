package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MonumentDao {

    @Query("SELECT * FROM Monument WHERE monumentName LIKE '%'|| :name || '%'")
    List<Monument> getSearchResults(String name);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void updateSearchList(List<Monument> updateMonumentsList);
}
