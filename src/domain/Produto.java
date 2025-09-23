package domain;
// import validation.validarNome;

public class Produto {
    private String nome;
    private int preco;
    private Data data;
    // Construtor completo da classe Produto
    // Adiciona validação de nome usando a classe ValidarNome do pacote src.validation
    public Produto(String nome, int preco, Data data) {
    //  validarNome.validar(nome);
        this.nome = nome;
        this.preco = preco;
        this.data = data;
    }

    // Getters
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public Data getDataValidade() {
        return data;
    }

    // Setters com validação de nome usando a classe ValidarNome do pacote src.validation
    public void setNome(String nome) {
       // validarNome.validar(nome);
        this.nome = nome;
    }
    public void setPreco(int preco) {
        if (preco < 0 || String.valueOf(preco).isEmpty() || Double.isNaN(preco) || Double.isInfinite(preco)) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.preco = preco;
    }
    public void setDataValidade(Data data) {
        this.data = data;
    }
    // Método para verificar se o produto está vencido em relação a uma data atual

    // Representação em String do objeto Produto
    @Override
    public String toString() {
        return "Produto {" +
                "nome = '" + nome + '\'' +
                ", preco = " + preco +
                '}';
    }

    public boolean estaVencido(Data data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}