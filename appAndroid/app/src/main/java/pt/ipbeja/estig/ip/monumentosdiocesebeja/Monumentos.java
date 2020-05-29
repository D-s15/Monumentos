package pt.ipbeja.estig.ip.monumentosdiocesebeja;

public class Monumentos {

    private long id;
    private String horarioManha;
    private String horarioTarde;
    private int numeroPontosDeInteresse;
    private String DescricaoPontosDeInteresse;
    private String DescricaoMonumento;


    public Monumentos(long id, String horarioManha, String horarioTarde, int numeroPontosDeInteresse, String descricaoPontosDeInteresse, String descricaoMonumento) {
        this.id = id;
        this.horarioManha = horarioManha;
        this.horarioTarde = horarioTarde;
        this.numeroPontosDeInteresse = numeroPontosDeInteresse;
        DescricaoPontosDeInteresse = descricaoPontosDeInteresse;
        DescricaoMonumento = descricaoMonumento;
    }

    public String getDescricaoMonumento() {
        return DescricaoMonumento;
    }

    public void setDescricaoMonumento(String descricaoMonumento) {
        DescricaoMonumento = descricaoMonumento;
    }

    public String getDescricaoPontosDeInteresse() {
        return DescricaoPontosDeInteresse;
    }

    public void setDescricaoPontosDeInteresse(String descricaoPontosDeInteresse) {
        DescricaoPontosDeInteresse = descricaoPontosDeInteresse;
    }

    public int getNumeroPontosDeInteresse() {
        return numeroPontosDeInteresse;
    }

    public void setNumeroPontosDeInteresse(int numeroPontosDeInteresse) {
        this.numeroPontosDeInteresse = numeroPontosDeInteresse;
    }

    public String getHorarioTarde() {
        return horarioTarde;
    }

    public void setHorarioTarde(String horarioTarde) {
        this.horarioTarde = horarioTarde;
    }

    public String getHorarioManha() {
        return horarioManha;
    }

    public void setHorarioManha(String horarioManha) {
        this.horarioManha = horarioManha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
