package model;

import java.io.*;
import java.net.*;

public class ClienteModel {
    private Socket socketEcho;
    private PrintWriter saida;
    private BufferedReader entrada;

    public void conectar(String ip, int porta) throws IOException {
        socketEcho = new Socket(ip, porta);
        saida = new PrintWriter(socketEcho.getOutputStream(), true);
        entrada = new BufferedReader(new InputStreamReader(socketEcho.getInputStream()));
    }

    public void enviarMensagem(String mensagem) throws IOException {
        saida.println(mensagem);
    }

    public String receberResposta() throws IOException {
        return entrada.readLine();
    }

    public void fecharConexao() throws IOException {
        if (saida != null) saida.close();
        if (entrada != null) entrada.close();
        if (socketEcho != null) socketEcho.close();
    }
}
