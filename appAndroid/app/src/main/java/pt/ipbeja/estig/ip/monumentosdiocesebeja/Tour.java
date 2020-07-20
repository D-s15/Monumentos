package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tour {

    @PrimaryKey
    private long id;
    private String tourBeginning;
    private String tourFinnish;
    private String monumentName;
    private long userId;
    private String tourImage;


    public Tour(long id, String tourBeginning, String tourFinnish, String monumentName, long userId, String tourImage){
        this.id = id;
        this.tourBeginning = tourBeginning;
        this.tourFinnish = tourFinnish;
        this.monumentName = monumentName;
        this.userId = userId;
        this.tourImage = tourImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTourBeginning() {
        return tourBeginning;
    }

    public void setTourBeginning(String tourBeginning) {
        this.tourBeginning = tourBeginning;
    }

    public String getTourFinnish() {
        return tourFinnish;
    }

    public void setTourFinnish(String tourFinnish) {
        this.tourFinnish = tourFinnish;
    }

    public String getNumberOfMonuments() {
        return monumentName;
    }

    public void setNumberOfMonuments(String monumentName) {
        this.monumentName = monumentName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTourImage() {
        return tourImage;
    }

    public void setTourImage(String tourImage) {
        this.tourImage = tourImage;
    }

}
