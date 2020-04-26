package projeto.bancodados.Entidades;

public class Carro {
    private String id;
    private String modelo;
    private String marca;
    private String ano;
    private String categoria;

    public Carro(){}

    public Carro(String id, String modelo, String marca, String ano, String categoria)
    {
        this.setId(id);
        this.setModelo(modelo);
        this.setMarca(marca);
        this.setAno(ano);
        this.setCategoria(categoria);
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public String getAno() { return ano; }

    public void setAno(String ano) { this.ano = ano; }

    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) { this.categoria = categoria; }

    @Override
    public String toString(){
        return id + " [Modelo: " + modelo + ", Marca: " + marca + ", Ano: " + ano + " Categoria: " + categoria + "]";
    }
}
