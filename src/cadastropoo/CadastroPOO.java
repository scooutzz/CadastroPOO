package cadastropoo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;
import java.util.List;

public class CadastroPOO {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String prefixoArquivos = "";
        boolean executando = true;

        PessoaFisicaRepo repoPessoaFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPessoaJuridica = new PessoaJuridicaRepo();

        while (executando) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Incluir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Exibir pelo ID");
            System.out.println("5. Exibir todos");
            System.out.println("6. Salvar");
            System.out.println("7. Recuperar");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo = scanner.next();

                    switch (tipo) {
                        case "F":
                            System.out.println("Informe o ID:");
                            int id = scanner.nextInt();
                            System.out.println("Informe o nome:");
                            String nome = scanner.next();
                            System.out.println("Informe o CPF:");
                            String cpf = scanner.next();
                            System.out.println("Informe a idade:");
                            int idade = scanner.nextInt();

                            PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                            repoPessoaFisica.inserir(pessoaFisica);
                            System.out.println("Pessoa física incluída com sucesso.");
                            break;
                        case "J":
                            System.out.println("Informe o ID:");
                            int idPj = scanner.nextInt();
                            System.out.println("Informe o nome:");
                            String nomePj = scanner.next();
                            System.out.println("Informe o CNPJ:");
                            String cnpj = scanner.next();

                            PessoaJuridica pessoaJuridica = new PessoaJuridica(idPj, nomePj, cnpj);
                            repoPessoaJuridica.inserir(pessoaJuridica);
                            System.out.println("Pessoa jurídica incluída com sucesso.");
                            break;
                        default:
                            System.out.println("Tipo inválido.");
                    }
                    break;
                case 2:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo2 = scanner.next();

                    switch (tipo2) {
                        case "F":
                            System.out.println("Informe o ID da pessoa física a ser alterada:");
                            int id = scanner.nextInt();

                            PessoaFisica pessoaFisica = repoPessoaFisica.obter(id);
                            if (pessoaFisica != null) {
                                System.out.println("Dados atuais da pessoa física:");
                                pessoaFisica.exibir();

                                System.out.println("Informe o novo nome:");
                                String nome = scanner.next();
                                System.out.println("Informe o novo CPF:");
                                String cpf = scanner.next();
                                System.out.println("Informe a nova idade:");
                                int idade = scanner.nextInt();

                                pessoaFisica.setNome(nome);
                                pessoaFisica.setCpf(cpf);
                                pessoaFisica.setIdade(idade);

                                repoPessoaFisica.alterar(pessoaFisica);
                                System.out.println("Pessoa física alterada com sucesso.");
                            } else {
                                System.out.println("Pessoa física não encontrada.");
                            }
                            break;
                        case "J":
                            System.out.println("Informe o ID da pessoa jurídica a ser alterada:");
                            int idPf = scanner.nextInt();

                            PessoaJuridica pessoaJuridica = repoPessoaJuridica.obter(idPf);
                            if (pessoaJuridica != null) {
                                System.out.println("Dados atuais da pessoa jurídica:");
                                pessoaJuridica.exibir();

                                System.out.println("Informe o novo nome:");
                                String nome = scanner.next();
                                System.out.println("Informe o novo CNPJ:");
                                String cnpj = scanner.next();

                                pessoaJuridica.setNome(nome);
                                pessoaJuridica.setCnpj(cnpj);

                                repoPessoaJuridica.alterar(pessoaJuridica);
                                System.out.println("Pessoa jurídica alterada com sucesso.");
                            } else {
                                System.out.println("Pessoa jurídica não encontrada.");
                            }
                            break;
                        default:
                            System.out.println("Tipo inválido.");
                    }
                    break;
                case 3:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo3 = scanner.next();

                    switch (tipo3) {
                        case "F":
                            System.out.println("Informe o ID da pessoa física a ser excluída:");
                            int id = scanner.nextInt();

                            if (repoPessoaFisica.obter(id) != null) {
                                repoPessoaFisica.excluir(id);
                                System.out.println("Pessoa física excluída com sucesso.");
                            } else {
                                System.out.println("Pessoa física não encontrada.");
                            }
                            break;
                        case "J":
                            System.out.println("Informe o ID da pessoa jurídica a ser excluída:");
                            int idPj = scanner.nextInt();

                            if (repoPessoaJuridica.obter(idPj) != null) {
                                repoPessoaJuridica.excluir(idPj);
                                System.out.println("Pessoa jurídica excluída com sucesso.");
                            } else {
                                System.out.println("Pessoa jurídica não encontrada.");
                            }
                            break;
                        default:
                            System.out.println("Tipo inválido.");
                    }
                    break;
                case 4:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo4 = scanner.next();

                    switch (tipo4) {
                        case "F":
                            System.out.println("Informe o ID da pessoa física a ser exibida:");
                            int id = scanner.nextInt();

                            PessoaFisica pessoaFisica = repoPessoaFisica.obter(id);
                            if (pessoaFisica != null) {
                                System.out.println("Dados da pessoa física:");
                                pessoaFisica.exibir();
                            } else {
                                System.out.println("Pessoa física não encontrada.");
                            }
                            break;
                        case "J":
                            System.out.println("Informe o ID da pessoa jurídica a ser exibida:");
                            int idPj = scanner.nextInt();

                            PessoaJuridica pessoaJuridica = repoPessoaJuridica.obter(idPj);
                            if (pessoaJuridica != null) {
                                System.out.println("Dados da pessoa jurídica:");
                                pessoaJuridica.exibir();
                            } else {
                                System.out.println("Pessoa jurídica não encontrada.");
                            }
                            break;
                        default:
                            System.out.println("Tipo inválido.");
                    }
                    break;
                case 5:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo5 = scanner.next();

                    switch (tipo5) {
                        case "F":
                            System.out.println("Pessoas Físicas:");
                            List<PessoaFisica> pessoasFisicas = repoPessoaFisica.obterTodos();
                            for (PessoaFisica pessoaFisica : pessoasFisicas) {
                                pessoaFisica.exibir();
                            }
                            break;
                        case "J":
                            System.out.println("Pessoas Jurídicas:");
                            List<PessoaJuridica> pessoasJuridicas = repoPessoaJuridica.obterTodos();
                            for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
                                pessoaJuridica.exibir();
                            }
                            break;
                        default:
                            System.out.println("Tipo inválido.");
                    }
                    break;
                case 6:
                    System.out.println("Informe o prefixo dos arquivos:");
                    String prefixo = scanner.next();

                    // Salvar Pessoa Física.
                    repoPessoaFisica.persistir(prefixo);

                    // Salvar Pessoa Jurídica.
                    repoPessoaJuridica.persistir(prefixo);

                    System.out.println("Dados salvos com sucesso.");
                case 7:
                    System.out.println("Informe o prefixo dos arquivos:");
                    String prefixoRecuperar = scanner.next();

                    // Recuperar PF
                    repoPessoaFisica.recuperar(prefixoRecuperar);

                    // Recuperar PJ
                    repoPessoaJuridica.recuperar(prefixoRecuperar);

                    System.out.println("Dados recuperados com sucesso.");
                    break;
                case 0:
                    // Finalizar a execução
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Programa encerrado.");
    }
}
