import java.util.Scanner;

// Classe principal com menu interativo
public class Main {

    public static void main(String[] args) {

        Restaurante restaurante = new Restaurante("Restaurante UFRPE", 10);
        Scanner sc = new Scanner(System.in);

        // Alguns dados iniciais para demonstração
        restaurante.adicionarNaFila(new Cliente("Ana", "81999990001", 2));
        restaurante.adicionarNaFila(new Cliente("Bruno", "81999990002", 4));
        restaurante.adicionarNaFila(new ClienteVIP("Carlos", "81999990003", 3, "VIP001"));
        restaurante.adicionarNaFila(new Cliente("Diana", "81999990004", 1));
        restaurante.adicionarNaFila(new ClienteVIP("Eva", "81999990005", 5, "VIP002"));

        restaurante.fazerReserva(new Cliente("Ana", "81999990001", 2), "19:00", 3);
        restaurante.fazerReserva(new Cliente("Carlos", "81999990003", 3), "20:00", 5);

        int opcao;
        do {
            System.out.println("\n====== " + restaurante.getNome() + " ======");
            System.out.println("1 - Ver fila de espera");
            System.out.println("2 - Adicionar cliente comum na fila");
            System.out.println("3 - Adicionar cliente VIP na fila");
            System.out.println("4 - Chamar proximo da fila");
            System.out.println("5 - Fazer reserva");
            System.out.println("6 - Confirmar reserva");
            System.out.println("7 - Listar reservas");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    restaurante.listarFila();
                    break;

                case 2:
                    System.out.print("Nome: ");    String nome = sc.nextLine();
                    System.out.print("Telefone: "); String tel = sc.nextLine();
                    System.out.print("Qtd pessoas: "); int qtd = Integer.parseInt(sc.nextLine());
                    restaurante.adicionarNaFila(new Cliente(nome, tel, qtd));
                    break;

                case 3:
                    System.out.print("Nome: ");       String nomeV = sc.nextLine();
                    System.out.print("Telefone: ");   String telV = sc.nextLine();
                    System.out.print("Qtd pessoas: "); int qtdV = Integer.parseInt(sc.nextLine());
                    System.out.print("Codigo VIP: "); String cod = sc.nextLine();
                    restaurante.adicionarNaFila(new ClienteVIP(nomeV, telV, qtdV, cod));
                    break;

                case 4:
                    restaurante.chamarProximo();
                    break;

                case 5:
                    System.out.print("Nome: ");    String nomeR = sc.nextLine();
                    System.out.print("Telefone: "); String telR = sc.nextLine();
                    System.out.print("Qtd pessoas: "); int qtdR = Integer.parseInt(sc.nextLine());
                    System.out.print("Horario (ex: 19:00): "); String hor = sc.nextLine();
                    System.out.print("Numero da mesa: "); int mesa = Integer.parseInt(sc.nextLine());
                    restaurante.fazerReserva(new Cliente(nomeR, telR, qtdR), hor, mesa);
                    break;

                case 6:
                    System.out.print("Nome do cliente: "); String nomeC = sc.nextLine();
                    restaurante.confirmarReserva(nomeC);
                    break;

                case 7:
                    restaurante.listarReservas();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}