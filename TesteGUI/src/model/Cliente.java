package model;

public class Cliente {

    private String name;
    private Servidor server;
    private String lastProcessedMessage;  // Armazena a última mensagem processada
    
    public Cliente(String name, Servidor server) {
        this.name = name;
        this.server = server;
    }

    public void sendMsg(String msg) {
        // Envia a mensagem para o servidor e salva a resposta
        this.lastProcessedMessage = server.collectMsg(msg);
    }

    public String getLastProcessedMessage() {
        return this.lastProcessedMessage;
    }

    public String getName() {
        return name;
    }
}
