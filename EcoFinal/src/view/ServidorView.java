package view;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServidorView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField portaField;
    private JButton btnIniciar;
    private String porta; // Variável para armazenar o valor da porta

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ServidorView frame = new ServidorView();
                    frame.setLocationRelativeTo(null); // Centraliza a janela
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ServidorView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 373, 218);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.windowBorder);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(248, 248, 255));
        panel.setBounds(38, 7, 282, 166);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Servidor");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 16));
        lblNewLabel.setBounds(24, 15, 234, 30);
        panel.add(lblNewLabel);

        btnIniciar = new JButton("ENTRAR");
        btnIniciar.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnIniciar.setBounds(73, 118, 136, 30);
        panel.add(btnIniciar);

        JLabel lblTextoModificado = new JLabel("PORTA");
        lblTextoModificado.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblTextoModificado.setBounds(24, 48, 217, 30);
        panel.add(lblTextoModificado);

        portaField = new JTextField();
        portaField.setFont(new Font("Poppins", Font.PLAIN, 12));
        portaField.setBackground(new Color(220, 220, 220));
        portaField.setColumns(10);
        portaField.setBounds(24, 73, 234, 30);
        panel.add(portaField);

        // Listener para capturar o valor inserido no campo de texto
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                porta = portaField.getText(); // Armazena o valor da porta
                System.out.println("Porta inserida: " + porta);
            }
        });
    }

    public JTextField getPortaField() {
        return portaField;
    }

    public JButton getBtnIniciar() {
        return btnIniciar;
    }

    public String getPorta() {
        return porta;
    }
}
