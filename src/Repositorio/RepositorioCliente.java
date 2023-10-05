package Repositorio;

import Clientes.Cliente;
import Interface.InterfaceCliente;

import java.util.ArrayList;
import java.util.Scanner;

public class RepositorioCliente implements InterfaceCliente {

    public static ArrayList<Cliente> clientes = new ArrayList<>();

    static {
        Cliente cliente1 = new Cliente("Kaiky", "15038891497");
        clientes.add(cliente1);
    }

    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o cpf do cliente:");
        String cpf = scanner.nextLine();
        Cliente novoCliente = new Cliente(nomeCliente, cpf);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!\n");
    }

    public void listarClientes() {
        Cliente mostra;
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("Nome:" + Cliente.getNome(i) + "\nCPF:" + Cliente.getCpf(i) + "\n");
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
