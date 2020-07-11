package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(primaryKeys = {"monumentId", "interestPointId"},
foreignKeys = {
        @ForeignKey(entity = Monument.class, parentColumns = "id", childColumns = "monumentId"),
        @ForeignKey(entity = InterestPoint.class, parentColumns = "id", childColumns = "interestPointId")})
public class MonumentReference {
    private long monumentId;
    private long interestPointId;


    public MonumentReference(long monumentId, long interestPointId) {
        this.monumentId = monumentId;
        this.interestPointId = interestPointId;
    }

    public long getMonumentId() {
        return monumentId;
    }

    public void setMonumentId(long monumentId) {
        this.monumentId = monumentId;
    }

    public long getInterestPointId() {
        return interestPointId;
    }

    public void setInterestPointId(long interestPointId) {
        this.interestPointId = interestPointId;
    }
}
