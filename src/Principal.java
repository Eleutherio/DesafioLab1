import domain.Data;
import domain.Loja;
import domain.Produto;
import domain.Endereco;
// import validation.validarNome;

public class Principal {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        java.util.List<Loja> lojas = new java.util.ArrayList<>();

        boolean rodando = true;
        while (rodando) {
            System.out.println("Menu:");
            System.out.println("1. Criar uma Loja");
            System.out.println("2. Criar um Produto");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            // >>> Essencial: ler como String e fazer parse <<<
            String entrada = scanner.nextLine().trim();
            int opcao;
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.\n");
                continue;
            }

            switch (opcao) {
                case 1: {
                    System.out.println("Você escolheu criar uma Loja.");

                    System.out.print("Digite o nome da loja: ");
                    String nomeLoja = scanner.nextLine();

                    System.out.print("Digite a quantidade de funcionários: ");
                    int quantidadeFuncionarios = Integer.parseInt(scanner.nextLine()); // evita buffer

                    System.out.print("Digite o salário base dos funcionários: ");
                    double salarioBaseFuncionario = Double.parseDouble(scanner.nextLine()); // evita buffer

                    // === Endereço (ordem: nomeDaRua, cidade, estado, pais, cep, numero, complemento) ===
                    System.out.print("Nome da rua: ");
                    String nomeDaRua = scanner.nextLine();

                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();

                    System.out.print("Estado (UF): ");
                    String estado = scanner.nextLine();

                    System.out.print("País: ");
                    String pais = scanner.nextLine();

                    System.out.print("CEP: ");
                    String cep = scanner.nextLine();

                    System.out.print("Número: ");
                    String numero = scanner.nextLine();

                    System.out.print("Complemento (pode deixar vazio): ");
                    String complemento = scanner.nextLine();

                    // === Data de fundação (dia, mes, ano) ===
                    System.out.print("Digite o dia da fundação: ");
                    int dia = Integer.parseInt(scanner.nextLine());

                    System.out.print("Digite o mês da fundação: ");
                    int mes = Integer.parseInt(scanner.nextLine());

                    System.out.print("Digite o ano da fundação: ");
                    int ano = Integer.parseInt(scanner.nextLine());

                    // Cria objetos (validações ficam nos próprios construtores)
                    Endereco endereco = new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);
                    Data dataFundacao = new Data(dia, mes, ano);

                    Loja loja = new Loja(
                        nomeLoja,
                        quantidadeFuncionarios,
                        salarioBaseFuncionario,
                        endereco,
                        dataFundacao
                    );
                    lojas.add(loja);

                    System.out.println("Loja criada com sucesso!\n");
                    break;
                }

                case 2:
                    System.out.println("Você escolheu criar um Produto.");
                    // (mantido como estava; implemente aqui quando quiser)
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Saindo...");
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }
        }

        scanner.close();
    }
}