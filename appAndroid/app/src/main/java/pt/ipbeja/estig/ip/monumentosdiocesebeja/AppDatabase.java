package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Monumentos.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

        public abstract MonumentosDao monumentosDao();

        private static AppDatabase INSTANCE;

        public static  AppDatabase getInstance(Context context) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,
                        "monumentsDB")
                        .allowMainThreadQueries()
                        .addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);
                                db.execSQL("INSERT INTO Monumentos VALUES (0, \"horario manha\", \"horario tarde\", 10, \"descricao pontos interesse\", \"decricao monumento\", \"image url\")");
                                db.execSQL("INSERT INTO Monumentos VALUES (0, \"horario manha\", \"horario tarde\", 10, \"descricao pontos interesse\", \"decricao monumento\", \"image url\")");
                                db.execSQL("INSERT INTO Monumentos VALUES (0, \"horario manha\", \"horario tarde\", 10, \"descricao pontos interesse\", \"decricao monumento\", \"image url\")");
                                db.execSQL("INSERT INTO Monumentos VALUES (0, \"horario manha\", \"horario tarde\", 10, \"descricao pontos interesse\", \"decricao monumento\", \"image url\")");
                                db.execSQL("INSERT INTO Monumentos VALUES (0, \"horario manha\", \"horario tarde\", 10, \"descricao pontos interesse\", \"decricao monumento\", \"image url\")");

                            }
                        })
                        .build();

            }
            return INSTANCE;
        }
}
