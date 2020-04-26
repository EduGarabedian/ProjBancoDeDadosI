package projeto.bancodados.Entidades;

public class Aplicativo {
    private String id;
    private String nome;
    private String desenvolvedor;
    private int numeroDownloads;

    public Aplicativo(){};

    public Aplicativo(String id, String nome, String desenvolvedor, int numeroDownloads){
        this.id=id;
        this.nome=nome;
        this.desenvolvedor=desenvolvedor;
        this.numeroDownloads=numeroDownloads;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public int getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public void setNumeroDownloads(int numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString(){
        return id + " [nome: " + nome + ", Desenvolvedor: " + desenvolvedor + ", Número de Downloads: " + numeroDownloads + "]";
    }
}
