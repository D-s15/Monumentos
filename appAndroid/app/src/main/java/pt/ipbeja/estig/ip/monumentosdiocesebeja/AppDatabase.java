package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Monument.class, InterestPoint.class, User.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {

        public abstract MonumentDao getMonumentDao();

        public abstract InterestPointDao getInterestPointDao();

        public abstract  UserDao getUserDao();
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
                                db.execSQL("INSERT INTO Monument VALUES (1, 'Castelo de Beja', '10-13h', '15-18h',  'this is a description', 'https://www.mundoportugues.pt/wp-content/uploads/sites/3/2017/10/article_65142.jpg', 'https://maps.google.pt/?q=38.01733064,-7.86539555')");
                                db.execSQL("INSERT INTO Monument VALUES (2, 'Ermida de Santo André', '10-13h, exceto Domingo e Segunda', 'não abre à tarde',  'this is a description', 'https://upload.wikimedia.org/wikipedia/commons/a/a2/Ermida_de_Santo_Andr%C3%A9.jpg', 'https://maps.google.pt/?q=38.0199807,-7.8702413')");

                                db.execSQL("INSERT INTO InterestPoint VALUES(1,'casa do governador','O edifício localizado no interior do recinto do castelo, denominado de Casa do Governador, resulta de diferentes intervenções realizadas no decorrer de vários séculos. Julga-se que a sua construção primitiva teve origem no séc. XV, por ordem de D. João II" +
                                        " foi mandado construir um Paço para receber o Infante D. Afonso na sua lua de mel conforme diz o cronista Rui de Pina. Desta primitiva fase ainda é possível observar os arcos góticos. A partir de 1640, após a restauração da independência, o local foi ocupado pelo exército como cavalariça e caserna, dada a sua nova função " +
                                        "sofreu profundas obras de ampliação perdendo o seu cariz de habitação nobre. A terceira fase de intervenção foi na década de 30 do século XX por iniciativa da DGEMN integrado no contexto de obras de recuperação, conservação e valorização do Castelo de Beja. O Edifício atual resulta desta última intervenção, na qual foram integradas " +
                                        "os diferentes balcões provenientes dos edifícios demolidos em Beja. O balcão de recanto, geminado, em mármore e granito, veio da velha Casa dos Corvos, situada ao lado da Igreja de Santa Maria e que, segundo a tradição, fora paço dos bispos visigodos e, depois dos governadores muçulmanos de Beja. Atualmente a Casa do Governador é ocupada no " +
                                        "piso térreo pelo principal Posto de Turismo da Cidade, cafetaria e WC, o segundo andar trata-se de um grande espaço museal preparado para receber exposições temporárias.', 1, 'https://www.diarioimobiliario.pt/var/diarioimobiliario/storage/images/_aliases/articleItem/actualidade/reabilitacao/beja-reabre-a-casa-do-governador-no-castelo-da-cidade/beja-casa-governador_no-castelo-da-cidade-02/36063-1-por-PT/BEJA-Casa-Governador_no-castelo-da-cidade-02.jpg')");
                                db.execSQL("INSERT INTO InterestPoint VALUES(2,'Torre de Menagem','Trata-se de uma fortaleza gótica, cuja construção teve início no século XIII, logo após a conquista cristã da cidade, prolongando-se pelos séculos XIV e, possivelmente, XV.\n" +
                                        "Destacando-se do conjunto da fortaleza, ergue-se a imponente Torre de Menagem, com quase quarenta metros de altura, considerada por alguns especialistas como uma obra-prima da arquitectura militar gótica europeia.', 1, 'https://upload.wikimedia.org/wikipedia/commons/6/62/Torre_castelo_beja.jpg')");

                            }
                        })
                        .build();
            }
            return INSTANCE;
        }
}
