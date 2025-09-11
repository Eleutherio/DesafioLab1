import model.Loja;
import model.Produto;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja("Loja Exemplo", 10, 1500.0);
        System.out.println(loja);

        Produto produto = new Produto("Produto Exemplo", 99.99);
        System.out.println(produto);
    }
}