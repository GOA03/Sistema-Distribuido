package socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket socketEcho = null;
        PrintWriter saida = null;
        BufferedReader entrada = null;
        BufferedReader entradaUsuario = null;

        try {
            // Solicita o IP e a porta do usuário
            System.out.print("Digite o IP do servidor: ");
            String enderecoServidor = scanner.nextLine();

            // Solicita a porta do servidor
            System.out.print("Digite a porta do servidor: ");
            int porta = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha após o nextInt()

            System.out.println("Tentando conectar ao servidor " + enderecoServidor + " na porta " + porta + ".");

            // Conecta ao servidor com o IP e a porta fornecidos pelo usuário
            socketEcho = new Socket(enderecoServidor, porta);
            saida = new PrintWriter(socketEcho.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(socketEcho.getInputStream()));
            entradaUsuario = new BufferedReader(new InputStreamReader(System.in));

            String mensagemUsuario;
            System.out.print("Digite a mensagem: ");
            while ((mensagemUsuario = entradaUsuario.readLine()) != null) {
                saida.println(mensagemUsuario);
                System.out.println("Eco do servidor: " + entrada.readLine());
                if (mensagemUsuario.equalsIgnoreCase("Bye")) {
                    break; // Encerra o loop se o usuário digitar "Bye"
                }
                System.out.print("Digite a mensagem: ");
            }

        } catch (UnknownHostException e) {
            System.err.println("Servidor desconhecido: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro de E/S: " + e.getMessage());
        } finally {
            try {
                if (saida != null) saida.close();
                if (entrada != null) entrada.close();
                if (entradaUsuario != null) entradaUsuario.close();
                if (socketEcho != null) socketEcho.close();
            } catch (IOException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
            scanner.close();
        }
    }
}
