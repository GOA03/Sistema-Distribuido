package socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServerSocket serverSocket = null;
        Socket socketCliente = null;
        PrintWriter saida = null;
        BufferedReader entrada = null;

        try {
            // Solicita a porta ao usuário
            System.out.print("Digite a porta para o servidor: ");
            int porta = scanner.nextInt();

            // O servidor escutará em todas as interfaces
            serverSocket = new ServerSocket(porta, 50, InetAddress.getByName("0.0.0.0"));
            System.out.println("Esperando por conexão...");

            while (true) { // Permite aceitar múltiplas conexões
                try {
                    socketCliente = serverSocket.accept();
                    System.out.println("Conexão bem-sucedida.");
                    System.out.println("Aguardando mensagens do cliente...");

                    saida = new PrintWriter(socketCliente.getOutputStream(), true);
                    entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

                    String mensagemRecebida;
                    while ((mensagemRecebida = entrada.readLine()) != null) {
                        if (mensagemRecebida.equalsIgnoreCase("Bye")) {
                            saida.println("Conexão encerrada. Até logo!");
                            break; // Encerra a conexão com este cliente
                        }
                        System.out.println("Cliente: " + mensagemRecebida);
                        saida.println(mensagemRecebida.toUpperCase()); // Retorna em maiúsculas
                    }

                } catch (SocketException e) {
                    // Captura a exceção "Connection reset" sem encerrar o servidor
                    System.err.println("Conexão com o cliente foi encerrada abruptamente: " + e.getMessage());
                } catch (IOException e) {
                    System.err.println("Erro de E/S: " + e.getMessage());
                } finally {
                    // Fechar os recursos para a conexão atual
                    if (saida != null) saida.close();
                    if (entrada != null) entrada.close();
                    if (socketCliente != null) socketCliente.close();
                    System.out.println("Aguardando nova conexão...");
                }
            }

        } catch (IOException e) {
            System.err.println("Erro de E/S no servidor: " + e.getMessage());
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                System.err.println("Erro ao fechar o servidor: " + e.getMessage());
            }
            scanner.close();
        }
    }
}
