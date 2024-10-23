package teste;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (// Usando Scanner para perguntar a porta ao usuário
		Scanner input = new Scanner(System.in)) {
			System.out.println("Informe a porta para o servidor escutar:");
			int port = input.nextInt();  // Lê a porta do usuário

			ServerSocket serverSocket = null;

			try {
			    // Criação do ServerSocket com a porta fornecida
			    serverSocket = new ServerSocket(port);
			} catch (IOException e) {
			    System.err.println("Não foi possível escuta3r na porta: " + port);
			    System.exit(1);
			}

			Socket clientSocket = null;
			System.out.println("Aguardando conexão...");

			try {
			    // Aceita a conexão do cliente
			    clientSocket = serverSocket.accept();
			} catch (IOException e) {
			    System.err.println("Falha ao aceitar conexão.");
			    System.exit(1);
			}

			System.out.println("Conexão bem-sucedida!");
			System.out.println("Aguardando entrada...");

			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			String inputLine;

			// Recebe mensagens do cliente e as envia de volta (Eco)
			while ((inputLine = in.readLine()) != null) {
			    System.out.println("Servidor recebeu: " + inputLine);
			    out.println(inputLine);  // Enviando de volta ao cliente
			    
			    if (inputLine.equals("Bye.")) {
			        break;  // Encerra o loop se a mensagem for "Bye."
			    }
			}

			// Fechando streams e sockets
			out.close();
			in.close();
			clientSocket.close();
			serverSocket.close();
		}
    }
}
