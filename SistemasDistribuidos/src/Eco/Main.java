package Eco;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // Criando o Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);
        
        // Criando o servidor
        Servidor server1 = new Servidor(123456789);
        
        // Criando o cliente
        Cliente client1 = new Cliente("Genilson", server1);
        
        // Solicitando mensagem do usuário
        System.out.println("Insira a mensagem a ser ecoada: ");
        System.out.println("> Cliente: " + client1.getName());
        System.out.print(" > ");
        String msg = scanner.nextLine(); // Captura a mensagem digitada
        
        // Envia a mensagem digitada para o servidor
        client1.sendMsg(msg);
        
        // Fechando o scanner
        scanner.close();
    }
}
