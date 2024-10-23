package view;

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

public class JLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldIP;
    private JTextField textFieldPorta;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JLogin frame = new JLogin();
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
    public JLogin() {

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
        
        textFieldIP = new JTextField();
        textFieldIP.setFont(new Font("Poppins", Font.PLAIN, 12));
        textFieldIP.setBackground(new Color(220, 220, 220));
        textFieldIP.setBounds(24, 72, 234, 30);
        panel.add(textFieldIP);
        textFieldIP.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("LOGIN");
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
        
        JButton btnNewButton = new JButton("LOGIN");
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
        
        textFieldPorta = new JTextField();
        textFieldPorta.setFont(new Font("Poppins", Font.PLAIN, 12));
        textFieldPorta.setBackground(new Color(220, 220, 220));
        textFieldPorta.setColumns(10);
        textFieldPorta.setBounds(24, 130, 234, 30);
        panel.add(textFieldPorta);
    }
}
