import Interface.ControleProduto;
import Interface.InterfaceCliente;
import Repositorio.RepositorioFarmacia;
import Repositorio.RepositorioCliente;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ControleProduto repositorioFarmacia = new RepositorioFarmacia();
        InterfaceCliente repositorioCliente = new RepositorioCliente();
        Scanner scanner = new Scanner(System.in);
        int quant = 0;

        int opcao;
        do {
            System.out.println("1.Vender Produto\n2.Finalizar pedido\n3.Ver carrinho\n4.Adicionar Produto\n5.Listar Produtos\n6.Atualizar Produtos\n7.Cadastrar cliente\n8.Listar Clientes\n0.Sair\nDigite sua opção:");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> quant = repositorioFarmacia.vendaProduto();
                case 2 -> repositorioFarmacia.finalizarPedido(quant);
                case 3 -> repositorioFarmacia.verCarrinho(quant);
                case 4 -> repositorioFarmacia.adicionarProduto();
                case 5 -> repositorioFarmacia.listarProdutos();
                case 6 -> repositorioFarmacia.atualizarProduto();
                case 7 -> repositorioCliente.cadastrarCliente();
                case 8 -> repositorioCliente.listarClientes();
                case 0 -> System.out.println("Obrigado por usar nosso sistema!");
                default ->
                        System.out.println("Opção inválida. Por favor, escolha uma opção de 1 a 4 (Ou 0 para sair).");
            }
            }
            while (opcao != 0);
                scanner.close();
        }
    }




