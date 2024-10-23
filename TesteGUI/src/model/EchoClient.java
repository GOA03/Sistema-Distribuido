package model;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {

        String serverHostname = new String ("127.0.0.1"); // MUDAR ---------------------
    	Scanner input = new Scanner(System.in);
    	
    	if (args.length > 0)
            serverHostname = args[0];
         System.out.println ("Attemping to connect to host " +
 		serverHostname + " on port 10007.");

         Socket echoSocket = null;
         PrintWriter out = null;
         BufferedReader in = null;
    	try {
    		
    		System.out.println("Qual o IP do servidor:");
    		BufferReader br = new BufferReader(new InputReader(System.in));
    		String serverIP = br.readLine();
    				
    		System.out.println("Qual a porta do servidor:");
    		br = new BufferReader(new InputReader(System.in));
    		int serverPort = Integer.parseInt(br.readLine());	
    		
    		System.out.println("Tentando conectar..." + serverIP);
    		
    		ClientSocket = new Socket(serverIP, serverPort);
    		
    		in = new DataInputS
    		in = new BufferedReader(new InputStreamReader( // CANOS PEQUENOS -------
    		out = new PrintWriter(echoSocket.getOutputStream(), true); // CANOS PEQUENOS -------
    		
    	} finally {
    		
    	}
        
        
        

     // PERGUNTAR A  IP E PORTA
        
        try {
            // echoSocket = new Socket("taranis", 7);
            echoSocket = new Socket(serverHostname, 10007); // MUDAR ---------------------
            out = new PrintWriter(echoSocket.getOutputStream(), true); // CANOS PEQUENOS -------
            in = new BufferedReader(new InputStreamReader( // CANOS PEQUENOS -------
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + serverHostname);
            System.exit(1);
        }

	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;

        System.out.print ("input: ");
	while ((userInput = stdIn.readLine()) != null) { // !SEMPRE FAZER ESSA LEITURA PARA INPUT ==========
	    out.println(userInput);
	    System.out.println("echo: " + in.readLine());
            System.out.print ("input: ");
	}

	out.close();
	in.close();
	stdIn.close();
	echoSocket.close();
    }
}
