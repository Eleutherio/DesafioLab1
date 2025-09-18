package domain;
// import validation.validarNome;

public class Produto {
    private String nome;
    private double preco;

    // Construtor completo da classe Produto
    // Adiciona validação de nome usando a classe ValidarNome do pacote src.validation
    public Produto(String nome, double preco) {
    //  validarNome.validar(nome);
        this.nome = nome;
        this.preco = preco;
    }

    // Getters
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }

    // Setters com validação de nome usando a classe ValidarNome do pacote src.validation
    public void setNome(String nome) {
       // validarNome.validar(nome);
        this.nome = nome;
    }
    public void setPreco(double preco) {
        if (preco < 0 || Double.isNaN(preco) || Double.isInfinite(preco)) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.preco = preco;
    }

    // Representação em String do objeto Produto
    @Override
    public String toString() {
        return "Produto {" +
                "nome = '" + nome + '\'' +
                ", preco = " + preco +
                '}';
    }
}