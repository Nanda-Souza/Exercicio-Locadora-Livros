public class Livro {
    Integer id;
    String titulo;
    String autor;
    Boolean disponivel;

    public Livro(Integer id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        disponivel = true;
    }


    @Override
    public String toString() {
        return "ID: " + id +
                " | Título: " + titulo +
                " | Autor: " + autor +
                " | Disponivel: " + disponivel;
    }

}