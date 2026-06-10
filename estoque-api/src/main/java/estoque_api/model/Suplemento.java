package estoque_api.model;

public class Suplemento extends Produto {

    private String marca;

    public Suplemento() {
    }

    public Suplemento(
            int id,
            String nome,
            double preco,
            int quantidade,
            String marca) {

        super(id, nome, preco, quantidade);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}