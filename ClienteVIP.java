// Cliente VIP — herda de Cliente e tem prioridade na fila
public class ClienteVIP extends Cliente {

    private String codigoVIP;

    public ClienteVIP(String nome, String telefone, int quantidadePessoas, String codigoVIP) {
        super(nome, telefone, quantidadePessoas);
        this.codigoVIP = codigoVIP;
    }

    @Override
    public String getTipo() {
        return "VIP";
    }

    public String getCodigoVIP() { return codigoVIP; }

    @Override
    public String toString() {
        return super.toString() + " | Codigo VIP: " + codigoVIP;
    }
}