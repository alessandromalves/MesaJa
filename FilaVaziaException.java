// Exceção própria — lançada quando tenta chamar alguém de uma fila vazia
public class FilaVaziaException extends Exception {

    public FilaVaziaException() {
        super("A fila de espera esta vazia.");
    }

    public FilaVaziaException(String mensagem) {
        super(mensagem);
    }
}