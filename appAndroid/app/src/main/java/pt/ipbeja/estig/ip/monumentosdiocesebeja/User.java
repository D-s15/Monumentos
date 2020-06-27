package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = "email", unique = true)})
public class User{

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String email;
    private String password;

    public User(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
