package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {InterestPointVisited.class, Monument.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {

        public abstract InterestPointDao getInterestPointDao();

        public abstract MonumentDao getMonumentDao();
        private static AppDatabase INSTANCE;

        public static AppDatabase getInstance(Context context) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "monumentsDB").build();

            if (INSTANCE == null) {
            }
            return INSTANCE;
        }
}
