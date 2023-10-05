package Clientes;

public class Cliente {
    public static String nome;
    public static String cpf;

    public Cliente(String nome, String cpf){
        Cliente.nome = nome;
        Cliente.cpf = cpf;
    }

    public static String getNome(int i) {
        return nome;
    }

    public void setNome(String nome) {
        Cliente.nome = nome;
    }

    public static String getCpf(int i) {
        return cpf;
    }

    public void setCpf(String cpf) {
        Cliente.cpf = cpf;
    }
}
