package domain;
import validation.ValidarNome;


public class Endereco {
    private String nomeDaRua;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private String numero;
    private String complemento;

    // Construtor completo
    public Endereco(String nomeDaRua, String cidade, String estado, String pais, String cep, String numero, String complemento) {
        
        this.nomeDaRua = nomeDaRua;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;  
    }
    // Getters
    public String getNomeDaRua() {
        return nomeDaRua;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public String getPais() {
        return pais;
    }
    public String getCep() {
        return cep;
    }
    public String getNumero() {
        return numero;
    }
    public String getComplemento() {
        return complemento;
    }

    //Setters
    public void setNomeDaRua(String nomeDaRua) {
        ValidarNome.validar(nomeDaRua);
        this.nomeDaRua = nomeDaRua;
    } 
    public void setCidade(String cidade) {
        ValidarNome.validar(cidade);
        this.cidade = cidade;
    }
    public void setEstado(String estado) {
       if (estado == null || estado.trim().isEmpty() || !estado.matches("AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO")) {
            throw new IllegalArgumentException("Estado inválido. Não pode ser nulo ou vazio, deve ser no padrão RS, SC, SP, etc...");
        }
        this.estado = estado;
    }
    public void setPais(String pais) {
        if (pais == null || pais.trim().isEmpty() || !pais.matches("[\\p{L} ]+") || pais.length() > 30) {
            throw new IllegalArgumentException("País inválido. Não pode ser nulo ou vazio, deve conter apenas letras e espaços, e ter menos de 30 caracteres.");
        }
        this.pais = pais;
    }
    public void setCep(String cep) {
        if (cep == null || cep.trim().isEmpty() || !cep.matches("\\d{5}-\\d{3}")) {
            throw new IllegalArgumentException("O CEP deve estar no formato 00000-000.");
        }
        this.cep = cep;
    }
    public void setNumero(String numero) {
        if (numero == null || numero.trim().isEmpty() || !numero.matches("\\d+") || numero.length() > 10) {
            throw new IllegalArgumentException("O número deve ser um valor numérico e ter no máximo 10 dígitos.");
        }
        this.numero = numero;
    }
    public void setComplemento(String complemento) {
        ValidarNome.validar(complemento);
        this.complemento = complemento;
    }

    

    // Override do método toString para exibir as informações do endereço de forma legível.
    @Override
    public String toString() {
        return "Endereco {" +
                "nome da Rua = '" + nomeDaRua + '\'' +
                ", cidade = '" + cidade + '\'' +
                ", estado = '" + estado + '\'' +
                ", pais = '" + pais + '\'' +
                ", cep = '" + cep + '\'' +
                ", numero = '" + numero + '\'' +
                ", complemento = '" + complemento + '\'' +
                '}';
    }
}