package teste;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {

        try (// Criação do Scanner para obter IP e porta do usuário
		Scanner input = new Scanner(System.in)) {
			System.out.println("Qual o IP do servidor:");
			String serverIP = input.nextLine();  // Lê o IP do servidor
			
			System.out.println("Qual a porta do servidor:");
			int serverPort = input.nextInt();    // Lê a porta do servidor
			
			Socket echoSocket = null;
			PrintWriter out = null;
			BufferedReader in = null;

			try {
			    // Conectando ao servidor no IP e porta fornecidos pelo usuário
			    echoSocket = new Socket(serverIP, serverPort);
			    
			    // Configurando saída e entrada de dados
			    out = new PrintWriter(echoSocket.getOutputStream(), true);
			    in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

			} catch (UnknownHostException e) {
			    System.err.println("Host desconhecido: " + serverIP);
			    System.exit(1);
			} catch (IOException e) {
			    System.err.println("Não foi possível obter I/O para a conexão com: " + serverIP);
			    System.exit(1);
			}

			// Leitura da entrada do usuário e envio para o servidor
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String userInput;

			System.out.print("Input: ");
			while ((userInput = stdIn.readLine()) != null) {
			    out.println(userInput);  // Enviando para o servidor
			    System.out.println("Echo: " + in.readLine());  // Recebendo resposta do servidor
			    System.out.print("Input: ");
			}

			// Fechando streams e socket
			out.close();
			in.close();
			stdIn.close();
			echoSocket.close();
		}
    }
}
