package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Monumentos {

    @PrimaryKey(autoGenerate = true) private long id;
    private String monumentName;
    private String morningSchedule;
    private String afternoonSchedule;
    private int interestPointsNumber;
    private String interestPointsDescription;
    private String monumentDescription;
    private String monumentImage;
    private String monumentCoordinates;


    public Monumentos(long id, String monumentName, String morningSchedule, String afternoonSchedule, int interestPointsNumber, String interestPointsDescription, String monumentDescription, String monumentImage, String monumentCoordinates) {
        this.id = id;
        this.monumentName = monumentName;
        this.morningSchedule = morningSchedule;
        this.afternoonSchedule = afternoonSchedule;
        this.interestPointsNumber = interestPointsNumber;
        this.interestPointsDescription = interestPointsDescription;
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

    public String getInterestPointsDescription() {
        return interestPointsDescription;
    }

    public void setInterestPointsDescription(String interestPointsDescription) {
        this.interestPointsDescription = interestPointsDescription;
    }

    public int getInterestPointsNumber() {
        return interestPointsNumber;
    }

    public void setInterestPointsNumber(int interestPointsNumber) {
        this.interestPointsNumber = interestPointsNumber;
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
}
