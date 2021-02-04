package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Monument {

    @PrimaryKey
    private long id;
    @SerializedName("name")
    private String monumentName;
    @SerializedName("schedule_am")
    private String morningSchedule;
    @SerializedName("schedule_pm")
    private String afternoonSchedule;
    @SerializedName("description")
    private String monumentDescription;
    private String closing;
    @SerializedName("image")
    private String monumentImage;

    public Monument(long id, String monumentName, String morningSchedule, String afternoonSchedule, String monumentDescription, String closing, String monumentImage) {
        this.id = id;
        this.monumentName = monumentName;
        this.morningSchedule = morningSchedule;
        this.afternoonSchedule = afternoonSchedule;
        this.monumentDescription = monumentDescription;
        this.closing = closing;
        this.monumentImage = monumentImage;
    }

    public String getClosing() {
        return closing;
    }

    public void setClosing(String closing) {
        this.closing = closing;
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
