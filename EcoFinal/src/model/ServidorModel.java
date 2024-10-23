package model;

import java.io.*;
import java.net.*;

public class ServidorModel {
    private ServerSocket serverSocket;
    private Socket socketCliente;
    private PrintWriter saida;
    private BufferedReader entrada;

    public void iniciarServidor(int porta) throws IOException {
        serverSocket = new ServerSocket(porta, 50, InetAddress.getByName("0.0.0.0"));
    }

    public String esperarConexao() throws IOException {
        socketCliente = serverSocket.accept();
        saida = new PrintWriter(socketCliente.getOutputStream(), true);
        entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
        return "Conexão bem-sucedida com cliente: " + socketCliente.getInetAddress();
    }

    public String receberMensagem() throws IOException {
        return entrada.readLine();
    }

    public void enviarMensagem(String mensagem) {
        if (saida != null) {
            saida.println(mensagem.toUpperCase());
        }
    }
    
    public void enviarResposta(String mensagem) {
        saida.println(mensagem.toUpperCase()); // Envia a mensagem convertida para maiúsculas
    }

    public void fecharConexao() throws IOException {
        if (saida != null) saida.close();
        if (entrada != null) entrada.close();
        if (socketCliente != null) socketCliente.close();
    }

    public void fecharServidor() throws IOException {
        if (serverSocket != null) serverSocket.close();
    }
}
