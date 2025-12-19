import java.time.LocalDate;

public class Emprestimo {

    Integer id;
    Pessoa pessoa;
    Livro livro;
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;

    public Emprestimo(Integer id, Pessoa pessoa, Livro livro) {
        this.id = id;
        this.pessoa = pessoa;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        //Adicionando 7 dias como padrão pra devolver os livros
        this.dataDevolucao = dataEmprestimo.plusDays(7);
    }

    @Override
    public String toString() {
        return "Id: " + id +
                " | Pessoa: " + pessoa.nome +
                " | Livro: " + livro.titulo +
                " | Data de Empréstimo: " + dataEmprestimo +
                " | Data de Devolução: " + dataDevolucao;
    }
}