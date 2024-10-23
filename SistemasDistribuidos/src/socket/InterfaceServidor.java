package socket;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class InterfaceServidor extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField entradaMsgServidor;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfaceServidor frame = new InterfaceServidor();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public InterfaceServidor() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 810, 515);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.windowBorder);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Painel Principal
        JPanel painelCliente = new JPanel();
        painelCliente.setBorder(UIManager.getBorder("Button.border"));
        painelCliente.setBackground(new Color(255, 255, 255));
        painelCliente.setBounds(10, 8, 776, 461);
        contentPane.add(painelCliente);
        painelCliente.setLayout(null);

        // Botão Enviar
        JButton btnEnviar = new JButton("ENVIAR");
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /* 
                String mensagem = entradaMsgCliente.getText();
                if (!mensagem.isEmpty()) {
                    // Exibir a mensagem no painel de retorno
                    retornoCliente.setText(retornoCliente.getText() + "\nVocê: " + mensagem);
                    entradaMsgCliente.setText("");
                } */
            }
        });
        btnEnviar.setFont(new Font("Poppins", Font.BOLD, 12));
        btnEnviar.setBackground(new Color(1, 205, 52));
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setBounds(685, 405, 85, 46);
        painelCliente.add(btnEnviar);

        // Título "Cliente"
        JLabel lblNewLabel = new JLabel("Servidor");
        lblNewLabel.setForeground(new Color(2, 2, 2));
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 24));
        lblNewLabel.setBounds(10, 10, 122, 30);
        lblNewLabel.setBackground(new Color(0, 128, 128));
        painelCliente.add(lblNewLabel);

        // Área de retorno de mensagens (histórico)
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 760, 345);
        painelCliente.add(scrollPane);
        
        JTextPane retornoServidor = new JTextPane();
        retornoServidor.setEditable(false);
        retornoServidor.setBackground(new Color(234, 234, 234));
        scrollPane.setViewportView(retornoServidor);

        // Campo de entrada de texto para nova mensagem
        entradaMsgServidor = new JTextField();
        entradaMsgServidor.setFont(new Font("Poppins", Font.PLAIN, 14));
        entradaMsgServidor.setBounds(10, 405, 665, 46);
        painelCliente.add(entradaMsgServidor);
        entradaMsgServidor.setColumns(10);
    }
}
