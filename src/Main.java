import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        //Classe Scanner usada para ler input do usuario
        Scanner scanner = new Scanner(System.in);
        //Lista de Pessoas
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        //Lista de Livros
        ArrayList<Livro> livros = new ArrayList<>();
        //Lista de Emprestimos
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();


        //Variaveis de controle
        int opcao;
        int idPessoa = 1;
        int idLivro = 1;
        int idEmprestimo = 1;

        do {

            System.out.println("\n==== Locadora de Livros ====");
            System.out.println("1 - Cadastrar Pessoa");
            System.out.println("2 - Listar Pessoas");
            System.out.println("3 - Cadastrar Livro");
            System.out.println("4 - Listar Livros");
            System.out.println("5 - Alugar Livro");
            System.out.println("6 - Devolver Livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            /*
            Valida Se a entrada é inteira, se for atribui na opção, se não for descarta e coloca -1
            Para cair na opção invalida do switch case
            */
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                /*
                Preciso usar isso pois o nextInt deixa um \n sobrando,
                sem o nextLine ele deixa a proxima entrada com espaço em branco
                */
                scanner.nextLine();
            } else {
                scanner.next();
                opcao = -1;
            }

            //Valida a entrada do usuario na opção em cada caso, o break serve para parar a execução quando achar a opção
            switch (opcao) {
                case 1:
                    System.out.print("Insira o Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Insira o CPF: ");
                    String cpf = scanner.nextLine();


                    System.out.print("Insira o Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Insira o Endereço: ");
                    String endereco = scanner.nextLine();

                    //Cria o objeto Pessoa com o valor do idPessoa e incrementa a variavel
                    Pessoa pessoa = new Pessoa(
                            idPessoa++,
                            nome,
                            cpf,
                            email,
                            endereco
                    );

                    pessoas.add(pessoa);
                    System.out.println("Pessoa cadastrada com sucesso!");
                    break;

                case 2:
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    } else {
                        System.out.println("\nLista de Pessoas:");
                        //Percorre a lista e imprime cada objeto pessoa
                        for (Pessoa p : pessoas) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Insira o Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Insira o Autor: ");
                    String autor = scanner.nextLine();

                    //Cria o objeto Livro com o valor do idLivro e incrementa a variavel
                    Livro livro = new Livro(
                            idLivro++,
                            titulo,
                            autor
                    );

                    livros.add(livro);
                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 4:
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                        break;
                    } else {
                        System.out.println("\nLista de Livros:");
                        //Percorre a lista e imprime cada objeto livro
                        for (Livro l : livros) {
                            System.out.println(l);
                        }
                    }
                    break;

                case 5:
                    if (livros.isEmpty() || pessoas.isEmpty()) {
                        System.out.println("Só é possivel alugar livros com pessoas e livros cadastrados.");
                        break;
                    } else {
                        System.out.print("ID da Pessoa: ");
                        int idPessoaBusca = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("ID do Livro: ");
                        int idLivroBusca = scanner.nextInt();
                        scanner.nextLine();

                        //Cria dois objetos nulos para guardar a pessoa e o livro encontrado
                        Pessoa pessoaEncontrada = null;
                        Livro livroEncontrado = null;

                        // Busca pessoa
                        for (Pessoa p : pessoas) {
                            if (p.id == idPessoaBusca) {
                                pessoaEncontrada = p;
                                break;
                            }
                        }

                        // Busca livro
                        for (Livro l : livros) {
                            if (l.id == idLivroBusca) {
                                livroEncontrado = l;
                                break;
                            }
                        }

                        if (pessoaEncontrada == null || livroEncontrado == null) {
                            System.out.println("Pessoa ou livro não encontrado.");
                            break;
                        }

                        if (!livroEncontrado.disponivel) {
                            System.out.println("Livro indisponível. Verifique a lista de livros disponíveis.");
                            break;
                        }

                        // Cria empréstimo
                        Emprestimo emprestimo = new Emprestimo(
                                idEmprestimo++,
                                pessoaEncontrada,
                                livroEncontrado

                        );
                        emprestimos.add(emprestimo);

                        // Marca livro como indisponível
                        livroEncontrado.disponivel = false;

                        System.out.println("Livro alugado com sucesso!");
                        System.out.println(emprestimo);
                    }
                    break;

                case 6:
                    if (livros.isEmpty() || pessoas.isEmpty()) {
                        System.out.println("Só é possivel devolver livros com pessoas e livros cadastrados.");
                        break;
                    } else {
                        if (emprestimos.isEmpty()) {
                            System.out.println("Nenhum empréstimo registrado.");
                            break;
                        }

                        System.out.print("Lista de Livros Alugados:");
                        //Percorre a de emprestimos e imprime cada objeto
                        for (Emprestimo e : emprestimos) {
                            System.out.println(e);
                        }

                        System.out.print("Selecione o ID do Empréstimo: ");
                        int idEmprestimoBusca = scanner.nextInt();
                        scanner.nextLine();

                        Emprestimo emprestimoEncontrado = null;

                        for (Emprestimo e : emprestimos) {
                            if (e.id == idEmprestimoBusca) {
                                emprestimoEncontrado = e;
                                break;
                            }
                        }

                        if (emprestimoEncontrado == null) {
                            System.out.println("Empréstimo não encontrado.");
                            break;
                        }

                        // Marca o livro como disponível novamente
                        emprestimoEncontrado.livro.disponivel = true;

                        // Remove o empréstimo da lista
                        emprestimos.remove(emprestimoEncontrado);

                        System.out.println("Livro devolvido com sucesso!");

                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida!");
            }



        } while (opcao != 0);




    }
}