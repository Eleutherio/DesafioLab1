package domain;
//import validation.validarNome;

public class Loja {
        private String nome;
        private int quantidadeFuncionarios;
        private double salarioBaseFuncionario;

        // Construtor completo
        public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario) {
            //validarNome.validar(nome);
            this.nome = nome;
            this.quantidadeFuncionarios = quantidadeFuncionarios;
            this.salarioBaseFuncionario = salarioBaseFuncionario;
        }
        // Sobrecarga de construtor, passando apenas nome e quantidade de funcionários e definindo um valor padrão para o salário (se não fornecido no construtor completo)
        public Loja(String nome, int quantidadeFuncionarios) {
            this.nome = nome;
            this.quantidadeFuncionarios = quantidadeFuncionarios;
            this.salarioBaseFuncionario = -1; // Valor padrão se o salário não for fornecido
        }

        // Getters
        public String getNome() {
            return nome;
        }
        public int getQuantidadeFuncionarios() {
            return quantidadeFuncionarios;
        }
        public double getSalarioBaseFuncionario() {
            return salarioBaseFuncionario;
        }
        // Setters

        // ****** Método - pode ser - substituído pela classe ValidarNome no pacote src.validation para evitar duplicidade com a classe Produto ******
         public void setNome(String nome) {
            if (nome == null || nome.trim().isEmpty() || !nome.matches("[\\p{L}0-9 ]+")) {
                throw new IllegalArgumentException("Digite um nome válido (apenas letras e/ou números).");
            }
            this.nome = nome;
        }

        // Ajusta a quantidade de funcionários e garante que não seja atribuído valor negativo pelo usuário, mantendo a regra do valor negativo somente como valor padrão da classe construtora.
        public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
            if (quantidadeFuncionarios < 0) {
                throw new IllegalArgumentException("A quantidade de funcionários não pode ser negativa.");
            }
            this.quantidadeFuncionarios = quantidadeFuncionarios;
        }
        // Ajusta o salário base dos funcionários e garante que não seja atribuído valor um negativo pelo usuário, mantendo a regra do valor negativo somente como valor padrão da classe construtora.
        public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
            if (salarioBaseFuncionario < 0) {
                throw new IllegalArgumentException("O salário base não pode ser negativo.");
            }
            this.salarioBaseFuncionario = salarioBaseFuncionario;
        }
        
        // Método para calcular e exibir os gastos totais com salários dos funcionários. Se o salário base não foi definido (valor negativo), informa que não é possível calcular.
        public double gastosComSalario() {
            if (salarioBaseFuncionario <= 0) {
                System.out.println("Salário base não definido. Não é possível calcular os gastos com salários.");
                return 0;
            } else {
                double totalGastos = quantidadeFuncionarios * salarioBaseFuncionario;
                System.out.printf("Gastos totais com salários: R$ %.2f%n", totalGastos);
                return totalGastos;
            }
        }
        public char tamanhoDaLoja() {
            if (quantidadeFuncionarios < 10) {
                System.out.println("P");
                return 'P'; 
            } else if (quantidadeFuncionarios <= 30) {
                System.out.println("M");
                return 'M';
            } else {
                System.out.println("G");
                return 'G';
            }
        }   

    // Representação em String do objeto Loja para facilitar a visualização dos atributos.
    @Override
    public String toString() {
        return "Loja{" +
                "nome da loja = '" + nome + '\'' +
                ", quantidade de funcionários = " + quantidadeFuncionarios +
                ", salário base do funcionário = " + salarioBaseFuncionario +
                '}';
    }
}