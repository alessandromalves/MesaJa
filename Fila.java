import java.util.ArrayList;

// Interface que define o contrato de qualquer fila do sistema
interface Filavel {
    void entrar(Cliente cliente) throws ClienteJaExisteException;
    Cliente chamarProximo() throws FilaVaziaException;
    void listar();
    int tamanho();
}

// Implementação da fila de espera usando ArrayList
public class Fila implements Filavel {

    // ArrayList que guarda os clientes em espera
    private ArrayList<Cliente> fila;

    public Fila() {
        this.fila = new ArrayList<>();
    }

    @Override
    public void entrar(Cliente cliente) throws ClienteJaExisteException {
        // Verifica se o cliente já está na fila pelo nome
        for (Cliente c : fila) {
            if (c.getNome().equalsIgnoreCase(cliente.getNome())) {
                throw new ClienteJaExisteException(cliente.getNome());
            }
        }

        // VIP entra na frente dos clientes comuns
        if (cliente instanceof ClienteVIP) {
            // Encontra a posição depois do último VIP já na fila
            int posicao = 0;
            for (int i = 0; i < fila.size(); i++) {
                if (fila.get(i) instanceof ClienteVIP) {
                    posicao = i + 1;
                }
            }
            fila.add(posicao, cliente);
            System.out.println("Cliente VIP adicionado na posicao " + (posicao + 1) + " da fila.");
        } else {
            fila.add(cliente);
            System.out.println("Cliente adicionado no final da fila. Posicao: " + fila.size());
        }
    }

    @Override
    public Cliente chamarProximo() throws FilaVaziaException {
        if (fila.isEmpty()) {
            throw new FilaVaziaException();
        }
        // Remove e retorna o primeiro da fila
        return fila.remove(0);
    }

    @Override
    public void listar() {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }
        System.out.println("\n--- Fila de Espera ---");
        for (int i = 0; i < fila.size(); i++) {
            System.out.println((i + 1) + ". " + fila.get(i));
        }
    }

    @Override
    public int tamanho() {
        return fila.size();
    }
}