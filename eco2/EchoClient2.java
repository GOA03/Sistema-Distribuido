package eco2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o IP do servidor: ");
        String serverHostname = scanner.nextLine();

        System.out.print("Digite a porta do servidor: ");
        int serverPort = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.println("Tentando conectar ao host " + serverHostname + " na porta " + serverPort + ".");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, serverPort);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Não sei sobre o host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Não consegui obter I/O para a conexão com: " + serverHostname);
            System.exit(1);
        }

        String userInput;

        System.out.println("Digite a mensagem (\"Bye.\" para sair)");
        while (true) {
            userInput = scanner.nextLine();
            out.println(userInput);

            // finaliza o loop
            if (userInput.equals("Bye."))
                break;

            System.out.println("echo: " + in.readLine());
        }

        out.close();
        in.close();
        scanner.close();
        echoSocket.close();
    }
}

