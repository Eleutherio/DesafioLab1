import domain.Data;
import domain.Loja;
import domain.Produto;
// import validation.validarNome;




public class Principal {
    public static void main(String[] args) {
        Loja loja = new Loja("Central Pink", 2, 4000.0);

        Produto produto = new Produto("Café Expresso", 23.90);

        System.out.println(produto.getPreco());

        Data data = new Data(29, 2, 2020);
        System.out.println(data);
    }

}