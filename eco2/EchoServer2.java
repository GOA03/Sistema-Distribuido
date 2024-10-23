package eco2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EchoServer2 extends Thread {
    protected Socket clientSocket;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a porta do servidor: ");
        int serverPort = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Socket do servidor criado");
            try {
                while (true) {
                    System.out.println("Aguardando conexão");
                    new EchoServer2(serverSocket.accept());
                }
            } catch (IOException e) {
                System.err.println("Falha ao aceitar.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Não foi possível escutar na porta: " + serverPort + ".");
            System.exit(1);
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                System.err.println("Não foi possível fechar a porta: " + serverPort + ".");
                System.exit(1);
            }
        }
    }

    private EchoServer2(Socket clientSoc) {
        clientSocket = clientSoc;
        start();
    }

    public void run() {
        System.out.println("Novo thread de comunicação iniciado");

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Servidor: " + inputLine);
                // Converte a mensagem para maiúsculas antes de enviar de volta
                out.println(inputLine.toUpperCase());

                if (inputLine.equals("Bye."))
                    break;
            }

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Problema com a comunicação do servidor");
            System.exit(1);
        }
    }
}
