package socket;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField enderecoServidor;
    private JTextField porta;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JCliente frame = new JCliente();
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
    public JCliente() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 275);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.windowBorder);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(248, 248, 255));
        panel.setBounds(77, 10, 282, 222);
        contentPane.add(panel);
        panel.setLayout(null);
        
        enderecoServidor = new JTextField();
        enderecoServidor.setFont(new Font("Poppins", Font.PLAIN, 12));
        enderecoServidor.setBackground(new Color(220, 220, 220));
        enderecoServidor.setBounds(24, 72, 234, 30);
        panel.add(enderecoServidor);
        enderecoServidor.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Cliente");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 16));
        lblNewLabel.setBounds(24, 15, 234, 30);
        lblNewLabel.setBackground(new Color(220, 220, 220));
        panel.add(lblNewLabel);
        
        JLabel lblInsiraOTexto = new JLabel("IP");
        lblInsiraOTexto.setHorizontalAlignment(SwingConstants.LEFT);
        lblInsiraOTexto.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblInsiraOTexto.setBackground(new Color(0, 51, 51));
        lblInsiraOTexto.setBounds(23, 45, 217, 30);
        panel.add(lblInsiraOTexto);
        
        JButton btnNewButton = new JButton("ENTRAR");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnNewButton.setBounds(73, 175, 136, 30);
        panel.add(btnNewButton);
        
        JLabel lblTextoModificado = new JLabel("PORTA");
        lblTextoModificado.setHorizontalAlignment(SwingConstants.LEFT);
        lblTextoModificado.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblTextoModificado.setBackground(new Color(0, 51, 51));
        lblTextoModificado.setBounds(23, 105, 217, 30);
        panel.add(lblTextoModificado);
        
        porta = new JTextField();
        porta.setFont(new Font("Poppins", Font.PLAIN, 12));
        porta.setBackground(new Color(220, 220, 220));
        porta.setColumns(10);
        porta.setBounds(24, 130, 234, 30);
        panel.add(porta);
    }
}
