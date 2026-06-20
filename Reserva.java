// Representa uma reserva feita por um cliente
public class Reserva {

    private Cliente cliente;
    private String horario;
    private int numeroMesa;
    private boolean confirmada;

    public Reserva(Cliente cliente, String horario, int numeroMesa) {
        this.cliente = cliente;
        this.horario = horario;
        this.numeroMesa = numeroMesa;
        this.confirmada = false; // começa como não confirmada
    }

    public void confirmar() {
        this.confirmada = true;
    }

    public void cancelar() {
        this.confirmada = false;
    }

    public Cliente getCliente() { return cliente; }
    public String getHorario() { return horario; }
    public int getNumeroMesa() { return numeroMesa; }
    public boolean isConfirmada() { return confirmada; }

    @Override
    public String toString() {
        String status = confirmada ? "Confirmada" : "Pendente";
        return "Reserva | Mesa: " + numeroMesa + " | Horario: " + horario
             + " | Status: " + status + " | " + cliente;
    }
}