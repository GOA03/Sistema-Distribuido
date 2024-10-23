package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Cliente;
import model.Servidor;

public class JEco extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldSet;
    private JTextField textFieldGet;
    private Cliente cliente;  // Cliente que se comunica com o Servidor

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JEco frame = new JEco();
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
    public JEco() {
        // Cria o Servidor e o Cliente
        Servidor servidor = new Servidor(12345);  // ID do servidor
        cliente = new Cliente("Cliente1", servidor);  // Nome do cliente

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.windowBorder);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(248, 248, 255));
        panel.setBounds(77, 10, 282, 243);
        contentPane.add(panel);
        panel.setLayout(null);
        
        textFieldSet = new JTextField();
        textFieldSet.setFont(new Font("Poppins", Font.ITALIC, 12));
        textFieldSet.setBackground(new Color(220, 220, 220));
        textFieldSet.setBounds(23, 76, 234, 30);
        panel.add(textFieldSet);
        textFieldSet.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("UPPERCASE");
        lblNewLabel.setBackground(new Color(0, 51, 51));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel.setBounds(87, 10, 106, 30);
        panel.add(lblNewLabel);
        
        JLabel lblInsiraOTexto = new JLabel("Insira o texto a ser modificado:");
        lblInsiraOTexto.setHorizontalAlignment(SwingConstants.LEFT);
        lblInsiraOTexto.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblInsiraOTexto.setBackground(new Color(0, 51, 51));
        lblInsiraOTexto.setBounds(23, 43, 217, 30);
        panel.add(lblInsiraOTexto);
        
        JButton buttonModificar = new JButton("MODIFICAR");
        buttonModificar.setFont(new Font("Poppins", Font.BOLD, 12));
        buttonModificar.setBounds(72, 116, 136, 28);
        panel.add(buttonModificar);
        
        JLabel lblTextoModificado = new JLabel("Texto modificado:");
        lblTextoModificado.setHorizontalAlignment(SwingConstants.LEFT);
        lblTextoModificado.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblTextoModificado.setBackground(new Color(0, 51, 51));
        lblTextoModificado.setBounds(23, 147, 217, 30);
        panel.add(lblTextoModificado);
        
        textFieldGet = new JTextField();
        textFieldGet.setFont(new Font("Poppins", Font.PLAIN, 12));
        textFieldGet.setBackground(new Color(220, 220, 220));
        textFieldGet.setColumns(10);
        textFieldGet.setBounds(23, 180, 234, 30);
        panel.add(textFieldGet);

        // Adiciona o ActionListener ao botão
        buttonModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtém o texto do campo textFieldSet
                String texto = textFieldSet.getText();

                // Verifica se o texto é nulo, vazio ou contém apenas espaços
                if (texto == null || texto.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Erro: O campo de texto está vazio.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verifica se o texto ultrapassa um limite de tamanho
                if (texto.length() > 200) {
                    JOptionPane.showMessageDialog(null, "Erro: O texto é muito longo. Limite de 200 caracteres.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verifica se o texto contém apenas caracteres válidos (exemplo com letras e números)
                if (!texto.matches("[\\p{L}0-9 ]+")) {
                    JOptionPane.showMessageDialog(null, "Erro: O texto contém caracteres inválidos.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // Envia a mensagem para o servidor
                    cliente.sendMsg(texto);

                    // Exibe a resposta do servidor no campo de saída
                    textFieldGet.setText(cliente.getLastProcessedMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao enviar mensagem: " + ex.getMessage(), "Erro de Comunicação", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
