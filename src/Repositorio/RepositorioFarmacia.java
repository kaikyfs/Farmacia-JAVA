package Repositorio;

import Clientes.Cliente;
import Interface.ControleProduto;
import Produto.Medicamentos;
import Produto.Produto;
import Produto.Cosmetico;
import Repositorio.RepositorioCliente;

import java.util.ArrayList;
import java.util.Scanner;

public class RepositorioFarmacia implements ControleProduto {

    ArrayList<Produto> medicamentos = new ArrayList<>();
    ArrayList<Produto> cosmeticos = new ArrayList<>();
    ArrayList<Produto> produtos = new ArrayList<>();
    ArrayList<Produto> carrinho = new ArrayList<>();

    RepositorioCliente clientes = new RepositorioCliente();

    {


        Medicamentos medicamento1 = new Medicamentos("Amoxilina", 20, "12/09/2025", 14, "Generico");
        medicamentos.add(medicamento1);

        Cosmetico cosmetico1 = new Cosmetico("Cerave", 50, "12/05/2030", 90, "Pfizer");
        cosmeticos.add(cosmetico1);
        produtos.addAll(medicamentos);  // Adiciona medicamentos à lista produtos
        produtos.addAll(cosmeticos);   // Adiciona cosméticos à lista produtos
    }

    public int vendaProduto() {
        int quant=0;
        listarProdutos();
        Scanner scanner = new Scanner(System.in);
        Produto venda;
//        int opcaoVenda = 0;
//        while (opcaoVenda != 1 && opcaoVenda != 2) {
//            System.out.println("1 - Medicamentos \n2 - Cosméticos");
//            opcaoVenda = scanner.nextInt();
//        System.out.println("Qual produto que você deseja vender:");
        System.out.println("Qual produto que você deseja adicionar ao carrinho:");
        int codigo = scanner.nextInt();
        for (int i = 0; i < produtos.size(); i++) {
            if (codigo == i) {
                venda = produtos.get(i);
                System.out.println("Digite a quantidade:");
                quant = scanner.nextInt();
                if (quant >= venda.getEstoque()) {
                    carrinho.add(venda);
                    produtos.remove(i);
                    System.out.println("Toda o estoque de " + venda.getDescricao() + " foi adicionado ao carrinho");
//                    System.out.println("Venda realizada com sucesso! Todos o estoque foi vendido");
                } else {
                    carrinho.add(venda);
                    venda.setEstoque(venda.getEstoque() - quant);
                    System.out.println("-" + quant + " de " + venda.getDescricao() + " foi adicionado ao carrinho");
                }
            }
        }
        return quant;

    }

    public void finalizarPedido(int quant){
        double valor = 0;
        verCarrinho(quant);
        Produto carrinhoVenda;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente: ");
        String entradaCPF = scanner.nextLine();
        ArrayList<Cliente> clientesVenda = clientes.getClientes();
        for (int i = 0; i < clientesVenda.size(); i++) {
            if (entradaCPF.equals(Cliente.getCpf(i))){
                System.out.println("Cliente "+ Cliente.getNome(i) + " está cadastrado(a)!\nO Desconto será aplicado\n");
                for (int j = 0; j < carrinho.size(); j++) {
                    carrinhoVenda = carrinho.get(j);
                    valor += (carrinhoVenda.getPreco()*0.90) * quant;
                }
                System.out.println("Valor total da compra: "+ valor);

            }else{
                System.out.println("O cliente não está cadastrado, sem desconto aplicado");
                for (int j = 0; j < carrinho.size(); j++) {
                    carrinhoVenda = carrinho.get(j);
                    valor += carrinhoVenda.getPreco() * quant;
                }
                System.out.println("Valor total da compra: "+ valor);

            }
            }

        }

    public void atualizarProduto() {
        listarProdutos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual produto que você deseja atualizar:");
        int entrada = scanner.nextInt();
        Produto att;
        for (int i = 0; i < produtos.size(); i++) {
            if (entrada == i) {
                att = produtos.get(i);
                System.out.print("Digite o novo preço:");
                double preco = scanner.nextDouble();
                att.setPreco(preco);
                System.out.print("Digite a quantidade em estoque:");
                int quanEst = scanner.nextInt();
                att.setEstoque(quanEst);
                System.out.println("Produto atualizado com sucesso!\n");
            }
        }

    }

    public void adicionarProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a quantidade no estoque do produto: ");
        int estoque = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite a validade do produto: ");
        String validade = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Digite o nome do fornecedor do produto: ");
        String fornecedor = scanner.nextLine();
        System.out.println("O produto é um medicamento ou cósmetico? (1 para medicamento, 2 cosmetico)");
        int opc = Integer.parseInt(scanner.nextLine());
        if (opc == 1) {
            Medicamentos novoMedicamento = new Medicamentos(nome, estoque, validade, preco, fornecedor);
            medicamentos.add(novoMedicamento);
            produtos.add(novoMedicamento);
            System.out.println("Medicamento cadastrado com sucesso!\n");
        } else {
            Cosmetico novoCosmetico = new Cosmetico(nome, estoque, validade, preco, fornecedor);
            cosmeticos.add(novoCosmetico);
            produtos.add(novoCosmetico);
            System.out.println("Cosmetico cadastrado com sucesso!\n");
        }

    }

    public void listarProdutos() {
        Produto printa;

        for (int i = 0; i < produtos.size(); i++) {
            printa = produtos.get(i);
            System.out.println("- " + i + ". Descrição:" + printa.getDescricao() + "\nPreço:" + printa.getPreco() + "\nFornecedor:" + printa.getFornecedor() + "\nValidade:" + printa.getValidade() + "\nEstoque:" + printa.getEstoque() + "\n");
        }
    }


    public void verCarrinho(int quant) {
        Produto carrinhoMostra;
        for (int i = 0; i < carrinho.size(); i++) {
            carrinhoMostra = carrinho.get(i);
            System.out.println("- " + i + ". Descrição:" + carrinhoMostra.getDescricao() + "\nPreço:" + carrinhoMostra.getPreco() + "\nFornecedor:" + carrinhoMostra.getFornecedor() + "\nValidade:" + carrinhoMostra.getValidade() + "\nQuantidade:" + quant + "\n");
        }
    }

}

