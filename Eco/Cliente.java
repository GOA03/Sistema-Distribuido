package Eco;

public class Cliente {

    private String name;
    private Servidor server;
    
    public Cliente(String name, Servidor server) {
        this.name = name;
        this.server = server;
    }

    public void sendMsg(String msg) {
        // Envia a mensagem para o servidor e exibe a resposta
        showMsg(server.collectMsg(msg));
    }
    
    private void showMsg(String msg) {
        System.out.println(" > " + msg);
    }

	public String getName() {
		return name;
	}
}
