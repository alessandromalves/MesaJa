// Exceção própria — lançada quando o cliente já está na fila
public class ClienteJaExisteException extends Exception {

    public ClienteJaExisteException(String nome) {
        super("O cliente " + nome + " ja esta na fila de espera.");
    }
}