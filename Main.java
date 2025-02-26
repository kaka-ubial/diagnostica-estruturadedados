import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Item> cardapio = new ArrayList<>();
        List<Pedido> historicoPedidos = new ArrayList<>();

        cardapio.add(new Item("Hambúrguer da Ashe", 29.49f));
        cardapio.add(new Item("Hambúrguer do Nasus", 49.99f));
        cardapio.add(new Item("Hambúrguer do Warwcik", 99.50f));

        while(true) {
            System.out.println("1 - Fazer Pedido\n2 - Sair");
            String choice = scan.nextLine();

            if (choice.equals("1")) {
                System.out.println("Qual o seu nome?");
                String nome = scan.nextLine();

                System.out.println("Olá, " + nome + "! Segue abaixo o cardápio");
                List<Item> pedidosItem = new ArrayList<>();

                while (true) {
                    System.out.println("Cardápio:\n");
                    for (Item item : cardapio) {
                        System.out.println(item.getId() + " - " + "Nome: " + item.getNome() + ", Preço: " + item.getPreco());
                    }
                    System.out.println("\n");
                    System.out.println("Digite o número do item para adicioná-lo ao pedido. Para finalizar o pedido digite 0");

                    int itemPedido = scan.nextInt();
                    scan.nextLine();

                    if (itemPedido == 0) {
                        break;
                    } else if (itemPedido > 0 && itemPedido <= cardapio.size()) {
                        pedidosItem.add(cardapio.get(itemPedido - 1));
                        System.out.println(cardapio.get(itemPedido - 1).getNome() + " adicionado ao pedido.");
                    } else {
                        System.out.println("Número inválido, tente novamente.");
                    }
                }
                Pedido pedidoNovo = new Pedido(pedidosItem);
                historicoPedidos.add(pedidoNovo);

                System.out.println("Nota fiscal\n");
                for (Item item : pedidoNovo.getItens()) {
                    System.out.println(item.getNome() + " - " + item.getPreco());
                }
                System.out.println("\nValor da taxa: " + pedidoNovo.getTaxa() * 100 + "%");
                System.out.println("Valor Total: " + pedidoNovo.calcularPreco());

                double value;
                while (true) {
                    System.out.println("\nQual o valor que irá entregar?");
                    value = scan.nextDouble();
                    scan.nextLine();

                    if (value < pedidoNovo.calcularPreco()) {
                        System.out.println("O valor é insuficiente. Por favor, informe um valor maior ou igual a R$ " + pedidoNovo.calcularPreco());
                    } else {
                        break;
                    }
                }

                double troco = value - pedidoNovo.calcularPreco();
                if (troco > 0) {
                    System.out.println("Seu troco é R$ " + String.format("%.2f", troco) + "\n");
                    System.out.println("Obrigada pela compra!\n");
                } else {
                    System.out.println("Obrigada pela compra!\n");
                }
            } else if (choice.equals("2")) {
                System.out.println("Obrigada por utilizar o sistema!");
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
        scan.close();
    }
}
