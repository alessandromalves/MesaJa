import java.util.ArrayList;

// Classe principal que gerencia fila e reservas
public class Restaurante {

    private String nome;
    private int totalMesas;
    private Fila filaEspera;
    private ArrayList<Reserva> reservas;

    public Restaurante(String nome, int totalMesas) {
        this.nome = nome;
        this.totalMesas = totalMesas;
        this.filaEspera = new Fila();
        this.reservas = new ArrayList<>();
    }

    // Adiciona cliente na fila — trata exceção de cliente duplicado
    public void adicionarNaFila(Cliente cliente) {
        try {
            filaEspera.entrar(cliente);
        } catch (ClienteJaExisteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // Chama o próximo da fila — trata exceção de fila vazia
    public void chamarProximo() {
        try {
            Cliente proximo = filaEspera.chamarProximo();
            System.out.println("\nChamando: " + proximo);
        } catch (FilaVaziaException e) {
            System.out.println("Aviso: " + e.getMessage());
        }
    }

    // Faz uma reserva para um cliente
    public void fazerReserva(Cliente cliente, String horario, int numeroMesa) {
        // Controle de fluxo: verifica se a mesa existe
        if (numeroMesa < 1 || numeroMesa > totalMesas) {
            System.out.println("Mesa invalida. O restaurante tem " + totalMesas + " mesas.");
            return;
        }
        Reserva reserva = new Reserva(cliente, horario, numeroMesa);
        reservas.add(reserva);
        System.out.println("Reserva criada: " + reserva);
    }

    // Confirma uma reserva pelo nome do cliente
    public void confirmarReserva(String nomeCliente) {
        for (Reserva r : reservas) {
            if (r.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
                r.confirmar();
                System.out.println("Reserva confirmada para " + nomeCliente);
                return;
            }
        }
        System.out.println("Reserva nao encontrada para " + nomeCliente);
    }

    public void removerDaFila(String nome) {
        if (filaEspera.remover(nome)) {
            System.out.println("Cliente '" + nome + "' removido da fila.");
        } else {
            System.out.println("Cliente '" + nome + "' nao encontrado na fila.");
        }
    }

    public void listarFila() {
        filaEspera.listar();
    }

    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }
        System.out.println("\n--- Reservas ---");
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }

    public String getNome() { return nome; }
    public int getTotalMesas() { return totalMesas; }
}