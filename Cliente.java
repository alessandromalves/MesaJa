// Cliente comum — herda de Pessoa
public class Cliente extends Pessoa {

    private int quantidadePessoas; // quantas pessoas estão na mesa

    public Cliente(String nome, String telefone, int quantidadePessoas) {
        super(nome, telefone);
        this.quantidadePessoas = quantidadePessoas;
    }

    @Override
    public String getTipo() {
        return "Comum";
    }

    public int getQuantidadePessoas() { return quantidadePessoas; }
    public void setQuantidadePessoas(int q) { this.quantidadePessoas = q; }

    @Override
    public String toString() {
        return super.toString() + " | Pessoas: " + quantidadePessoas;
    }
}