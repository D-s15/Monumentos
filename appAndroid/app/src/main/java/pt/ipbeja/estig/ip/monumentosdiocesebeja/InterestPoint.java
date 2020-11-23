package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class InterestPoint {

    @PrimaryKey
    private long id;
    private String interestPointName;
    private String interestPointDesctiption;
    private long monumentId;
    private String interestPointImage;
    private boolean favorite;

    public InterestPoint(long id, String interestPointName, String interestPointDesctiption, long monumentId, String interestPointImage, boolean favorite) {
        this.id = id;
        this.interestPointName = interestPointName;
        this.interestPointDesctiption = interestPointDesctiption;
        this.monumentId = monumentId;
        this.interestPointImage = interestPointImage;
        this.favorite = favorite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInterestPointName() {
        return interestPointName;
    }

    public void setInterestPointName(String interestPointName) {
        this.interestPointName = interestPointName;
    }

    public String getInterestPointDesctiption() {
        return interestPointDesctiption;
    }

    public void setInterestPointDesctiption(String interestPointDesctiption) {
        this.interestPointDesctiption = interestPointDesctiption;
    }

    public long getMonumentId() {
        return monumentId;
    }

    public void setMonumentId(long monumentId) {
        this.monumentId = monumentId;
    }

    public String getInterestPointImage() {
        return interestPointImage;
    }

    public void setInterestPointImage(String interestPointImage) {
        this.interestPointImage = interestPointImage;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
