package controller;

import model.ServidorModel;
import view.InterfaceServidorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ServidorController {
    private InterfaceServidorView view;
    private ServidorModel model;

    public ServidorController(InterfaceServidorView view, ServidorModel model) {
        this.view = view;
        this.model = model;
        
        // Listener para conectar o servidor
        this.view.adicionarActionListenerConectar(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int porta = Integer.parseInt(view.getPortaServidor().getText());
                try {
                    model.iniciarServidor(porta);
                    view.getRetornoServidor().append("Servidor iniciado na porta: " + porta + "\n");
                    view.getRetornoServidor().append("Esperando conexão...\n");
                    
                    // Aguarda conexão de cliente
                    new Thread(() -> {
                        try {
                            String msgConexao = model.esperarConexao();
                            view.getRetornoServidor().append(msgConexao + "\n");
                            ouvirMensagens();
                        } catch (IOException ex) {
                            view.getRetornoServidor().append("Erro ao aceitar conexão: " + ex.getMessage() + "\n");
                        }
                    }).start();

                } catch (IOException ex) {
                    view.getRetornoServidor().append("Erro ao iniciar servidor: " + ex.getMessage() + "\n");
                }
            }
        });
    }

    // Método para ouvir mensagens do cliente
    private void ouvirMensagens() {
        new Thread(() -> {
            String mensagemRecebida;
            try {
                while ((mensagemRecebida = model.receberMensagem()) != null) {
                    view.getRetornoServidor().append("Cliente: " + mensagemRecebida + "\n");

                    if (mensagemRecebida.equalsIgnoreCase("bye")) {
                        model.enviarMensagem("bye");  // Envia "bye" de volta ao cliente
                        view.getRetornoServidor().append("Cliente desconectou.\n");
                        model.fecharConexao();  // Fecha a conexão com o cliente
                        break;  // Sai do loop e encerra a comunicação com o cliente
                    }

                    // Envia a resposta em maiúsculas para outras mensagens
                    model.enviarResposta(mensagemRecebida);
                }
            } catch (IOException ex) {
                view.getRetornoServidor().append("Erro na conexão: " + ex.getMessage() + "\n");
            } finally {
                try {
                    model.fecharConexao(); // Garante que a conexão do cliente foi fechada
                    view.getRetornoServidor().append("Aguardando nova conexão...\n");
                    // Reinicia o processo de espera por um novo cliente
                    new Thread(() -> {
                        try {
                            String msgConexao = model.esperarConexao();
                            view.getRetornoServidor().append(msgConexao + "\n");
                            ouvirMensagens(); // Começa a ouvir o novo cliente
                        } catch (IOException ex) {
                            view.getRetornoServidor().append("Erro ao aceitar conexão: " + ex.getMessage() + "\n");
                        }
                    }).start();
                } catch (IOException e) {
                    view.getRetornoServidor().append("Erro ao fechar a conexão: " + e.getMessage() + "\n");
                }
            }
        }).start();
    }

}
