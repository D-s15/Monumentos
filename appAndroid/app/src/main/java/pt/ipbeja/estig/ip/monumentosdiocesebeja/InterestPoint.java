package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class InterestPoint {

    @PrimaryKey(autoGenerate = true) private long id;
    private String name;
    private String description;
    private long monumentId;
    private String interestPointImage;

    public InterestPoint(long id, String name, String description, long monumentId, String interestPointImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monumentId = monumentId;
        this.interestPointImage = interestPointImage;
    }

    public String getInterestPointImage() {
        return interestPointImage;
    }

    public void setInterestPointImage(String interestPointImage) {
        this.interestPointImage = interestPointImage;
    }

    public long getMonumentId() {
        return monumentId;
    }

    public void setMonumentId(long monumentId) {
        this.monumentId = monumentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
