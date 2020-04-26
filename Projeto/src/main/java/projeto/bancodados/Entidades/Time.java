package projeto.bancodados.Entidades;

public class Time {
    private String idTime;
    private String nome;
    private int anoFund;
    private String cidade;
    private String estado;



    public Time(String idTime, String nome, int anoFund, String cidade, String estado){
        this.idTime = idTime;
        this.nome = nome;
        this.anoFund = anoFund;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Time() {

    }

    public String getIdTime() {
        return idTime;
    }

    public void setIdTime(String idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoFund() {
        return anoFund;
    }

    public void setAnoFund(int anoFund) {
        this.anoFund = anoFund;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String toString(){
        return idTime + "[nome: "+nome+" , anoFund: "+anoFund+", cidade: "+cidade+", estado: "+estado + " ]";
    }
}