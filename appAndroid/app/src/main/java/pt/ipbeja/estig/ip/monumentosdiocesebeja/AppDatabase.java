package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Monument.class, InterestPoint.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

        public abstract MonumentDao getMonumentDao();
        public abstract InterestPoint getInterestPointDao();
        public abstract User getUserDao();

        private static AppDatabase INSTANCE;

        public static AppDatabase getInstance(Context context) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,
                        "monumentsDB")
                        .allowMainThreadQueries()
                        .addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);
                                db.execSQL("INSERT INTO Monument VALUES (1, \"monument name\", \"morning schedule\", \"afternoon schedule\",  \"monument description\", \"image url\", \"monument coordinates\")");
                                db.execSQL("INSERT INTO Monument VALUES (2, \"monument name\", \"morning schedule\", \"afternoon schedule\",  \"monument description\", \"image url\", \"monument coordinates\")");
                                db.execSQL("INSERT INTO Monument VALUES (3, \"monument name\", \"morning schedule\", \"afternoon schedule\",  \"monument description\", \"image url\", \"monument coordinates\")");
                                db.execSQL("INSERT INTO Monument VALUES (4, \"monument name\", \"morning schedule\", \"afternoon schedule\",  \"monument description\", \"image url\", \"monument coordinates\")");
                                db.execSQL("INSERT INTO Monument VALUES (5, \"monument name\", \"morning schedule\", \"afternoon schedule\",  \"monument description\", \"image url\", \"monument coordinates\")");
                            }
                        })
                        .build();

            }
            return INSTANCE;
        }
}
