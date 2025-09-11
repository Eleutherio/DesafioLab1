package domain;

public class Endereco {
    private final String nomeDaRua;
    private final String cidade;
    private final String estado;
    private final String pais;
    private final String cep;
    private final String numero;
    private final String complemento;

    public Endereco(String nomeDaRua, String cidade, String estado, String pais, String cep, String numero, String complemento) {
        this.nomeDaRua = nomeDaRua;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;  
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "nomeDaRua='" + nomeDaRua + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", cep='" + cep + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}