package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Monument {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String monumentName;
    private String morningSchedule;
    private String afternoonSchedule;
    private String monumentDescription;
    private String monumentImage;
    private String monumentCoordinates;

    public Monument(long id, String monumentName, String morningSchedule, String afternoonSchedule, String monumentDescription, String monumentImage, String monumentCoordinates) {
        this.id = id;
        this.monumentName = monumentName;
        this.morningSchedule = morningSchedule;
        this.afternoonSchedule = afternoonSchedule;
        this.monumentDescription = monumentDescription;
        this.monumentImage = monumentImage;
        this.monumentCoordinates = monumentCoordinates;
    }

    public String getMonumentCoordinates() {
        return monumentCoordinates;
    }

    public void setMonumentCoordinates(String monumentCoordinates) {
        this.monumentCoordinates = monumentCoordinates;
    }

    public String getMonumentImage() {
        return monumentImage;
    }

    public void setMonumentImage(String monumentImage) {
        this.monumentImage = monumentImage;
    }

    public String getMonumentDescription() {
        return monumentDescription;
    }

    public void setMonumentDescription(String monumentDescription) {
        this.monumentDescription = monumentDescription;
    }

    public String getMonumentName() {
        return monumentName;
    }

    public void setMonumentName(String monumentName) {
        this.monumentName = monumentName;
    }

    public String getMorningSchedule() {
        return morningSchedule;
    }

    public void setMorningSchedule(String morningSchedule) {
        this.morningSchedule = morningSchedule;
    }

    public String getAfternoonSchedule() {
        return afternoonSchedule;
    }

    public void setAfternoonSchedule(String afternoonSchedule) {
        this.afternoonSchedule = afternoonSchedule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
