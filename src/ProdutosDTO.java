
public class ProdutosDTO {

    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private String status; // Adicionado para representar o status do produto

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Métodos adicionais para compatibilidade (getValor e setValor)
    public double getValor() {
        return preco; // Retorna o preço
    }

    public void setValor(double valor) {
        this.preco = valor; // Define o preço
    }
}
