package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tour {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String tourBeginning;
    private String tourFinnish;
    private int numberOfMonuments;
    private long userId;
    private String tourImage;


    public Tour(long id, String tourBeginning, String tourFinnish, int numberOfMonuments, long userId, String tourImage){
        this.id = id;
        this.tourBeginning = tourBeginning;
        this.tourFinnish = tourFinnish;
        this.numberOfMonuments = numberOfMonuments;
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

    public int getNumberOfMonuments() {
        return numberOfMonuments;
    }

    public void setNumberOfMonuments(int numberOfMonuments) {
        this.numberOfMonuments = numberOfMonuments;
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
