package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Monument.class, InterestPoint.class, User.class, Tour.class}, version = 6)
public abstract class AppDatabase extends RoomDatabase {

        public abstract MonumentDao getMonumentDao();

        public abstract InterestPointDao getInterestPointDao();

        public abstract UserDao getUserDao();

        public abstract TourDao getVisitaDao();

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
                                db.execSQL("INSERT INTO Monument VALUES (1, 'Castelo de Beja', '9h30-12h30', '14-18h',  'O Castelo de Beja data da época da Romanização: foi onde Júlio César formalizou a paz com os Lusitanos (49). O primitivo “oppidum” deu lugar a uma “civitas” (“Pax Julia”), que veio a sediar uma das três jurisdições romanas da Lusitânia.', 'https://www.mundoportugues.pt/wp-content/uploads/sites/3/2017/10/article_65142.jpg'," +
                                        " 'https://maps.google.pt/?q=38.01733064,-7.86539555')");
                                db.execSQL("INSERT INTO Monument VALUES (2, 'Museu Rainha D. Leonor', '9h30-12h30, encerra segunda', '14h - 17h15, encerra segunda', 'O Convento foi fundado em 1459 pelo Infante D. Fernando, irmão de Afonso V de Portugal, e sua esposa, a Infanta D. Beatriz. O convento, primitivamente era bastante amplo mas, séculos mais tarde, sofreu a demolição de uma parte." +
                                        "Este museu conheceu três fases distintas enquanto instituição museológica: Museu Sisenando-Cenáculo-Pacense (1791-1802), Museu Archeologico Municipal de Beja, entre os anos de (1892-1927) e Museu Rainha Dona Leonor ou Museu Regional de Beja (1927 - atualidade)', " +
                                        "'https://lh5.googleusercontent.com/p/AF1QipMPu3XXs0oUfzRUA8F6G85r-HRj40PsErvvxEN8=w408-h306-k-no', 'https://maps.google.pt/?q=38.0139254,-7.8629346')");
                                db.execSQL("INSERT INTO Monument VALUES (3, 'Núcleo Museológico da Rua de Sembrano', '9h30-12h30', '14h-18h', '','https://lh5.googleusercontent.com/p/AF1QipN6dwKWQFloQypTjuqQBRiJzdScjXP2juMEG7c4=w296-h202-n-k-no', 'https://maps.google.pt/?q=38.0134307,-7.8639028')");

                                db.execSQL("INSERT INTO InterestPoint VALUES(1,'casa do governador','Trata-se atualmente do Museu Jorge Vieira. Foi objeto de uma primeira intervenção em 1992 face ao seu estado de ruína. A obra, da autoria da arquitecta Maria João George," +
                                        " recebeu o Prémio Municipal de Arquitetura Espiga de Ouro de 1993. Em 1995, a Câmara Municipal de Beja adquiriu-o, com o objetivo de albergar a coleção de obras que o artista ofereceu ao município. É constituído por um edifício com dois pisos:" +
                                        " no primeiro é apresentada a colecção de desenho e escultura doada pelo escultor; o piso inferior destina-se a exposições temporárias, performances, instalações, conferências e debates, workshops, ateliers de artes plásticas, etc.', 1," +
                                        " 'https://www.diarioimobiliario.pt/var/diarioimobiliario/storage/images/_aliases/articleItem/actualidade/reabilitacao/beja-reabre-a-casa-do-governador-no-castelo-da-cidade/beja-casa-governador_no-castelo-da-cidade-02/36063-1-por-PT/BEJA-Casa-Governador_no-castelo-da-cidade-02.jpg')");
                                db.execSQL("INSERT INTO InterestPoint VALUES(2,'Torre de Menagem','Trata-se de uma fortaleza gótica, cuja construção teve início no século XIII, logo após a conquista cristã da cidade, prolongando-se pelos séculos XIV e, possivelmente, XV.\n" +
                                        "Destacando-se do conjunto da fortaleza, ergue-se a imponente Torre de Menagem, com quase quarenta metros de altura, considerada por alguns especialistas como uma obra-prima da arquitectura militar gótica europeia.', 1, 'https://upload.wikimedia.org/wikipedia/commons/6/62/Torre_castelo_beja.jpg')");
                                db.execSQL("INSERT INTO InterestPoint VALUES(3, 'Arco Romano de Beja','Possivelmente edificado entre os séculos III e IV d. C, o arco Romano, também conhecido como porta de Évora, definia os limites de Pax Julia e integrava outras estruturas inerentes" +
                                        "O Arco encontra-se entre uma das torres que ladeiam a muralha do castelo de Beja e um dos troços da amurada que envolvia esta mesma localidade. Ao que tudo indica, a sua principal funcionalidade consistia em dar acesso à barbacã que rodeia a torre de menagem, localizada a Oeste deste mesmo recinto." +
                                        "Atualmente, o Arco encontra-se integrado no castelo medieval, ou seja, no exterior da alcáçova. Com efeito, este elemento sofreu algumas alterações ao longo dos séculos, das quais destacamos a edificação de uma segunda porta mais ampla nos finais do século XVI, o que implicou a total demolição do Arco romano. Contudo, esta mesma segunda porta foi também destruída em 1893, ao entender-se que a sua presença naquele local dificultaria o normal fluxo do trânsito. Em 1938, decidiu-se reconstruir o Arco com os vestígios que ainda subsistiam.\n',1,'https://www.allaboutportugal.pt/imagethumb/1700x/resize/770748')");

                                db.execSQL("INSERT INTO Tour VALUES(1, '10h30', '14h30 (com pausa para almoço)', 4, 1, 'https://www.mundoportugues.pt/wp-content/uploads/sites/3/2017/10/article_65142.jpg')");

                            }
                        })
                        .build();
            }
            return INSTANCE;
        }
}
