package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class InterestPoint {

    @PrimaryKey
    private long id;
    @SerializedName("name")
    private String interestPointName;
    @SerializedName("description")
    private String interestPointDescription;
    private long monumentId;
    @SerializedName("image")
    private String interestPointImage;
    private boolean seen;

    public InterestPoint(long id, String interestPointName, String interestPointDescription, long monumentId, String interestPointImage, boolean seen) {
        this.id = id;
        this.interestPointName = interestPointName;
        this.interestPointDescription = interestPointDescription;
        this.monumentId = monumentId;
        this.interestPointImage = interestPointImage;
        this.seen = seen;
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

    public String getInterestPointDescription() {
        return interestPointDescription;
    }

    public void setInterestPointDescription(String interestPointDescription) {
        this.interestPointDescription = interestPointDescription;
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

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
}
