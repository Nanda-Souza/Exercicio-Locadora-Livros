public class Pessoa {
    /*
    Atributos da classe
    Uso de Integer por ser objeto como boa pratica pois permite null
    int é primitivo e é melhor ser usado sempre quando ouver valor
    */
    Integer id;
    String nome;
    String cpf;
    String email;
    String endereco;

    public Pessoa(Integer id, String nome, String cpf, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    //Override é usado para alterar o comportamento da classe Object da biblioteca do java
    //Sem isso ele devolve o objeto como uma hash
    @Override
    //Metodo para imprimir o objeto na tela
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | CPF: " + cpf +
                " | Email: " + email +
                " | Endereço: " + endereco;
    }

}