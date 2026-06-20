// Classe abstrata base — representa qualquer pessoa no sistema
public abstract class Pessoa {

    private String nome;
    private String telefone;

    public Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // Método abstrato: cada tipo de pessoa tem uma apresentação diferente
    public abstract String getTipo();

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }

    public void setNome(String nome) { this.nome = nome; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    @Override
    public String toString() {
        return "[" + getTipo() + "] " + nome + " | Tel: " + telefone;
    }
}