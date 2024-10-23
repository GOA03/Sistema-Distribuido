package model;

public class Servidor {

    private long id;
    
    public Servidor(long id) {
        this.id = id;
    }

    public String collectMsg(String msg) {
        return upperMsg(msg); // Chama o método para converter a mensagem
    }
    
    private String upperMsg(String msg) {
        System.out.println("> Servidor: " + this.id);
        return msg.toUpperCase(); // Converte a mensagem para maiúsculas
    }
}
