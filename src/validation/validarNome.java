package src.validation;

public class validaX {
    public static String validaNome(String nome) {
        if (nome == null || nome.trim().isEmpty() || !nome.matches("[a-zA-Z]+") || nome.length() < 3) {
            throw new IllegalArgumentException("Digite um nome válido.");
        }
        return nome;
    }
}
